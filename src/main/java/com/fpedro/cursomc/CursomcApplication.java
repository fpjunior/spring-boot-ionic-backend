package com.fpedro.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fpedro.cursomc.domain.Categoria;
import com.fpedro.cursomc.domain.Cidade;
import com.fpedro.cursomc.domain.Cliente;
import com.fpedro.cursomc.domain.Endereco;
import com.fpedro.cursomc.domain.Estado;
import com.fpedro.cursomc.domain.ItemSolicitacao;
import com.fpedro.cursomc.domain.Pagamento;
import com.fpedro.cursomc.domain.PagamentoComBoleto;
import com.fpedro.cursomc.domain.PagamentoComCartao;
import com.fpedro.cursomc.domain.Solicitacao;
import com.fpedro.cursomc.domain.Produto;
import com.fpedro.cursomc.enums.EstadoPagamento;
import com.fpedro.cursomc.enums.TipoCliente;
import com.fpedro.cursomc.repositories.CategoriaRepository;
import com.fpedro.cursomc.repositories.CidadeRepository;
import com.fpedro.cursomc.repositories.ClienteRepository;
import com.fpedro.cursomc.repositories.EnderecoRepository;
import com.fpedro.cursomc.repositories.EstadoRepository;
import com.fpedro.cursomc.repositories.ItemSolicitacaoRepository;
import com.fpedro.cursomc.repositories.PagamentoRepository;
import com.fpedro.cursomc.repositories.SolicitacaoRepository;
import com.fpedro.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository ProdutoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private SolicitacaoRepository solicitacaoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemSolicitacaoRepository itemSolicitacaoRepository;

	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Motorista");
		Categoria cat2 = new Categoria(null, "Carona");
		Categoria cat3 = new Categoria(null, "Administrador");
		Categoria cat4 = new Categoria(null, "Administrador 2");
		Categoria cat5 = new Categoria(null, "Administrador 3");
		Categoria cat6 = new Categoria(null, "Administrador 4");
		Categoria cat7 = new Categoria(null, "Administrador 5");

		Produto p1 = new Produto(null, "Fernando", 33);
		Produto p2 = new Produto(null, "Renato", 32);
		Produto p3 = new Produto(null, "Andreson", 35);
		Produto p4 = new Produto(null, "Arthur", 25);

		cat1.getProdutos().addAll(Arrays.asList(p1, p4));
		cat2.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4));
		cat3.getProdutos().addAll(Arrays.asList(p1));
		cat4.getProdutos().addAll(Arrays.asList(p1));
		cat5.getProdutos().addAll(Arrays.asList(p1));
		cat6.getProdutos().addAll(Arrays.asList(p1));
		cat6.getProdutos().addAll(Arrays.asList(p1));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat1, cat2));

		Estado est1 = new Estado(null, "Pernambuco");
		Estado est2 = new Estado(null, "Parabíba");
		Estado est3 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Carpina", est1);
		Cidade c2 = new Cidade(null, "João Pessoa", est2);
		Cidade c3 = new Cidade(null, "Campinas", est3);
		Cidade c4 = new Cidade(null, "Recife", est1);

		est1.getCidades().addAll(Arrays.asList(c1, c4));
		est2.getCidades().addAll(Arrays.asList(c2));
		est3.getCidades().addAll(Arrays.asList(c3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		ProdutoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

		Cliente cli1 = new Cliente(null, "Fernando Pedro", "email@email.com", "06848578479", TipoCliente.PESSOAFISICA);

		Cliente cli2 = new Cliente(null, "Renato Valentin", "renato@email.com", "32548578479",
				TipoCliente.PESSOAFISICA);
		Cliente cli3 = new Cliente(null, "Arthur Vinícius", "arthur@email.com", "32548578479",
				TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("99307312", "982991925"));
		cli2.getTelefones().addAll(Arrays.asList("92565897", "989988522"));
		cli3.getTelefones().addAll(Arrays.asList("99898987", "997888985"));

		Endereco e1 = new Endereco(null, "Rua Joaquim Bezerra", "194", "Centro", "33435989", null, cli1, c1);
		Endereco e2 = new Endereco(null, "Rua aldeia velha", "304", "Muribará", "9883598", null, cli2, c2);
		Endereco e3 = new Endereco(null, "Rua Joaquim Bezerra", "194", "Centro", "33435989", null, cli3, c3);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2, e3));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		Solicitacao ped1 = new Solicitacao (null, sdf.parse("30/02/2020 10:15"), cli1, e1);
		Solicitacao ped2 = new Solicitacao (null, sdf.parse("20/02/2020 08:15"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),null);
		ped2.setPagamento(pagto2);
		
		cli1.getSolicitacao().addAll(Arrays.asList(ped1, ped2));
		
		solicitacaoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemSolicitacao ip1 = new ItemSolicitacao(ped1, p1, 0.00, 1, 2000.00);
		ItemSolicitacao ip2 = new ItemSolicitacao(ped1, p3, 0.00, 2, 80.00);
		ItemSolicitacao ip3 = new ItemSolicitacao(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		
		itemSolicitacaoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
		
		
		
	}


	

}
