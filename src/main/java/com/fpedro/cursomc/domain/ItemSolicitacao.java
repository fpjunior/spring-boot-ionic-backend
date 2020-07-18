package com.fpedro.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemSolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemSolicitacaoPK id = new ItemSolicitacaoPK();

	private Double desconto;
	private Integer quantidade;
	private Double preco;

	public ItemSolicitacao() {

	}

	public ItemSolicitacao(Solicitacao solicitacao, Produto Produto, Double desconto, Integer quantidade,
			Double preco) {
		super();
		id.setSolicitacao(solicitacao);
		id.setProduto(Produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;

	}
	
	@JsonIgnore
	public Solicitacao getSolicitacao() {
		return id.getSolicitacao();
	}
	
	
	public Produto getProduto() {
		return id.getProduto();
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
