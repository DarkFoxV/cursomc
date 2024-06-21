package com.darkfoxv.cursomc.repositories;

import com.darkfoxv.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
