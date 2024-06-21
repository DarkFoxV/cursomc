package com.darkfoxv.cursomc.services;

import com.darkfoxv.cursomc.domain.Pedido;
import com.darkfoxv.cursomc.repositories.PedidoRepository;
import com.darkfoxv.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Cannot find product" + id));
    }

    public Pedido insert(Pedido produto) {
        return pedidoRepository.save(produto);
    }

}
