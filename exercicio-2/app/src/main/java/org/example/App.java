package org.example;

public class App {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Por favor, forneça 4 cores.");
            return;
        }

        // Converte as duas primeiras cores para números
        int digito1 = obterValor(args[0]);
        int digito2 = obterValor(args[1]);

        // Mostra os valores convertidos
        System.out.println("Dígito 1: " + digito1);
        System.out.println("Dígito 2: " + digito2);
    }

    public static int obterValor(String cor) {
        switch (cor.toLowerCase()) {
            case "preto": return 0;
            case "marrom": return 1;
            case "vermelho": return 2;
            case "laranja": return 3;
            case "amarelo": return 4;
            case "verde": return 5;
            case "azul": return 6;
            case "violeta": return 7;
            case "cinza": return 8;
            case "branco": return 9;
            default: return -1; // Se a cor não for válida
        }
    }
}
