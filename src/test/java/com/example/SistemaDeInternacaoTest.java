package com.example;

import com.example.internacao.*;
import com.example.subsistema.Triagem;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Sistema de Internação — Fachada")
class SistemaDeInternacaoTest {

    private SistemaDeInternacao hospital;

    @BeforeEach void setUp() { hospital = new SistemaDeInternacao(); }

    @Test @DisplayName("Internação válida deve retornar sucesso")
    void internacaoValidaSucesso() {
        var r = hospital.internar("111.111.111-11", "João", "fratura no joelho", "UNIMED");
        assertTrue(r.isSucesso());
        assertNotNull(r.getLeito());
    }

    @Test @DisplayName("CPF em branco deve falhar")
    void cpfVazioFalha() {
        var r = hospital.internar("", "Ana", "febre alta", "AMIL");
        assertFalse(r.isSucesso());
    }

    @Test @DisplayName("Sintoma de infarto deve gerar prioridade EMERGÊNCIA")
    void infartoGeraEmergencia() {
        var r = hospital.internar("222.222.222-22", "Pedro", "dor no peito, infarto", "SUL_AMERICA");
        assertEquals(Triagem.Prioridade.EMERGENCIA, r.getPrioridade());
    }

    @Test @DisplayName("Alta deve liberar leito do paciente")
    void altaLiberaLeito() {
        hospital.internar("333.333.333-33", "Maria", "consulta eletiva", "AMIL");
        assertTrue(hospital.darAlta("333.333.333-33"));
        assertFalse(hospital.getAlocacao().estaInternado("333.333.333-33"));
    }

    @Test @DisplayName("Mensagem de resultado deve conter leito alocado")
    void mensagemContemLeito() {
        var r = hospital.internar("444.444.444-44", "Carlos", "sangramento", "BRADESCO_SAUDE");
        assertTrue(r.getMensagem().contains(r.getLeito()));
    }

    @Test @DisplayName("Dois pacientes simultâneos devem ter leitos distintos")
    void doisPacientesDiferentes() {
        var r1 = hospital.internar("555.555.555-55", "Alice", "fratura", "UNIMED");
        var r2 = hospital.internar("666.666.666-66", "Bob",   "consulta", "AMIL");
        assertNotEquals(r1.getLeito(), r2.getLeito());
    }
}
