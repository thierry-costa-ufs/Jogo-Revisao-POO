package com.arena.inventario;

public class Arma extends Item {
    private int danoBase;

    public Arma(int danoBase) {
        super("Espada Enferrujada", "Achada à beira do rio Skargunn", 1, true, false);
        this.danoBase= danoBase;
    }

    public int getDanoBase(){
        return danoBase;
    }
}
