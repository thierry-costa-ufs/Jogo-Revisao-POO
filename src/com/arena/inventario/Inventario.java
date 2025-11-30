package com.arena.inventario;

import com.arena.modelo.Personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventario {
    private List<Item> itens= new ArrayList<>();
    private Item arma= new Arma(2);
    private Item pocao= new PocaoCura();

    public Inventario(){
        itens.add(arma);
        itens.add(pocao);
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(int indice) {
        itens.remove(indice);
    }

    public Arma getArma(int indice) {
        if (itens.get(indice).isEquipavel()) {
            return (Arma) itens.get(indice);
        }
        else return null;
    }

    public Consumivel getConsumivel(int indice) {
        if (itens.get(indice).isConsumivel()) {
            return (Consumivel) itens.get(indice);
        }
        else return null;
    }

    public void exibirItens(List<Item> lista) {
        if (lista.isEmpty()) System.out.println("Este inventário está vazio.");
        for (Item e: lista) {
            System.out.println("[" + itens.indexOf(e) + "] " + e.getNome());
        }
    }

    public void inventarioGeral(Personagem personagem, Scanner sc) {
        System.out.println("\n=== Inventário ===\n");
        exibirItens(itens);

        System.out.println("\n=== O que deseja fazer? ===\n[1] EQUIPAR\n[2] USAR\n[3] REMOVER\n[4] FECHAR");

        // ESCOLHA
        int escolha= sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                inventarioEquipaveis(personagem, sc);
                break;
            case 2:
                inventarioConsumiveis(personagem, sc);
                break;
            case 3:
                inventarioRemoviveis(sc);
                break;
            case 4:
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
        }
    }

    public void inventarioEquipaveis(Personagem personagem, Scanner sc) {
        System.out.println("\n=== Qual arma pretende equipar? ===");
        List<Item> lista= itens.stream()
                .filter(x -> x.isEquipavel())
                .collect(Collectors.toList());

        exibirItens(lista);

        if (!(lista.isEmpty())) {
            int armaEscolhida= sc.nextInt();
            sc.nextLine();

            personagem.setArma(getArma(armaEscolhida));
        }
    }

    public void inventarioConsumiveis(Personagem personagem, Scanner sc) {
        System.out.println("\n=== Qual consumível pretende usar? ===");
        List<Item> lista= itens.stream()
                .filter(x -> x.isConsumivel())
                .collect(Collectors.toList());

        exibirItens(lista);

        if (!(lista.isEmpty())) {
            int consumivelEscolhido = sc.nextInt();
            sc.nextLine();

            int aplica = personagem.usarItem(getConsumivel(consumivelEscolhido), personagem);

            if (aplica == 1)
                removerItem(consumivelEscolhido);
        }
    }

    public void inventarioRemoviveis(Scanner sc) {
        System.out.println("\n=== Qual item pretende remover? ===");
        exibirItens(itens);

        if (!(itens.isEmpty())) {
            int itemEscolhido = sc.nextInt();
            sc.nextLine();

            removerItem(itemEscolhido);
        }
    }
}
