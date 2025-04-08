package org.example;

import java.util.*;

public class App {
    static final int TAM = 10;
    static char[][] tabuleiro = new char[TAM][TAM];
    static boolean[][] visitado = new boolean[TAM][TAM];

    // Tamanhos esperados de cada navio
    static final Map<Character, Integer> tamanhosNavios = Map.of(
            'P', 5, // Porta-aviões
            'E', 4, // Encouraçado
            'C', 3, // Cruzador
            'S', 3, // Submarino
            'N', 2  // Contratorpedeiro
    );

    // Armazena quantas células de cada navio foram encontradas
    static Map<Character, Integer> contagemCelulas = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Parte 1 – Leitura e validação do tamanho do tabuleiro
        for (int i = 0; i < TAM; i++) {
            if (!scanner.hasNextLine()) {
                System.out.println("Tabuleiro inválido: número de linhas insuficiente.");
                return;
            }

            String linha = scanner.nextLine().replaceAll("\\s+", "");

            if (linha.length() != TAM) {
                System.out.println("Tabuleiro inválido: a linha " + i + " possui " + linha.length() + " colunas, mas deveria ter 10.");
                return;
            }

            for (int j = 0; j < TAM; j++) {
                char c = linha.charAt(j);
                switch (c) {
                    case '.', 'P', 'E', 'C', 'S', 'N':
                        tabuleiro[i][j] = c;
                        break;
                    default:
                        System.out.println("Tabuleiro inválido: caractere inválido '" + c + "' na posição (" + i + ", " + j + ")");
                        return;
                }
            }
        }

        // Verifica se há mais linhas que o permitido
        if (scanner.hasNextLine()) {
            System.out.println("Tabuleiro inválido: mais de 10 linhas fornecidas.");
            return;
        }

        // Parte 2 – Inicializa contagem de células
        for (char navio : tamanhosNavios.keySet()) {
            contagemCelulas.put(navio, 0);
        }

        // Parte 3 – Conta células de cada tipo de navio
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                char c = tabuleiro[i][j];
                if (tamanhosNavios.containsKey(c)) {
                    contagemCelulas.put(c, contagemCelulas.get(c) + 1);
                }
            }
        }

        // Parte 4 – Verifica se a contagem de cada navio está correta
        for (char navio : tamanhosNavios.keySet()) {
            int esperado = tamanhosNavios.get(navio);
            int encontrado = contagemCelulas.get(navio);
            if (encontrado != esperado) {
                System.out.println("Tabuleiro inválido: quantidade de '" + navio + "' incorreta (esperado: " + esperado + ", encontrado: " + encontrado + ")");
                return;
            }
        }

        // Parte 5 – Valida alinhamento e unicidade dos navios
        int naviosValidos = 0;
        Set<Character> naviosEncontrados = new HashSet<>();

        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                char c = tabuleiro[i][j];
                if (!visitado[i][j] && tamanhosNavios.containsKey(c)) {
                    List<int[]> posicoes = new ArrayList<>();
                    dfs(i, j, c, posicoes);

                    if (!verificaAlinhamento(posicoes)) {
                        System.out.println("Tabuleiro inválido: navio '" + c + "' não está alinhado corretamente.");
                        return;
                    }

                    if (posicoes.size() != tamanhosNavios.get(c)) {
                        System.out.println("Tabuleiro inválido: tamanho incorreto do navio '" + c + "'.");
                        return;
                    }

                    if (naviosEncontrados.contains(c)) {
                        System.out.println("Tabuleiro inválido: navio '" + c + "' aparece mais de uma vez.");
                        return;
                    }

                    naviosEncontrados.add(c);
                    naviosValidos++;
                }
            }
        }

        // Parte 6 – Verifica se todos os navios foram encontrados
        if (naviosValidos != tamanhosNavios.size()) {
            System.out.println("Tabuleiro inválido: quantidade de navios incorreta.");
        } else {
            System.out.println("Tabuleiro válido");
        }
    }

    // Busca em profundidade para agrupar partes do mesmo navio
    static void dfs(int i, int j, char tipo, List<int[]> posicoes) {
        if (i < 0 || j < 0 || i >= TAM || j >= TAM) return;
        if (visitado[i][j] || tabuleiro[i][j] != tipo) return;

        visitado[i][j] = true;
        posicoes.add(new int[]{i, j});

        dfs(i + 1, j, tipo, posicoes);
        dfs(i - 1, j, tipo, posicoes);
        dfs(i, j + 1, tipo, posicoes);
        dfs(i, j - 1, tipo, posicoes);
    }

    // Verifica se o navio está em linha reta (horizontal ou vertical)
    static boolean verificaAlinhamento(List<int[]> posicoes) {
        boolean mesmaLinha = true;
        boolean mesmaColuna = true;
        int linha = posicoes.get(0)[0];
        int coluna = posicoes.get(0)[1];

        for (int[] pos : posicoes) {
            if (pos[0] != linha) mesmaLinha = false;
            if (pos[1] != coluna) mesmaColuna = false;
        }

        return mesmaLinha || mesmaColuna;
    }
}
