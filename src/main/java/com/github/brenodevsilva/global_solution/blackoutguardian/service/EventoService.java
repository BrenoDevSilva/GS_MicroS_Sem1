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
        evento.setCidade(dto.cidade);
        evento.setBairro(dto.bairro);
        evento.setDataHoraInicio(dto.dataHoraInicio);
        evento.setDataHoraFim(dto.dataHoraFim);
        evento.setDescricaoPrejuizo(dto.descricaoPrejuizo);

        Evento salvo = eventoRepository.save(evento);

        return toResponseDTO(salvo);
    }

    public List<EventoResponseDTO> listarTodosEventos() {
        return eventoRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<EventoResponseDTO> listarEventosPorCidade(String cidade) {
        return eventoRepository.findByCidadeIgnoreCase(cidade).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private EventoResponseDTO toResponseDTO(Evento evento) {
        EventoResponseDTO dto = new EventoResponseDTO();
        dto.id = evento.getId();
        dto.cidade = evento.getCidade();
        dto.bairro = evento.getBairro();
        dto.dataHoraInicio = evento.getDataHoraInicio();
        dto.dataHoraFim = evento.getDataHoraFim();
        dto.descricaoPrejuizo = evento.getDescricaoPrejuizo();
        return dto;
    }
}
