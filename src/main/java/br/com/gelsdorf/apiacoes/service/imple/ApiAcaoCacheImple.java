package br.com.gelsdorf.apiacoes.service.imple;

import br.com.gelsdorf.apiacoes.model.Acao;
import br.com.gelsdorf.apiacoes.service.ApiAcaoCacheService;
import br.com.gelsdorf.apiacoes.service.ApiAcaoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class ApiAcaoCacheImple implements ApiAcaoCacheService {
    @Autowired
    private ApiAcaoService acaoService;
    private static LocalTime ultimaLimpesa;
    public ApiAcaoCacheImple(){
        ultimaLimpesa=LocalTime.now();
    }
    public Acao verificarCache(String cod) throws Exception{
        LocalTime horaAtual=LocalTime.now();
        LocalTime horaAtualTirando2Min=horaAtual.minusMinutes(2);
        if(horaAtualTirando2Min.isAfter(ultimaLimpesa)){
            ultimaLimpesa=LocalTime.now();
            acaoService.limparCache();
        }
        return acaoService.buscarAcao(cod);
    }

    }
