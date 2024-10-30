package com.example.exercicio12.mapper;


import com.example.exercicio12.dtos.ContaDTO;
import com.example.exercicio12.models.Conta;
import org.springframework.stereotype.Component;


@Component
public class ContaMapper {
    public static ContaDTO toDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }
}

