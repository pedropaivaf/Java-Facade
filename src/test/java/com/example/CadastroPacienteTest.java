package com.example;

import com.example.subsistema.CadastroPaciente;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Cadastro de Paciente")
class CadastroPacienteTest {

    private CadastroPaciente cadastro;

    @BeforeEach void setUp() { cadastro = new CadastroPaciente(); }

    @Test @DisplayName("Deve registrar paciente com CPF e nome válidos")
    void registrarValido() { assertTrue(cadastro.registrar("123.456.789-00", "Ana")); }

    @Test @DisplayName("Deve rejeitar CPF em branco")
    void rejeitarCPFVazio() { assertFalse(cadastro.registrar("", "Ana")); }

    @Test @DisplayName("Deve rejeitar nome em branco")
    void rejeitarNomeVazio() { assertFalse(cadastro.registrar("000.000.000-00", "")); }

    @Test @DisplayName("Paciente registrado deve ser encontrado")
    void pacienteExisteAposRegistro() {
        cadastro.registrar("111.111.111-11", "Pedro");
        assertTrue(cadastro.existe("111.111.111-11"));
    }

    @Test @DisplayName("Deve retornar nome do paciente pelo CPF")
    void getNomeCorreto() {
        cadastro.registrar("222.222.222-22", "Maria");
        assertEquals("Maria", cadastro.getNome("222.222.222-22"));
    }

    @Test @DisplayName("Total de cadastrados deve ser incrementado")
    void totalCadastradosIncrementa() {
        cadastro.registrar("A", "X");
        cadastro.registrar("B", "Y");
        assertEquals(2, cadastro.getTotalCadastrados());
    }
}
