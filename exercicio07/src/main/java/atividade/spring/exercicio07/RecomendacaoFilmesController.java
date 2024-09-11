package atividade.spring.exercicio07;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecomendacaoFilmesController {

    @GetMapping("/recomendar")
    public String recomendarFilme(@RequestParam String genero, @RequestParam String ambiente) {
        String[] listaDeFilmes = {"Homens de Preto", "Arrival", "Shrek", "Gladiador"};

        int opcaoAmbientacao;
        int opcaoGenero;

        if (ambiente.equalsIgnoreCase("medieval")) {
            opcaoAmbientacao = 1;
        } else if (ambiente.equalsIgnoreCase("sci-fi")) {
            opcaoAmbientacao = 0;
        } else {
            opcaoAmbientacao = -1;
        }

        if (genero.equalsIgnoreCase("drama")) {
            opcaoGenero = 1;
        } else if (genero.equalsIgnoreCase("comedia")) {
            opcaoGenero = 0;
        } else {
            opcaoGenero = -1;
        }

        if (opcaoAmbientacao == -1 || opcaoGenero == -1) {
            return "Ambiente ou gênero inválidos!!";
        }
        int indiceFilme = opcaoAmbientacao * 2 + opcaoGenero;

        if (indiceFilme >= 0 && indiceFilme < listaDeFilmes.length) {
            return listaDeFilmes[indiceFilme];
        } else {
            return "Nenhuma recomendação disponível...";
        }
    }
}

//Baseado no exercicio 1.


