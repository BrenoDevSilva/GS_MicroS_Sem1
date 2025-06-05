package com.github.brenodevsilva.global_solution.blackoutguardian.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cidade;
    private String bairro;

    @Column(name = "data_hora_inicio")
    private LocalDateTime dataHoraInicio;

    @Column(name = "data_hora_fim")
    private LocalDateTime dataHoraFim;

    @Column(name = "descricao_prejuizo")
    private String descricaoPrejuizo;

    public Evento() {
    }

    public Evento(String cidade, String bairro, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String descricaoPrejuizo) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.descricaoPrejuizo = descricaoPrejuizo;
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

    public String getDescricaoPrejuizo() {
        return descricaoPrejuizo;
    }

    public void setDescricaoPrejuizo(String descricaoPrejuizo) {
        this.descricaoPrejuizo = descricaoPrejuizo;
    }
}
