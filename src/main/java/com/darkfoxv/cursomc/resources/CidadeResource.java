package com.darkfoxv.cursomc.resources;

import com.darkfoxv.cursomc.domain.Cidade;
import com.darkfoxv.cursomc.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CidadeResource {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<Cidade>> listar() {
        List<Cidade> list = cidadeService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long id) {
        Cidade obj = cidadeService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
