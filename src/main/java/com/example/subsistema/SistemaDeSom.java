package com.example.subsistema;

public class SistemaDeSom {
    private int volume = 0;

    public void ligar() {
        System.out.println("[Som] Ligado.");
    }

    public void desligar() {
        this.volume = 0;
        System.out.println("[Som] Desligado.");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("[Som] Volume ajustado para " + volume + ".");
    }

    public int getVolume() { return volume; }
}
