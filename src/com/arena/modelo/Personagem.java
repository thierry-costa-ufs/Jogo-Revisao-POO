package com.arena.modelo;

import com.arena.inventario.Arma;
import com.arena.inventario.Consumivel;

public abstract class Personagem {
    private String nome;
    private int vidaAtual, vidaMaxima;
    private Arma arma;
    private int danoPersonagem;

    public Personagem(String nome, int vidaMaxima, int danoBase, int danoPersonagem) {
        this.nome= nome;
        this.vidaMaxima= vidaMaxima;
        vidaAtual= vidaMaxima;
        arma= new Arma(danoBase);
        this.danoPersonagem= danoPersonagem;
    }

    public void atacar(Personagem personagem) {
        personagem.receberDano(arma.getDanoBase() + danoPersonagem);
    }

    public int usarItem(Consumivel consumivel, Personagem personagem){
        return consumivel.aplicarEfeito(personagem);
    }

    public void receberDano(int danoRecebido) {
        vidaAtual -= danoRecebido;
        System.out.println("\n" + getNome() + " recebeu " + danoRecebido + " de dano! (HP restante: " + vidaAtual + "/" + vidaMaxima + ")");
    }

    public void setDanoPersonagem(int valor) {
        danoPersonagem += valor;
    }

    public int getNivel() {
        return 0;
    }

    public void receberExp(int valor) {
    }

    public String getNome() {
        return nome;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaAtual(int valor) {
        if (vidaMaxima < vidaAtual+valor)
            vidaAtual = vidaMaxima;
        else vidaAtual += valor;
    }

    public void setVidaMaxima(int valor) {
        vidaMaxima += valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setArma(Arma arma) {
        if (!(arma.getNome().equals(this.arma.getNome()))) {
            System.out.println("Você equipou " + arma.getNome() + "!");
            this.arma= arma;
        }
        else System.out.println("Este item já está equipado!");
    }

    public boolean estaVivo() {
        if (vidaAtual > 0) return true;
        else {
            System.out.println("\n" + getNome() + " morreu!");
            return false;
        }
    }

    @Override
    public abstract String toString();
}
