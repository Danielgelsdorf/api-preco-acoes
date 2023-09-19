package br.com.gelsdorf.apiacoes.service;

import br.com.gelsdorf.apiacoes.model.Acao;
import br.com.gelsdorf.apiacoes.model.Selic;

import java.io.IOException;

public interface ApiAcaoService {
    public Acao buscarAcao(String cod) throws IOException, InterruptedException, Exception;
    public Selic buscarTachaCDI() throws Exception;
}
