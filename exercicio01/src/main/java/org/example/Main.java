package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] listaDeFilmes = {"Homens de Preto", "Arrival", "Shrek", "Gladiador"};
        Scanner leitor = new Scanner(System.in);

        System.out.println("Que ambientação você prefere??");
        System.out.println("1 - sci - fi");
        System.out.println("2 - medieval");

        Integer opcaoAmbientacao = leitor.nextInt();

        if (opcaoAmbientacao != 1 && opcaoAmbientacao != 2) {
            System.out.println("Resposta inválida!! Escolha 1 ou 2...");
            return;
        }

        System.out.println("Que genero você prefere??");
        System.out.println("1 - comedia");
        System.out.println("2 - drama");

        Integer opcaoGenero = leitor.nextInt();

        if (opcaoGenero != 1 && opcaoGenero != 2) {
            System.out.println("Resposta inválida!! Escolha 1 ou 2...");
            return;
        }

        opcaoAmbientacao = opcaoAmbientacao - 1;
        opcaoGenero = opcaoGenero - 1;

        int indiceFilme = opcaoAmbientacao * 2 + opcaoGenero;
        System.out.println(listaDeFilmes[indiceFilme]);



    }
}