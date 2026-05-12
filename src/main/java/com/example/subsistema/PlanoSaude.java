package com.example.subsistema;

import java.util.Set;

public class PlanoSaude {
    private static final Set<String> CONVENIADOS = Set.of("UNIMED", "BRADESCO_SAUDE", "AMIL", "SUL_AMERICA");

    public boolean validar(String operadora) {
        boolean ok = CONVENIADOS.contains(operadora.toUpperCase());
        System.out.println("[Plano] " + operadora + ": " + (ok ? "conveniado ✓" : "não conveniado"));
        return ok;
    }

    public double calcularCoparticipacao(String operadora, double valorTotal) {
        return validar(operadora) ? valorTotal * 0.10 : valorTotal;
    }
}
