package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    static final int TAM = 10;
    static char[][] tabuleiro = new char[TAM][TAM];

    public static void main(String[] args) {
        String caminhoArquivo = "/home/isabele/POO/lista-1-isabelemara/exercicio-3/app/tabuleiro.txt";

        try {
            lerTabuleiroDeArquivo(caminhoArquivo);
            imprimirTabuleiro(); // Apenas para verificar a leitura por enquanto
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    // Lê o tabuleiro linha a linha do arquivo e preenche a matriz
    static void lerTabuleiroDeArquivo(String caminho) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        String linha;
        int i = 0;

        while ((linha = br.readLine()) != null && i < TAM) {
            linha = linha.replaceAll(" ", ""); // Remove espaços
            for (int j = 0; j < TAM && j < linha.length(); j++) {
                tabuleiro[i][j] = linha.charAt(j);
            }
            i++;
        }
        br.close();
    }

    // Apenas mostra o tabuleiro carregado do arquivo (para debug)
    static void imprimirTabuleiro() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
}
