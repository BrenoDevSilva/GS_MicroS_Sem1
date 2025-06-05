package com.github.brenodevsilva.global_solution.blackoutguardian.dto;

import com.github.brenodevsilva.global_solution.blackoutguardian.model.Evento;

import java.time.LocalDateTime;

public class EventoResponseDTO {

    private Long id;
    private String cidade;
    private String bairro;
    private String descricao;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;

    public EventoResponseDTO(Evento evento) {
        this.id = evento.getId();
        this.cidade = evento.getCidade();
        this.bairro = evento.getBairro();
        this.descricao = evento.getDescricaoPrejuizo();
        this.dataHoraInicio = evento.getDataHoraInicio();
        this.dataHoraFim = evento.getDataHoraFim();
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }
}
