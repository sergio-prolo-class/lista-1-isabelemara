package org.example;

public class App {
    public static void main(String[] args) {
        if (args.length < 3 || args.length > 4) {
            System.out.println("Uso correto: java Resistor <cor1> <cor2> <multiplicador> [tolerância]");
            return;
        }

        int digito1 = obterValorCor(args[0]);
        int digito2 = obterValorCor(args[1]);
        double multiplicador = obterMultiplicador(args[2]);
        String tolerancia = args.length == 4 ? obterTolerancia(args[3]) : "20%";

        //descartando os numeros negativos
        if (digito1 == -1 || digito2 == -1 || multiplicador == -1) {
            System.out.println("Erro: Cor inválida fornecida.");
            return;
        }

        double resistencia = (digito1 * 10 + digito2) * multiplicador;

        System.out.printf("Resistência: %.1f Ω (+- %s)\n", resistencia, tolerancia);
    }

    public static int obterValorCor(String cor) {
        switch (cor) {
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
            default: return -1;
        }
    }

    public static double obterMultiplicador(String cor) {
        switch (cor) {
            case "preto": return 1;
            case "marrom": return 10;
            case "vermelho": return 100;
            case "laranja": return 1000;
            case "amarelo": return 10000;
            case "verde": return 100000;
            case "azul": return 1000000;
            case "violeta": return 10000000;
            case "cinza": return 100000000;
            case "branco": return 1000000000;
            case "dourado": return 0.1;
            case "prata": return 0.01;
            default: return -1;
        }
    }

    public static String obterTolerancia(String cor) {
        switch (cor) {
            case "marrom": return "1%";
            case "vermelho": return "2%";
            case "verde": return "0,5%";
            case "azul": return "0,25%";
            case "violeta": return "0,1%";
            case "cinza": return "0,05%";
            case "dourado": return "5%";
            case "prata": return "10%";
            default: return "20%";
        }
    }
}
