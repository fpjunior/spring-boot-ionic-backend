package com.fpedro.cursomc;

import java.util.Arrays;

import com.fpedro.cursomc.domain.Categoria;
import com.fpedro.cursomc.domain.Cidade;
import com.fpedro.cursomc.domain.Cliente;
import com.fpedro.cursomc.domain.Endereco;
import com.fpedro.cursomc.domain.Estado;
import com.fpedro.cursomc.domain.Usuario;
import com.fpedro.cursomc.enums.TipoCliente;
import com.fpedro.cursomc.repositories.CategoriaRepository;
import com.fpedro.cursomc.repositories.CidadeRepository;
import com.fpedro.cursomc.repositories.ClienteRepository;
import com.fpedro.cursomc.repositories.EnderecoRepository;
import com.fpedro.cursomc.repositories.EstadoRepository;
import com.fpedro.cursomc.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Motorista");
		Categoria cat2 = new Categoria(null, "Carona");

		Usuario p1 = new Usuario(null, "Fernando", 33);
		Usuario p2 = new Usuario(null, "Renato", 32);
		Usuario p3 = new Usuario(null, "Andreson", 35);
		Usuario p4 = new Usuario(null, "Arthur", 25);

		cat1.getUsuarios().addAll(Arrays.asList(p1, p4));
		cat2.getUsuarios().addAll(Arrays.asList(p1, p2, p3, p4));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
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


		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		usuarioRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

		Cliente cli1 = new Cliente(null, "Fernando Pedro", "email@email.com", "06848578479", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("99307312", "982991925"));

		Endereco e1 = new Endereco(null, "Rua Joaquim Bezerra", "194", "Centro", "33435989", null, cli1, c1 );
		Endereco e2 = new Endereco(null, "Rua aldeia velha", "304", "Muribará", "9883598", null, cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));


	}

}
