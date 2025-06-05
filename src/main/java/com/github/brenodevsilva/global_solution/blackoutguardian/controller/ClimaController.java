package com.github.brenodevsilva.global_solution.blackoutguardian.controller;

import com.github.brenodevsilva.global_solution.blackoutguardian.service.WeatherClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/clima")
public class ClimaController {

    private final WeatherClient weatherClient;

    public ClimaController(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @GetMapping("/{cidade}")
    public ResponseEntity<?> obterClimaPorCidade(@PathVariable String cidade) {
        Map<String, Object> clima = weatherClient.getClimaAtual(cidade);
        return ResponseEntity.ok(clima);
    }
}
