package com.arena.inventario;

import com.arena.modelo.Personagem;

public class PocaoCura extends Item implements Consumivel {
    private int curaBase;

    public PocaoCura() {
        super("Poção de Cura", "Cura 2 pontos de vida", 1, false, true);
        curaBase= 2;
    }

    @Override
    public int aplicarEfeito(Personagem personagem) {
        if (personagem.getVidaAtual() < personagem.getVidaMaxima()) {
            personagem.setVidaAtual(curaBase);
            System.out.println(personagem.getNome() + " curou " + curaBase + " de HP! " + "(HP atual: " + personagem.getVidaAtual() + "/" + personagem.getVidaMaxima() + ")");
            return 1;
        }
        else {
            System.out.println("Você já está com a vida máxima!");
            return 0;
        }
    }
}
