package com.github.brenodevsilva.global_solution.blackoutguardian.dto;

import java.time.LocalDateTime;

public class EventoResponseDTO {
    public Long id;
    public String cidade;
    public String bairro;
    public LocalDateTime dataHoraInicio;
    public LocalDateTime dataHoraFim;
    public String descricaoPrejuizo;
}
