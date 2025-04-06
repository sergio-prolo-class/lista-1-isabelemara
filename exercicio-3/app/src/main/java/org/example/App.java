package org.example;
import java.util.Random;

public class App {
    static final int TAM = 10;
    static final char VAZIO = '.';
    static char[][] tabuleiro;
    static Random rand = new Random();

    public static void main(String[] args) {
        tabuleiro = criarTabuleiroVazio();     // Cria o tabuleiro 10x10 vazio
        posicionarNavios();                    // Posiciona os navios aleatoriamente
        imprimirTabuleiro();                   // Mostra o tabuleiro final
    }

    // Cria um tabuleiro com todos os espaços marcados como '.'
    static char[][] criarTabuleiroVazio() {
        char[][] matriz = new char[TAM][TAM];
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                matriz[i][j] = VAZIO;
            }
        }
        return matriz;
    }

    // Mostra o tabuleiro no console, linha por linha
    static void imprimirTabuleiro() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Posiciona os navios aleatoriamente no tabuleiro
    static void posicionarNavios() {
        // Tipos de navios e seus respectivos tamanhos
        char[] tipos = {'P', 'E', 'C', 'S', 'N'};
        int[] tamanhos = {5, 4, 3, 3, 2};

        // Para cada navio
        for (int i = 0; i < tipos.length; i++) {
            boolean colocado = false;
            while (!colocado) {
                // Gera posição aleatória
                int linha = rand.nextInt(TAM);
                int coluna = rand.nextInt(TAM);
                boolean horizontal = rand.nextBoolean();

                // Verifica se é possível colocar o navio nessa posição
                if (podeColocar(linha, coluna, tamanhos[i], horizontal)) {
                    for (int j = 0; j < tamanhos[i]; j++) {
                        if (horizontal) {
                            tabuleiro[linha][coluna + j] = tipos[i];
                        } else {
                            tabuleiro[linha + j][coluna] = tipos[i];
                        }
                    }
                    colocado = true;
                }
            }
        }
    }

    // Verifica se o espaço está livre e se o navio cabe na posição
    static boolean podeColocar(int linha, int coluna, int tamanho, boolean horizontal) {
        if (horizontal) {
            if (coluna + tamanho > TAM) return false;
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[linha][coluna + j] != VAZIO) return false;
            }
        } else {
            if (linha + tamanho > TAM) return false;
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[linha + j][coluna] != VAZIO) return false;
            }
        }
        return true;
    }
}
