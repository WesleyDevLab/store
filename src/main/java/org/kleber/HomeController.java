package org.kleber;

import java.util.ArrayList;
import java.util.List;

import org.kleber.model.categoria.CategoriaService;
import org.kleber.model.pagina.PaginaService;
import org.kleber.model.produto.ProdutoService;
import org.kleber.model.usuario.UsuarioService;
import org.kleber.settings.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Autowired
	private CategoriaService categoria;
	
	@Autowired
	private ProdutoService produto;
	
	@Autowired
	private PaginaService pagina;
	
	@Autowired
	private UsuarioService usuario;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/signin")
	public String signin() {
		return "signin";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping("/admin")
	@PreAuthorize("hasPermission(#user, 'admin')")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/c/{id}")
	public String categoria(Model model, @PathVariable("id") String id) {
		model.addAttribute("categoria", categoria.getObject(id));
		return "categoria";
	}
	
	@RequestMapping("/p/{id}")
	public String produto(Model model, @PathVariable("id") String id) {
		model.addAttribute("produto", produto.getObject(id));
		return "produto";
	}
	
	@RequestMapping("/page/{titulo}")
	public String pagina(Model model, @PathVariable("titulo") String titulo) {
		model.addAttribute("pagina", null);
		return "pagina";
	}
	
	@RequestMapping("/cart")
	public String cart() {
		return "cart";
	}
	
	@RequestMapping("/wishlist")
	public String wishlist() {
		return "wishlist";
	}
	
	@RequestMapping("/order")
	public String order() {
		return "order";
	}
	
	@RequestMapping("/settings")
	public String settings(Model model) throws InstantiationException, IllegalAccessException {
		model.addAttribute("settings", settings());
		model.addAttribute("setting", settings().get(0).newInstance());
		return "admin";
	}
	
	private List<Class<?>> settings() {
		List<Class<?>> list = new ArrayList<Class<?>>();
		
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
		scanner.addIncludeFilter(new AnnotationTypeFilter(org.kleber.annotation.class_type.Property.class));
		for (BeanDefinition bd : scanner.findCandidateComponents("org.kleber.settings")) {
			Class<?> clazz;
			try {
				clazz = Class.forName(bd.getBeanClassName());
			} catch (ClassNotFoundException e) {
				clazz = null;
			}
			list.add(clazz);
		}
		
		return list;
	}
}
