package com.darkfoxv.cursomc.services;

import com.darkfoxv.cursomc.domain.Produto;
import com.darkfoxv.cursomc.repositories.ProdutoRepository;
import com.darkfoxv.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Cannot find product" + id));
    }

    public Produto insert(Produto produto) {
        return produtoRepository.save(produto);
    }

}
