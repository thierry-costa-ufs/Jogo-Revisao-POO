package com.arena.modelo;

public class Heroi extends Personagem {
    private int xp;
    private  int nivel;

    public Heroi(String nome) {
        super(nome, 5, 1, 1);
        nivel=1;
        xp=0;
    }

    public void subirNivel() {
        nivel++;
        xp=0;
        setVidaAtual(getVidaMaxima());
        setDanoPersonagem(nivel-1);
        setVidaMaxima(nivel-1);
        System.out.println("\nUAU! Você subiu de nível... (XP atual: Nível " + nivel + " [" + xp + "/5])");
    }

    public void subirNivel(int resto) {
        nivel++;
        xp=resto;
        setVidaAtual(5);
        System.out.println("\nUAU! Você subiu de nível... (XP atual: Nível " + nivel + " [" + xp + "/5])");
    }

    @Override
    public int getNivel() {
        return nivel;
    }

    @Override
    public void receberExp(int valor) {
        xp += valor;
        System.out.println("\n" + getNome() + " recebeu " + valor + " de experiência (XP atual: Nível " + nivel + " [" + xp + "/5])");

        if (xp == 5) subirNivel();
        if (xp > 5) subirNivel(xp-5);
    }

    @Override
    public String toString() {
        return String.format("Nome do heroi: %s (HP: %d/%d)", getNome(), getVidaAtual(), getVidaMaxima());
    }
}
