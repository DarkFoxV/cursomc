package com.darkfoxv.cursomc.repositories;

import com.darkfoxv.cursomc.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
