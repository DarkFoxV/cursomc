package com.darkfoxv.cursomc.resources;

import com.darkfoxv.cursomc.domain.Pedido;
import com.darkfoxv.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        List<Pedido> list = pedidoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
        Pedido obj = pedidoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
