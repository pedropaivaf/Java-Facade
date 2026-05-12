package com.example;

import com.example.subsistema.AlocacaoLeito;
import com.example.subsistema.Triagem;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Alocação de Leito")
class AlocacaoLeitoTest {

    private AlocacaoLeito alocacao;

    @BeforeEach void setUp() { alocacao = new AlocacaoLeito(); }

    @Test @DisplayName("Emergência deve alocar leito UTI")
    void emergenciaVaiParaUTI() {
        String leito = alocacao.alocar("111", Triagem.Prioridade.EMERGENCIA);
        assertTrue(leito.startsWith("UTI"));
    }

    @Test @DisplayName("Urgente deve alocar enfermaria")
    void urgenteVaiParaEnfermaria() {
        String leito = alocacao.alocar("222", Triagem.Prioridade.URGENTE);
        assertTrue(leito.startsWith("ENF"));
    }

    @Test @DisplayName("Eletivo deve alocar apartamento")
    void eletivoVaiParaApartamento() {
        String leito = alocacao.alocar("333", Triagem.Prioridade.ELETIVO);
        assertTrue(leito.startsWith("APT"));
    }

    @Test @DisplayName("Paciente internado deve estar marcado como ocupado")
    void pacienteInternado() {
        alocacao.alocar("444", Triagem.Prioridade.ELETIVO);
        assertTrue(alocacao.estaInternado("444"));
    }

    @Test @DisplayName("Alta médica deve liberar leito")
    void altaLiberaLeito() {
        alocacao.alocar("555", Triagem.Prioridade.URGENTE);
        assertTrue(alocacao.liberar("555"));
        assertFalse(alocacao.estaInternado("555"));
    }
}
