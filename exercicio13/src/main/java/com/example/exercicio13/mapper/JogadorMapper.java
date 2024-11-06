package com.example.exercicio13.mapper;


import com.example.exercicio13.dtos.JogadorResponseDto;
import com.example.exercicio13.models.Jogador;
import org.springframework.stereotype.Component;

@Component
public class JogadorMapper {
    public JogadorResponseDto toDto(Jogador jogador) {
        return new JogadorResponseDto(
                jogador.getNome(),
                jogador.getApelido(),
                jogador.getHabilidade()
        );
    }
}
