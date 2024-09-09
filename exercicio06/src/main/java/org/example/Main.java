package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cinema cinema = new Cinema();

        Filme filme1 = new Filme("Homem Aranha", 30.00, 12);
        Filme filme2 = new Filme("Barbie", 30.00, 12);
        Filme filme3 = new Filme("Missão Impossível", 30.00, 14);
        Filme filme4 = new Filme("Scream", 30.00, 18);
        Filme filme5 = new Filme("O show de Truman", 30.00, 12);

        cinema.adicionarFilme(filme1);
        cinema.adicionarFilme(filme2);
        cinema.adicionarFilme(filme3);
        cinema.adicionarFilme(filme4);
        cinema.adicionarFilme(filme5);


        while (true) {
            try {
                System.out.println("Qual o seu nome?");
                String nomeCliente = scanner.nextLine();

                System.out.println("Qual a sua idade?");
                int idadeCliente = Integer.parseInt(scanner.nextLine());

                Cliente cliente = new Cliente(nomeCliente, idadeCliente);

                System.out.println("Qual filme você deseja assistir?");
                for (int i = 0; i < cinema.filmesDisponiveis.size(); i++) {
                    System.out.println((i + 1) + ". " + cinema.filmesDisponiveis.get(i).nome);
                }
                int escolhaFilme = Integer.parseInt(scanner.nextLine()) - 1;
                Filme filmeEscolhido = cinema.filmesDisponiveis.get(escolhaFilme);

                System.out.println("Qual assento você deseja (de A1 a F5)?");
                String assentoEscolhido = scanner.nextLine();

                if (!assentoEscolhido.matches("[A-F][1-5]")) {
                    throw new Exception("Assento inválido! Escolha entre A1 e F5.");
                }

                Ingresso ingresso = new Ingresso(cliente, filmeEscolhido, assentoEscolhido);
                cinema.venderIngresso(ingresso);


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Deseja comprar outro ingresso? (s/n)");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }

        }
    }

}
