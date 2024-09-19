package com.example.exercicio08;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;


@RestController
@RequestMapping("/fipe")
public class FipeController {

    private RestClient cliente = RestClient.create("https://parallelum.com.br");

    @GetMapping("/valor")
    public ResponseEntity<HashMap<String, String>> valor(
            @RequestParam String marca,
            @RequestParam String modelo,
            @RequestParam int ano) {

        String url = String.format("/carros/marcas/%s/modelos/%s/anos/%d", marca, modelo, ano);


        HashMap<String, Object> resposta = cliente
                .get()
                .uri(url)
                .retrieve()
                .body(HashMap.class);


        if (resposta == null) {
            return ResponseEntity.notFound().build();
        }


        String valor = (String) resposta.get("valor");


        LocalDate now = LocalDate.now();
        String mesAtual = now.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
        String anoAtual = String.valueOf(now.getYear());


        HashMap<String, String> respostaPersonalizada = new HashMap<>();
        respostaPersonalizada.put("valor", valor);
        respostaPersonalizada.put("mes", mesAtual + " de " + anoAtual);

        return ResponseEntity.ok(respostaPersonalizada);
    }
}











