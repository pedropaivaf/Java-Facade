package com.example.subsistema;

public class Triagem {
    public enum Prioridade { EMERGENCIA, URGENTE, ELETIVO }

    public Prioridade classificar(String sintomas) {
        String s = sintomas.toLowerCase();
        if (s.contains("infarto") || s.contains("avc") || s.contains("parada")) {
            System.out.println("[Triagem] EMERGÊNCIA detectada.");
            return Prioridade.EMERGENCIA;
        } else if (s.contains("fratura") || s.contains("febre alta") || s.contains("sangramento")) {
            System.out.println("[Triagem] Caso URGENTE.");
            return Prioridade.URGENTE;
        }
        System.out.println("[Triagem] Internação ELETIVA.");
        return Prioridade.ELETIVO;
    }
}
