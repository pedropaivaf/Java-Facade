package com.example;

import com.example.subsistema.Triagem;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Triagem Hospitalar")
class TriagemTest {

    private Triagem triagem;

    @BeforeEach void setUp() { triagem = new Triagem(); }

    @Test @DisplayName("Infarto deve gerar EMERGÊNCIA")
    void infartoEEmergencia() {
        assertEquals(Triagem.Prioridade.EMERGENCIA, triagem.classificar("dor no peito, infarto"));
    }

    @Test @DisplayName("AVC deve gerar EMERGÊNCIA")
    void avcEEmergencia() {
        assertEquals(Triagem.Prioridade.EMERGENCIA, triagem.classificar("sintomas de AVC"));
    }

    @Test @DisplayName("Fratura deve gerar URGENTE")
    void fraturaEUrgente() {
        assertEquals(Triagem.Prioridade.URGENTE, triagem.classificar("fratura no braço"));
    }

    @Test @DisplayName("Consulta eletiva deve gerar ELETIVO")
    void consultaEEletivo() {
        assertEquals(Triagem.Prioridade.ELETIVO, triagem.classificar("consulta de rotina"));
    }
}
