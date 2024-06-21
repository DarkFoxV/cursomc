package com.darkfoxv.cursomc.services;

import com.darkfoxv.cursomc.domain.Endereco;
import com.darkfoxv.cursomc.repositories.EnderecoRepository;
import com.darkfoxv.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository ederecoRepository;

    public List<Endereco> findAll() {
        return ederecoRepository.findAll();
    }

    public Endereco findById(Long id) {
        return ederecoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cannot find category" + id));
    }

    public Endereco insert(Endereco endereco) {
        return ederecoRepository.save(endereco);
    }

}
