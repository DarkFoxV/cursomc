package com.darkfoxv.cursomc.services;

import com.darkfoxv.cursomc.domain.Cidade;
import com.darkfoxv.cursomc.repositories.CidadeRepository;
import com.darkfoxv.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    public Cidade findById(Long id) {
        return cidadeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cannot find city" + id));
    }

    public Cidade insert(Cidade produto) {
        return cidadeRepository.save(produto);
    }

}
