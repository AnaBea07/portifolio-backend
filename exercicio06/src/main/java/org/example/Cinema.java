package org.example;

import java.util.ArrayList;

public class Cinema {

    ArrayList<Filme> filmesDisponiveis = new ArrayList<>();
    ArrayList<Ingresso> ingressosVendidos = new ArrayList<>();

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public boolean verificarAssentoDisponivel(String assento) {
        for (Ingresso ingresso : ingressosVendidos) {
            if (ingresso.assento.equals(assento)) {
                return false;
            }
        }
        return true;
    }

    public void venderIngresso(Ingresso ingresso) throws Exception {
        if (!verificarAssentoDisponivel(ingresso.assento)) {
            throw new Exception("O ingresso não pode ser vendido pois seu assento não está mais disponível!");
        }
        if (ingresso.cliente.idade < ingresso.filme.idadeMinima) {
            throw new Exception("O ingresso não pode ser vendido pois sua idade não permite!");
        }
        ingressosVendidos.add(ingresso);
        System.out.println("Ingresso vendido com sucesso! " + ingresso.filme.nome + " - " + ingresso.assento + " - " + ingresso.cliente.nome);
    }
}






