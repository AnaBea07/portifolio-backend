package org.example;

import java.util.List;
import java.util.ArrayList;

public class BasePorto {
    String nome;
    List<Barco> barcosAtracados;

    BasePorto(String nome) {
        this.nome = nome;
        this.barcosAtracados = new ArrayList<>();
    }

    public void atracarBarco(Barco barco) {
        barcosAtracados.add(barco);
        System.out.println(barco.nome + " atracado no " + nome);
    }
    public void desatracarBarco(Barco barco) {
        barcosAtracados.remove(barco);
        System.out.println(barco.nome + " desatracado do " + nome);
    }

}
