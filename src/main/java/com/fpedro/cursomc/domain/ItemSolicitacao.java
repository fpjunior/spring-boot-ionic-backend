package com.fpedro.cursomc.domain;

public class ItemSolicitacao {

	private ItemSolicitacaoPK id = new ItemSolicitacaoPK();

	private Double desconto;
	private Integer quantidade;
	private Double preco;

	public ItemSolicitacao() {

	}

	public ItemSolicitacao(Solicitacao solicitacao, Usuario usuario, Double desconto, Integer quantidade, Double preco) {
		super();
		id.setSolicitacao(solicitacao);
		id.setUsuario(usuario);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;

	}
	

}
