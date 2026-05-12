package com.example.subsistema;

import java.util.HashMap;
import java.util.Map;

public class CadastroPaciente {
    private final Map<String, String> pacientes = new HashMap<>();

    public boolean registrar(String cpf, String nome) {
        if (cpf == null || cpf.isBlank() || nome == null || nome.isBlank()) return false;
        pacientes.put(cpf, nome);
        System.out.println("[Cadastro] Paciente registrado: " + nome + " (CPF: " + cpf + ")");
        return true;
    }

    public boolean existe(String cpf) { return pacientes.containsKey(cpf); }
    public String getNome(String cpf) { return pacientes.get(cpf); }
    public int getTotalCadastrados()  { return pacientes.size(); }
}
