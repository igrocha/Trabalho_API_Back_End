package com.example.demo.serviço;

import com.example.demo.dto.EnderecoDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiServiço {

    public EnderecoDto getEnderecoDto(String cep) throws IOException, InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            EnderecoDto enderecoDto = mapper.readValue(response.body(), EnderecoDto.class);
            return enderecoDto;
        } catch (Exception e) {
            // Tratar a exceção adequadamente
            throw new RuntimeException("Erro ao consultar API de CEP: " + e.getMessage(), e);
        }
    }
}
