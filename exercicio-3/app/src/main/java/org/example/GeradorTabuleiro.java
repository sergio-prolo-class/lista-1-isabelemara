package org.example;

public class GeradorTabuleiro {
    static final int TAM = 10;
    static final char VAZIO = '.';
    static final char[][] tabuleiro = new char[TAM][TAM];

    public static void main(String[] args) {
        inicializarTabuleiro();
        imprimirTabuleiro();
    }

    static void inicializarTabuleiro() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                tabuleiro[i][j] = VAZIO;
            }
        }
    }

    static void imprimirTabuleiro() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
}
