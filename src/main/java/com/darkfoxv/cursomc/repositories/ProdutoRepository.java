package com.darkfoxv.cursomc.repositories;

import com.darkfoxv.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
