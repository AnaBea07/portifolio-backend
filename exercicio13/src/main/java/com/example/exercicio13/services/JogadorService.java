package com.example.exercicio13.services;


import com.example.exercicio13.dtos.JogadorRequestDto;
import com.example.exercicio13.dtos.JogadorResponseDto;
import com.example.exercicio13.mapper.JogadorMapper;
import com.example.exercicio13.models.Jogador;
import com.example.exercicio13.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class JogadorService {

    @Autowired
    JogadorRepository jogadorRepository;
    @Autowired
    JogadorMapper jogadorMapper;

    public JogadorResponseDto insereJogador(JogadorRequestDto jogadorRequestDto) {
        Integer habilidadeAleatoria = new Random().nextInt(0, 100);
        Jogador jogador = new Jogador();
        jogador.setNome(jogadorRequestDto.nome());
        jogador.setApelido(jogadorRequestDto.apelido());
        jogador.setHabilidade(habilidadeAleatoria);
        jogadorRepository.save(jogador);
        return jogadorMapper.toDto(jogador);
    }

    public List<JogadorResponseDto> retornaJogadores() {
        return jogadorRepository.findAll().stream().map(jogadorMapper::toDto).toList();
    }
}
