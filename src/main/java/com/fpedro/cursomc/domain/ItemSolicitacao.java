package com.fpedro.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemSolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private ItemSolicitacaoPK id = new ItemSolicitacaoPK();
	
	
	private Double desconto;
	private Integer quantidade;
	private Double preco;

	public ItemSolicitacao() {

	}

	public ItemSolicitacao(Solicitacao solicitacao, Usuario usuario, Double desconto, Integer quantidade,
			Double preco) {
		super();
		id.setSolicitacao(solicitacao);
		id.setUsuario(usuario);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;

	}

	public Solicitacao getSolicitacao() {
		return id.getSolicitacao();
	}

	public Usuario getUsuario() {
		return id.getUsuario();
	}

	public ItemSolicitacaoPK getId() {
		return id;
	}

	public void setId(ItemSolicitacaoPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
