package com.darkfoxv.cursomc.config;

import com.darkfoxv.cursomc.domain.Categoria;
import com.darkfoxv.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public void run(String... args) {
        Categoria cat1 = new Categoria(1L, "Informática");
        Categoria cat2 = new Categoria(2L, "Escritório");
        categoriaService.insert(cat1);
        categoriaService.insert(cat2);
    }
}
