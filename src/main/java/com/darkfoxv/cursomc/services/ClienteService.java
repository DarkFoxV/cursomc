package com.darkfoxv.cursomc.services;

import com.darkfoxv.cursomc.domain.Cliente;
import com.darkfoxv.cursomc.repositories.ClienteRepository;
import com.darkfoxv.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository ClienteRepository;

    public List<Cliente> findAll() {
        return ClienteRepository.findAll();

    }

    public Cliente findById(Long id) {
        return ClienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cannot find category" + id));
    }

    public Cliente insert(Cliente cliente) {
        return ClienteRepository.save(cliente);
    }

}
