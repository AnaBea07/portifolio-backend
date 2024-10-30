package com.example.exercicio12.services;

import com.example.exercicio12.dtos.ContaDTO;
import com.example.exercicio12.dtos.TransacaoRequestDTO;
import com.example.exercicio12.dtos.TransacaoResponseDTO;
import com.example.exercicio12.mapper.ContaMapper;
import com.example.exercicio12.models.Conta;
import com.example.exercicio12.models.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.ArrayList;

@Service
public class TransacoesService {


    private final ArrayList<Conta> contas = new ArrayList<>();
    private final ContaMapper contaMapper;

    @Autowired
    public TransacoesService(ContaMapper contaMapper) {
        this.contaMapper = contaMapper;
        inicializarContas();
    }


    private void inicializarContas() {
        Conta conta1 = new Conta();
        conta1.setCodigo("500-1");
        conta1.setCliente("Fulano");

        Conta conta2 = new Conta();
        conta2.setCodigo("320-2");
        conta2.setCliente("Ciclano");

        contas.add(conta1);
        contas.add(conta2);
    }


    public TransacaoResponseDTO processarTransacao(TransacaoRequestDTO requestDTO) {
        Optional<Conta> contaOrigem = contas.stream()
                .filter(conta -> conta.getCodigo().equals(requestDTO.origem()))
                .findFirst();
        Optional<Conta> contaDestino = contas.stream()
                .filter(conta -> conta.getCodigo().equals(requestDTO.destino()))
                .findFirst();

        if (contaOrigem.isPresent() && contaDestino.isPresent()) {
            ContaDTO origemDTO = ContaMapper.toDTO(contaOrigem.get());
            ContaDTO destinoDTO = ContaMapper.toDTO(contaDestino.get());

            return new TransacaoResponseDTO(origemDTO, destinoDTO, requestDTO.valor());
        } else {
            throw new RuntimeException("Conta de origem ou destino não encontrada");
        }
    }
}
