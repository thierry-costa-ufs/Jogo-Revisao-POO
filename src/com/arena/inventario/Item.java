package com.arena.inventario;

public abstract class Item {
    private String nome;
    private String descricao;
    private int valor;
    private boolean equipavel;
    private boolean consumivel;

    public Item(String nome, String descricao, int valor, boolean equipavel, boolean consumivel) {
        this.nome= nome;
        this.descricao= descricao;
        this.valor= valor;
        this.equipavel= equipavel;
        this.consumivel= consumivel;
    }

    public boolean isConsumivel() {
        return consumivel;
    }

    public boolean isEquipavel() {
        return equipavel;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return String.format("Item: %s\nDescrição: %s\nValor: %d\n", nome, descricao, valor);
    }
}
