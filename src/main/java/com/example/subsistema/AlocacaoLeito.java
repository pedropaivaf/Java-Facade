package com.example.subsistema;

import java.util.HashMap;
import java.util.Map;

public class AlocacaoLeito {
    private final Map<String, String> leitosOcupados = new HashMap<>(); // cpf -> leito

    public String alocar(String cpf, Triagem.Prioridade prioridade) {
        String leito = prioridade == Triagem.Prioridade.EMERGENCIA ? "UTI-" + (leitosOcupados.size() + 1)
                     : prioridade == Triagem.Prioridade.URGENTE    ? "ENF-" + (leitosOcupados.size() + 1)
                     :                                                "APT-" + (leitosOcupados.size() + 1);
        leitosOcupados.put(cpf, leito);
        System.out.println("[Leito] Leito alocado: " + leito + " para CPF " + cpf);
        return leito;
    }

    public boolean liberar(String cpf) {
        boolean ok = leitosOcupados.remove(cpf) != null;
        if (ok) System.out.println("[Leito] Leito liberado para CPF " + cpf);
        return ok;
    }

    public String getLeitoAtual(String cpf) { return leitosOcupados.get(cpf); }
    public boolean estaInternado(String cpf) { return leitosOcupados.containsKey(cpf); }
    public int getTotalOcupados() { return leitosOcupados.size(); }
}
