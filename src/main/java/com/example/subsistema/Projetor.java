package com.example.subsistema;

public class Projetor {
    private boolean ligado = false;

    public void ligar() {
        this.ligado = true;
        System.out.println("[Projetor] Ligado.");
    }

    public void desligar() {
        this.ligado = false;
        System.out.println("[Projetor] Desligado.");
    }

    public boolean isLigado() { return ligado; }
}
