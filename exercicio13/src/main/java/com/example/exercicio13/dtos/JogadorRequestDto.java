package com.example.exercicio13.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record JogadorRequestDto(
        @NotBlank @Size(min = 3) String nome,
        @NotNull String apelido
) {}
