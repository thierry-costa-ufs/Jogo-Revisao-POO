package com.arena.engine;

import com.arena.modelo.Goblin;
import com.arena.modelo.Kobold;
import com.arena.modelo.Personagem;

import java.util.Scanner;

public class Batalha {
    public void iniciarBatalha(Personagem personagem1, Personagem personagem2, Scanner sc) {
        System.out.println("\nUMA BATALHA COMEÇOU!");

        switch (personagem1.getNivel()) {
            case 1:
                personagem2= new Goblin();
                break;
            case 2:
                personagem2= new Kobold();
                break;
        }

        while (personagem1.estaVivo() && personagem2.estaVivo()) {
            System.out.println("\n=== PAINEL DE BATALHA ===\n" + personagem1 + "\n" + personagem2);
            System.out.println("\n=== Como vai proceder? ===\n[1] ATACAR\n[2] CONSUMÍVEL\n[3] FUGIR");

            int acao= sc.nextInt();
            sc.nextLine();

            switch (acao) {
                case 1:
                    personagem1.atacar(personagem2);
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Escolha inválida!");
                    break;
            }
            personagem2.atacar(personagem1);
        }
        if (!(personagem1.estaVivo())) System.exit(0);
        personagem1.receberExp(2);
        personagem2= null;
    }
}
