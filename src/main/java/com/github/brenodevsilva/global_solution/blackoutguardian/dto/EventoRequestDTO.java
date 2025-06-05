package com.github.brenodevsilva.global_solution.blackoutguardian.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventoRequestDTO {

    @NotBlank(message = "A cidade é obrigatória")
    private String cidade;

    @NotBlank(message = "O bairro é obrigatório")
    private String bairro;

    @NotNull(message = "A data/hora de início é obrigatória")
    private LocalDateTime dataHoraInicio;

    @NotNull(message = "A data/hora de término é obrigatória")
    @Future(message = "A data/hora de término deve estar no futuro")
    private LocalDateTime dataHoraFim;

    @NotBlank(message = "A descrição do prejuízo é obrigatória")
    private String descricaoPrejuizo;
}
