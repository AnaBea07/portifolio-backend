package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        String[] cores = new String[4];
        cores[0] = "azul";
        cores[1] = "verde";
        cores[2] = "amarelo";
        cores[3] = "vermelho";
        cores[4] = "outra cor";
         */
        String[] vetorCores = { "azul", "verde", "amarelo", "vermelho" };

        while (true) {
            Scanner leitor = new Scanner(System.in);

            System.out.println("Digite o primeiro nome: ");
            String primeiroNome = leitor.nextLine();

            if (primeiroNome.isEmpty()) return;

            System.out.println("Digite o segundo nome: ");
            String segundoNome = leitor.nextLine();

            Random geradorAleatorio = new Random();
            Integer numeroAleatorio = geradorAleatorio.nextInt(10, 100);
            Integer indiceAlatorio = geradorAleatorio.nextInt(vetorCores.length);

            String cor = vetorCores[indiceAlatorio];

            System.out.println(cor + primeiroNome + segundoNome + numeroAleatorio);
        }
    }
}