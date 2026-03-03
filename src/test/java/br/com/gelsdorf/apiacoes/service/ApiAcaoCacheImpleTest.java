package br.com.gelsdorf.apiacoes.service;

import br.com.gelsdorf.apiacoes.model.Acao;
import br.com.gelsdorf.apiacoes.service.imple.ApiAcaoCacheImple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApiAcaoCacheImpleTest {

    @Mock
    private ApiAcaoService acaoService;

    @InjectMocks
    private ApiAcaoCacheImple cacheService;

    private Acao acaoFake;

    @BeforeEach
    void setup() {
        // Ajustado para usar o construtor ou setters da sua classe Acao
        acaoFake = new Acao("Petrobras PN", 35.50, 36.00, 34.80);
    }

    @Test
    void deveRetornarAcaoComHoraFormatada() throws Exception {
        // Cenário: quando buscar por "PETR4", retorna nossa acaoFake
        when(acaoService.buscarAcao("PETR4")).thenReturn(acaoFake);

        // Execução
        Acao resultado = cacheService.verificarCache("PETR4");

        // Verificação
        assertNotNull(resultado);
        assertEquals("Petrobras PN", resultado.getLongName());
        assertNotNull(resultado.getHoraUltimaAtualizacao());
        // Verifica se a hora está no formato HH:mm (ex: 15:45)
        assertTrue(resultado.getHoraUltimaAtualizacao().matches("\\d{2}:\\d{2}"));
    }

    @Test
    void deveFormatarHoraCorretamente() {
        // Cenário: Criamos uma hora fixa para testar a formatação
        LocalTime hora = LocalTime.of(10, 15);

        // Execução
        String horaFormatada = cacheService.formatarHora(hora);

        // Verificação
        assertEquals("10:15", horaFormatada);
    }
}