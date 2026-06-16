package com.github.paulinho19.cep_finder.controller;

import com.github.paulinho19.cep_finder.DTO.CepDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulta-cep")
public class CepController {
    @GetMapping("{cep}")
    public CepDTO getCep(@PathVariable("cep") String cep){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CepDTO> res = restTemplate.getForEntity(String.format("https://viacep.com.br/ws/%s/json/",cep),CepDTO.class);
        return res.getBody();
    }
}
