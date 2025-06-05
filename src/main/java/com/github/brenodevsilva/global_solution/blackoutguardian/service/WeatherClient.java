package com.github.brenodevsilva.global_solution.blackoutguardian.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherClient {

    private final String API_KEY = "932a1ba333e0ba375743867802698404";
    private final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather";

    public Map<String, Object> getClimaAtual(String cidade) {
        RestTemplate restTemplate = new RestTemplate();

        String url = String.format("%s?q=%s&appid=%s&lang=pt_br&units=metric",
                WEATHER_URL, cidade, API_KEY);

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        Map<String, Object> dados = response.getBody();

        if (dados == null) {
            return Map.of("erro", "Não foi possível obter dados do clima.");
        }

        // Processa os dados recebidos
        Map<String, Object> clima = new HashMap<>();
        clima.put("cidade", dados.get("name"));

        Map<String, Object> main = (Map<String, Object>) dados.get("main");
        if (main != null) {
            clima.put("temperatura", main.get("temp") + "°C");
            clima.put("umidade", main.get("humidity") + "%");
        }

        Map<String, Object> wind = (Map<String, Object>) dados.get("wind");
        if (wind != null) {
            clima.put("vento", wind.get("speed") + " km/h");
        }

        var weatherArray = (java.util.List<Map<String, Object>>) dados.get("weather");
        if (weatherArray != null && !weatherArray.isEmpty()) {
            clima.put("descricao", weatherArray.get(0).get("description"));
        }

        return clima;
    }
}
