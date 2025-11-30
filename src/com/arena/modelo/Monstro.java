package com.arena.modelo;

public abstract class Monstro extends Personagem {
    public Monstro(String nome, int vidaMaxima, int danoBase, int danoPersonagem) {
        super(nome, vidaMaxima, danoBase, danoPersonagem);
    }

    @Override
    public String toString() {
        return String.format("Nome do monstro: %s (HP: %d/%d)", getNome(), getVidaAtual(), getVidaMaxima());
    }
}
