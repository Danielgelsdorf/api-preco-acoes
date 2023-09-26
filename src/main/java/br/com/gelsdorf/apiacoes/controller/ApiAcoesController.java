package br.com.gelsdorf.apiacoes.controller;


import br.com.gelsdorf.apiacoes.exceptions.AcaoException;
import br.com.gelsdorf.apiacoes.model.Acao;
import br.com.gelsdorf.apiacoes.service.ApiAcaoCacheService;
import br.com.gelsdorf.apiacoes.service.ApiAcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiAcoesController {
    @Autowired
    private ApiAcaoCacheService cacheService;
    @Autowired
    private ApiAcaoService acaoService;
    @GetMapping("/acao")
    public ResponseEntity<?> buscarPreco(@RequestParam String cod) throws  Exception{
        try {
            Acao a = cacheService.verificarCache(cod);
            return ResponseEntity.ok(a);
        } catch (AcaoException exception){
            return ResponseEntity.status(   406).body(exception.getMsg());
        }
    }
    @GetMapping("/selic")
    public  ResponseEntity<?> buscarSelic() throws Exception{
        return ResponseEntity.ok(acaoService.buscarTachaCDI());
    }
}
