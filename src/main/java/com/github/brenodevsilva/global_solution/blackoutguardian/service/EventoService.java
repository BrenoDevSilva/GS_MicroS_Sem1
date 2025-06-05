package com.github.brenodevsilva.global_solution.blackoutguardian.service;

import com.github.brenodevsilva.global_solution.blackoutguardian.dto.EventoRequestDTO;
import com.github.brenodevsilva.global_solution.blackoutguardian.dto.EventoResponseDTO;
import com.github.brenodevsilva.global_solution.blackoutguardian.model.Evento;
import com.github.brenodevsilva.global_solution.blackoutguardian.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public EventoResponseDTO cadastrarEvento(EventoRequestDTO dto) {
        Evento evento = new Evento();
        evento.setCidade(dto.getCidade());
        evento.setBairro(dto.getBairro());
        evento.setDataHoraInicio(dto.getDataHoraInicio());
        evento.setDataHoraFim(dto.getDataHoraFim());
        evento.setDescricaoPrejuizo(dto.getDescricaoPrejuizo());

        Evento salvo = eventoRepository.save(evento);

        return new EventoResponseDTO(salvo);
    }

    public List<EventoResponseDTO> listarTodosEventos() {
        return eventoRepository.findAll().stream()
                .map(EventoResponseDTO::new)
                .collect(Collectors.toList());
    }

    public List<EventoResponseDTO> listarEventosPorCidade(String cidade) {
        return eventoRepository.findByCidadeIgnoreCase(cidade).stream()
                .map(EventoResponseDTO::new)
                .collect(Collectors.toList());
    }
}
