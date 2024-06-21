package com.darkfoxv.cursomc.services;

import com.darkfoxv.cursomc.domain.Estado;
import com.darkfoxv.cursomc.repositories.EstadoRepository;
import com.darkfoxv.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll(){
        return estadoRepository.findAll();
    }

    public Estado findById(Long id) {
        return estadoRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Cannot find state" + id));
    }

    public Estado insert(Estado produto) {
        return estadoRepository.save(produto);
    }

}
