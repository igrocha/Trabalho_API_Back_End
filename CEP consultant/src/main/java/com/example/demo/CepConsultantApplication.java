package com.example.demo;

import com.example.demo.dto.EnderecoDto;
import com.example.demo.serviço.ApiServiço;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CepConsultantApplication {

    public static void main(String[] args) {
        SpringApplication.run(CepConsultantApplication.class, args);

        ApiServiço apiServiço = new ApiServiço();

        try {
            EnderecoDto enderecoDto = apiServiço.getEnderecoDto("01001000");
            System.out.println(enderecoDto.getLogradouro());
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException("Erro ao consultar API de CEP: " + ex.getMessage(), ex);
        }
    }
}
