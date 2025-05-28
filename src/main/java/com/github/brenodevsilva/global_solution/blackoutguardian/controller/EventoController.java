package com.github.brenodevsilva.global_solution.blackoutguardian.controller;

import com.github.brenodevsilva.global_solution.blackoutguardian.model.Evento;
import com.github.brenodevsilva.global_solution.blackoutguardian.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    // POST /api/eventos
    @PostMapping
    public ResponseEntity<Evento> criarEvento(@RequestBody Evento evento) {
        Evento novoEvento = eventoService.cadastrarEvento(evento);
        return ResponseEntity.ok(novoEvento);
    }

    // GET /api/eventos
    @GetMapping
    public ResponseEntity<List<Evento>> listarEventos() {
        List<Evento> eventos = eventoService.listarTodosEventos();
        return ResponseEntity.ok(eventos);
    }

    // GET /api/eventos/{cidade}
    @GetMapping("/{cidade}")
    public ResponseEntity<List<Evento>> listarPorCidade(@PathVariable String cidade) {
        List<Evento> eventos = eventoService.listarEventosPorCidade(cidade);
        return ResponseEntity.ok(eventos);
    }
}
