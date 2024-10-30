package com.example.exercicio12.dtos;

public record TransacaoResponseDTO(ContaDTO origem, ContaDTO destino, Double valor) {
}
