package br.com.gelsdorf.apiacoes.service;

import br.com.gelsdorf.apiacoes.model.Acao;

public interface ApiAcaoCacheService {
    Acao verificarCache(String cod) throws Exception;

}