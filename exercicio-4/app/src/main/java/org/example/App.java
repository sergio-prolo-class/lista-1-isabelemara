package org.example;

import java.util.Scanner;

public class App {
    static final int TAM = 10;
    static char[][] tabuleiro = new char[TAM][TAM];

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int linhaAtual = 0;

        while (entrada.hasNextLine() && linhaAtual < TAM) {
            String linha = entrada.nextLine().replaceAll(" ", "");

            if (linha.length() != TAM) {
                System.out.println("Linha inválida com tamanho diferente de 10.");
                return;
            }

            for (int j = 0; j < TAM; j++) {
                tabuleiro[linhaAtual][j] = linha.charAt(j);
            }

            linhaAtual++;
        }

        if (linhaAtual != TAM) {
            System.out.println("Arquivo não contém 10 linhas.");
            return;
        }

        System.out.println("Tabuleiro carregado com sucesso:");
        imprimirTabuleiro();
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
