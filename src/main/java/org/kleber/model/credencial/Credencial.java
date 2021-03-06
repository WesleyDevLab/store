package org.kleber.model.credencial;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.kleber.model.Model;
import org.kleber.model.autorizacao.Autorizacao;

@Entity
public class Credencial extends Model {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nome;
	
	@OneToMany(fetch =  FetchType.EAGER)
	private List<Autorizacao> autorizacoes;
	
	@Column
	private Date expirationDate;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
