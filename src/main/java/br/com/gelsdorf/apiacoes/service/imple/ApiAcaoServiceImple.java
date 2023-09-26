package br.com.gelsdorf.apiacoes.service.imple;

import br.com.gelsdorf.apiacoes.exceptions.AcaoException;
import br.com.gelsdorf.apiacoes.model.*;


import br.com.gelsdorf.apiacoes.service.ApiAcaoService;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.time.LocalTime;


@Service
public class ApiAcaoServiceImple implements ApiAcaoService {
    final String chave = "g8z95ZUqS6cYt24Rq5t8Bx";

    @Override
    @Cacheable("acoes")
    public Acao buscarAcao(String cod) throws Exception {
        String url = "https://brapi.dev/api/quote/" + cod + "?token=" + chave;
        AcaoRequest request=new AcaoRequest();
        ObjectMapper mapa = new ObjectMapper();
        return mapa.readValue(request.sendRequest(url), Acao.class);
    }

    @Override
    public Selic buscarTachaCDI() throws Exception {
        String link = "https://brapi.dev/api/v2/prime-rate?token=" + chave;
        ObjectMapper mapa = new ObjectMapper();
        AcaoRequest request=new AcaoRequest();
        return mapa.readValue(request.sendRequest(link), Selic.class);
    }

    @Override
    @CacheEvict(value = "acoes", allEntries = true)
    public void limparCache() {

    }
}

class AcaoRequest {
    String sendRequest(String url) throws Exception {
        HttpClient cliente = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(
                        URI.create(url))
                .build();
        var response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        if (json.length() <= 40) {
            throw new AcaoException("código errado");
        }
        json = json.substring(json.lastIndexOf("{"), json.indexOf("]"));
        return json;
    }
}

