package org.example;
import java.util.Random;

public class App {
    //Tabuleiro 10x10
    static final int TAM = 10;
    static final char VAZIO = '.';
    static char[][] tabuleiro;

    public static void main(String[] args) {

        tabuleiro = criarTabuleiroVazio(); // inicializa aqui
        imprimirTabuleiro();
    }


    //cria com .
    static char[][] criarTabuleiroVazio() {
        char[][] matriz = new char[TAM][TAM]; // ainda precisa do new aqui
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                matriz[i][j] = VAZIO;
            }
        }
        return matriz;
    }

    //imprime o tabuleiro
    static void imprimirTabuleiro() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
}

