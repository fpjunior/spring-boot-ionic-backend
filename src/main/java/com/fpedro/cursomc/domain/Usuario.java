package com.fpedro.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer idade;

	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "USUARIO_CATEGORIA", 
		joinColumns = @JoinColumn(name = "usuario_id"), 
		inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	
	private List<Categoria> categorias = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.usuario")
	private Set<ItemSolicitacao> itens = new HashSet<>();

	public Usuario() {

	}

	public Usuario(Integer id, String nome, Integer idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}
	
	@JsonIgnore
	public List<Solicitacao>  getSolicitacoes(){
		List<Solicitacao> lista = new ArrayList<>();
		for (ItemSolicitacao x : itens) {
			lista.add(x.getSolicitacao());
		}
		return lista;
	}

	public Integer getId() {
		return id;
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

	public Integer getidade() {
		return idade;
	}

	public void setidade(Integer idade) {
		this.idade = idade;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<ItemSolicitacao> getItens() {
		return itens;
	}

	public void setItens(Set<ItemSolicitacao> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
