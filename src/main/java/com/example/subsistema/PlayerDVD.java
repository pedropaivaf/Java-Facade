package com.example.subsistema;

public class PlayerDVD {
    private boolean reproduzindo = false;

    public void ligar() {
        System.out.println("[DVD] Ligado.");
    }

    public void play(String filme) {
        this.reproduzindo = true;
        System.out.println("[DVD] Reproduzindo: " + filme);
    }

    public void parar() {
        this.reproduzindo = false;
        System.out.println("[DVD] Parado.");
    }

    public void desligar() {
        this.reproduzindo = false;
        System.out.println("[DVD] Desligado.");
    }

    public boolean isReproduzindo() { return reproduzindo; }
}
