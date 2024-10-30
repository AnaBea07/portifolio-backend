package com.example.exercicio12.controllers;


import com.example.exercicio12.dtos.TransacaoRequestDTO;
import com.example.exercicio12.dtos.TransacaoResponseDTO;
import com.example.exercicio12.services.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacoesService transacoesService;

    @Autowired
    public TransacaoController(TransacoesService transacoesService) {
        this.transacoesService = transacoesService;
    }

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> gerarTransacao(@RequestBody TransacaoRequestDTO requestDTO) {
        TransacaoResponseDTO responseDTO = transacoesService.processarTransacao(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
