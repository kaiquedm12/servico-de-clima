package com.example.projeto_intermediario.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class Climainfos {

    private final String Chave = "9d93dfe4d3c9bcc108aa7f7c7afc6cf3";
    private final String URL_API = "https://api.openweathermap.org/data/2.5/weather";
    private final RestTemplate restTemplate;

    public Climainfos() {
        this.restTemplate = new RestTemplate();
    }

    public Map<String, Object> getClima(String cidade) {
        String url = URL_API + "?q=" + cidade + "&appid=" + Chave + "&lang=pt_br" + "&units=metric";
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        return response;
    }

    public Map<String, Object> processDados(Map<String, Object> requestData) {
        requestData.put("status", "Dados recebidos e processados com sucesso!");
        return requestData;
    }

    public Map<String, String> getSobreInfo() {
        Map<String, String> sobreInfo = new HashMap<>();
        sobreInfo.put("estudante", "Kaique Demetrio");
        sobreInfo.put("projeto", "Serviço de clima");
        return sobreInfo;
    }
}
