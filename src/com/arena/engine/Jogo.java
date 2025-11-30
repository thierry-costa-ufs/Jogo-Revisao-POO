package com.arena.engine;

import com.arena.inventario.Inventario;
import com.arena.modelo.Heroi;
import com.arena.modelo.Personagem;

import java.util.Random;
import java.util.Scanner;

public class Jogo {
    Scanner sc= new Scanner(System.in);
    private boolean estado;
    private int escolha;
    Personagem heroi;
    Personagem monstro;
    Inventario inventario;

    public Jogo(){
        estado= false;
        escolha= 0;
    }

    public void iniciarJogo() {
        heroi= new Heroi(null);
        inventario= new Inventario();

        criarHeroi();
        System.out.println("Seja bem-vindo a Folksville, " + heroi.getNome() + "!");

        while (true) {
            System.out.println("\n=== Qual é o seu próximo passo? ===\n[1] EXPLORAR\n[2] INVENTÁRIO\n[3] PAUSAR");
            escolha= sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1: // EXPLORAR
                    gerarEvento();
                    break;

                case 2: // INVENTARIO
                    inventario.inventarioGeral(heroi, sc);
                    break;

                case 3: // PAUSAR
                    menuPausa();
                    break;
            }

            escolha= 0;
        }
    }

    public void menuInicial() {
        System.out.println("\n=== Pronto para jogar? ===\n[1] JOGAR\n[2] OPÇÕES\n[3] SAIR");

        // ESCOLHA
        escolha= sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                estado= true;
                iniciarJogo();
                break;

            case 2:
                mostrarOpcoes();
                break;

            case 3:
                System.exit(0);

            default:
                System.out.println("Opção Inválida!"); break;
        }

        // RESETA
        escolha= 0;
    }

    public void menuPausa() {
        estado= false;

        // MENU
        do {
            System.out.println("\n=== O que houve? ===\n[1] CONTINUAR\n[2] DESISTIR");

            // ESCOLHA
            escolha= sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    estado= true;
                    break;

                case 2:
                    System.exit(0);

                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (!estado);

        // RESETA
        escolha= 0;
    }

    public void gerarEvento() {
        Random rand= new Random();
        int sorteio= rand.nextInt(9);

        if (sorteio < 5) {
            Batalha batalha= new Batalha();
            batalha.iniciarBatalha(heroi, monstro, sc);
        }
        else System.out.println();
    }

    public void mostrarOpcoes() {

    }

    public void criarHeroi() {
        String resposta;

        System.out.println("\nQual é o seu nome, herói?");
        resposta = sc.nextLine();

        heroi.setNome(resposta);
    }
}