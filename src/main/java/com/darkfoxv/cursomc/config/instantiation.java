package com.darkfoxv.cursomc.config;

import com.darkfoxv.cursomc.domain.Categoria;
import com.darkfoxv.cursomc.domain.Cidade;
import com.darkfoxv.cursomc.domain.Estado;
import com.darkfoxv.cursomc.domain.Produto;
import com.darkfoxv.cursomc.repositories.CategoriaRepository;

import com.darkfoxv.cursomc.repositories.CidadeRepository;
import com.darkfoxv.cursomc.repositories.EstadoRepository;
import com.darkfoxv.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;


    @Override
    public void run(String... args) {
        Categoria cat1 = new Categoria(1L, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.0);
        Produto p2 = new Produto(null, "Impressora", 800.0);
        Produto p3 = new Produto(null, "Mouse", 80.0);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().add(p2);

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().add(cat1);

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado e1 = new Estado(null, "São Paulo");
        Estado e2 = new Estado(null, "Minas Gerais");
        estadoRepository.saveAll(Arrays.asList(e1, e2));

        Cidade c1 = new Cidade(null, "São Paulo", e1);
        Cidade c2 = new Cidade(null, "Uberlândia", e2);
        Cidade c3 = new Cidade(null, "Campinas", e2);
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

    }
}
