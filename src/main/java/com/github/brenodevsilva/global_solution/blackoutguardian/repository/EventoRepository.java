package com.github.brenodevsilva.global_solution.blackoutguardian.repository;

import com.github.brenodevsilva.global_solution.blackoutguardian.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByCidadeIgnoreCase(String cidade);
}
