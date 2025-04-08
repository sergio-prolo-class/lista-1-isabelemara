package org.example;

import java.util.*;

public class App {
    static final int TAM = 10;
    static char[][] tabuleiro = new char[TAM][TAM];
    static boolean[][] visitado = new boolean[TAM][TAM];

    static final Map<Character, Integer> tamanhosNavios = Map.of(
            'P', 5,
            'E', 4,
            'C', 3,
            'S', 3,
            'N', 2
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura do tabuleiro
        for (int i = 0; i < TAM; i++) {
            if (!scanner.hasNextLine()) {
                System.out.println("Tabuleiro inválido: menos de 10 linhas.");
                return;
            }

            String linha = scanner.nextLine().trim();
            String[] colunas = linha.split("\\s+");

            if (colunas.length != TAM) {
                System.out.println("Tabuleiro inválido: a linha " + (i + 1) + " possui " + colunas.length + " colunas, mas deveria ter 10.");
                return;
            }

            for (int j = 0; j < TAM; j++) {
                char c = colunas[j].charAt(0);
                tabuleiro[i][j] = c;

                if (!tamanhosNavios.containsKey(c) && c != '.') {
                    System.out.println("Tabuleiro inválido: caractere inválido '" + c + "' na posição (" + (i + 1) + "," + (j + 1) + ").");
                    return;
                }
            }
        }

        // Verificação por blocos DFS
        Set<Character> naviosEncontrados = new HashSet<>();

        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                char c = tabuleiro[i][j];
                if (!visitado[i][j] && tamanhosNavios.containsKey(c)) {
                    List<int[]> posicoes = new ArrayList<>();
                    dfs(i, j, c, posicoes);

                    if (naviosEncontrados.contains(c)) {
                        System.out.println("Tabuleiro inválido: navio '" + c + "' aparece mais de uma vez.");
                        return;
                    }

                    if (!verificaAlinhamento(posicoes)) {
                        System.out.println("Tabuleiro inválido: navio '" + c + "' deve estar na horizontal ou vertical.");
                        return;
                    }

                    if (posicoes.size() != tamanhosNavios.get(c)) {
                        System.out.println("Tabuleiro inválido: tamanho incorreto do navio '" + c + "' (esperado: " + tamanhosNavios.get(c) + ", encontrado: " + posicoes.size() + ").");
                        return;
                    }

                    naviosEncontrados.add(c);
                }
            }
        }

        // Verifica se todos os tipos de navios foram encontrados
        if (naviosEncontrados.size() != tamanhosNavios.size()) {
            System.out.println("Tabuleiro inválido: não inclui um navio de cada tipo.");
        } else {
            System.out.println("Tabuleiro válido");
        }
    }

    // DFS para marcar o navio completo
    static void dfs(int i, int j, char tipo, List<int[]> posicoes) {
        if (i < 0 || j < 0 || i >= TAM || j >= TAM) return;
        if (visitado[i][j] || tabuleiro[i][j] != tipo) return;

        visitado[i][j] = true;
        posicoes.add(new int[]{i, j});

        // Agora inclui diagonais
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di != 0 || dj != 0) {
                    dfs(i + di, j + dj, tipo, posicoes);
                }
            }
        }
    }


    // Verifica alinhamento reto
    static boolean verificaAlinhamento(List<int[]> posicoes) {
        if (posicoes.isEmpty()) return false;

        boolean mesmaLinha = true;
        boolean mesmaColuna = true;
        int linhaRef = posicoes.get(0)[0];
        int colunaRef = posicoes.get(0)[1];

        for (int[] pos : posicoes) {
            if (pos[0] != linhaRef) mesmaLinha = false;
            if (pos[1] != colunaRef) mesmaColuna = false;
        }

        if (!mesmaLinha && !mesmaColuna) return false;

        List<Integer> indices = new ArrayList<>();
        if (mesmaLinha) {
            for (int[] pos : posicoes) indices.add(pos[1]);
        } else {
            for (int[] pos : posicoes) indices.add(pos[0]);
        }
        Collections.sort(indices);
        for (int i = 1; i < indices.size(); i++) {
            if (indices.get(i) != indices.get(i - 1) + 1) return false;
        }

        return true;
    }
}
