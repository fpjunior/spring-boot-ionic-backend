package com.fpedro.cursomc;

import java.util.Arrays;

import com.fpedro.cursomc.domain.Categoria;
import com.fpedro.cursomc.domain.Usuario;
import com.fpedro.cursomc.repositories.CategoriaRepository;
import com.fpedro.cursomc.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository	categoriaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Motorista");
		Categoria cat2 = new Categoria(null, "Carona");
		
		Usuario p1 = new Usuario(null, "Fernando", 33);
		Usuario p2 = new Usuario(null, "Renato", 32 );
		Usuario p3 = new Usuario(null, "Andreson", 35);
		Usuario p4 = new Usuario(null, "Arthur", 25);
		
		cat1.getUsuarios().addAll(Arrays.asList(p1, p2, p3));
		cat2.getUsuarios().addAll(Arrays.asList(p1, p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1, cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		usuarioRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
	}

}

