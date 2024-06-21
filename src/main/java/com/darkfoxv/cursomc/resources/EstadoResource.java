package com.darkfoxv.cursomc.resources;

import com.darkfoxv.cursomc.domain.Estado;
import com.darkfoxv.cursomc.repositories.EstadoRepository;
import com.darkfoxv.cursomc.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/states")
public class EstadoResource {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> listar() {
        List<Estado> list = estadoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estado> buscar(@PathVariable Long id) {
        Estado obj = estadoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
