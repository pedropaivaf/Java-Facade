package com.example.facade;

import com.example.subsistema.Luzes;
import com.example.subsistema.PlayerDVD;
import com.example.subsistema.Projetor;
import com.example.subsistema.SistemaDeSom;

/**
 * Facade — simplifica o uso do sistema de home theater.
 * O cliente não precisa conhecer os subsistemas individualmente.
 */
public class HomeTheaterFacade {

    private final Projetor projetor;
    private final SistemaDeSom som;
    private final PlayerDVD dvd;
    private final Luzes luzes;

    public HomeTheaterFacade(Projetor projetor, SistemaDeSom som, PlayerDVD dvd, Luzes luzes) {
        this.projetor = projetor;
        this.som = som;
        this.dvd = dvd;
        this.luzes = luzes;
    }

    public void assistirFilme(String filme) {
        System.out.println("=== Preparando sessão de cinema ===");
        luzes.diminuir(10);
        projetor.ligar();
        som.ligar();
        som.setVolume(30);
        dvd.ligar();
        dvd.play(filme);
        System.out.println("=== Curtindo: " + filme + " ===");
    }

    public void encerrarFilme() {
        System.out.println("=== Encerrando sessão de cinema ===");
        dvd.parar();
        dvd.desligar();
        som.desligar();
        projetor.desligar();
        luzes.ligarTotal();
        System.out.println("=== Sessão encerrada ===");
    }

    // Getters para testes
    public Projetor getProjetor() { return projetor; }
    public SistemaDeSom getSom() { return som; }
    public PlayerDVD getDvd() { return dvd; }
    public Luzes getLuzes() { return luzes; }
}
