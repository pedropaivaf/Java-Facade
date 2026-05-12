package com.example.subsistema;

public class Luzes {
    private int brilho = 100;

    public void diminuir(int brilho) {
        this.brilho = brilho;
        System.out.println("[Luzes] Brilho ajustado para " + brilho + "%.");
    }

    public void ligarTotal() {
        this.brilho = 100;
        System.out.println("[Luzes] Ligadas totalmente.");
    }

    public int getBrilho() { return brilho; }
}
