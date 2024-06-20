package com.darkfoxv.cursomc.services;

import com.darkfoxv.cursomc.domain.Categoria;
import com.darkfoxv.cursomc.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).get();
    }

    public Categoria insert(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

}
