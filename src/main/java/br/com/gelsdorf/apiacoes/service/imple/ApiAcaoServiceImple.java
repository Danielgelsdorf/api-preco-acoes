package br.com.gelsdorf.apiacoes.service.imple;

import br.com.gelsdorf.apiacoes.exceptions.AcaoException;
import br.com.gelsdorf.apiacoes.model.*;

import br.com.gelsdorf.apiacoes.service.ApiAcaoService;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ApiAcaoServiceImple implements ApiAcaoService {
    final String chave = "g8z95ZUqS6cYt24Rq5t8Bx";


    @Override
    public Acao buscarAcao(String cod) throws Exception {
        String url = "https://brapi.dev/api/quote/" + cod + "?token=" + chave;
        ObjectMapper mapa = new ObjectMapper();
        return mapa.readValue(sendRequest(url), Acao.class);
    }

    @Override
    public Selic buscarTachaCDI() throws Exception {
        String link="https://brapi.dev/api/v2/prime-rate?token="+chave;
        ObjectMapper mapa = new ObjectMapper();
        return mapa.readValue(sendRequest(link), Selic.class);
    }

    private String sendRequest(String url) throws Exception {
        HttpClient cliente = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(
                        URI.create(url))
                .build();
        var response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json.length()+" tamanho");
        if(json.length()<=40){
            throw new AcaoException("código errado");
        }
        json = json.substring(json.lastIndexOf("{"), json.indexOf("]"));
        return json;
    }
}
