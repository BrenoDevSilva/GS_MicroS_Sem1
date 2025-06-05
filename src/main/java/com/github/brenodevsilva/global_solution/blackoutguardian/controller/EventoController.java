package com.github.brenodevsilva.global_solution.blackoutguardian.controller;

import com.github.brenodevsilva.global_solution.blackoutguardian.dto.EventoRequestDTO;
import com.github.brenodevsilva.global_solution.blackoutguardian.dto.EventoResponseDTO;
import com.github.brenodevsilva.global_solution.blackoutguardian.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity<EventoResponseDTO> criarEvento(@RequestBody @Valid EventoRequestDTO dto) {
        EventoResponseDTO response = eventoService.cadastrarEvento(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<EventoResponseDTO>> listarEventos() {
        List<EventoResponseDTO> eventos = eventoService.listarTodosEventos();
        return ResponseEntity.ok(eventos);
    }


    @GetMapping("/{cidade}")
    public ResponseEntity<List<EventoResponseDTO>> listarPorCidade(@PathVariable String cidade) {
        return ResponseEntity.ok(eventoService.listarEventosPorCidade(cidade));
    }
}
