package org.example;

public class App {
    public static void main(String[] args) {
        // Verifica se os parâmetros foram passados corretamente
        if (args.length < 2) {
            System.out.println("Por favor, forneça a forma e o tamanho.");
            return;
        }

        String forma = args[0];  // Forma escolhida (triangulo, losango ou quadrado)
        int tamanho = Integer.parseInt(args[1]);  // Tamanho desejado
        //ou seja precisa entrar com dois parametros, forma e tamanho com --args

        // Utilizando switch-case, entrando no raciocinio
        switch (forma) {
            case "triangulo":
                desenharTriangulo(tamanho);
                break;
            case "losango":
                desenharLosango(tamanho);
                break;
            case "retangulo":
                if (args.length < 3) {
                    System.out.println("Por favor, forneça a altura e a largura para o retangulo.");
                    return;
                }
                int largura = Integer.parseInt(args[2]);
                desenharRetangulo(tamanho, largura);
                break;
            default:
                System.out.println("Forma inválida!");
        }
    }

    public static void desenharTriangulo(int tamanho) {
        System.out.println("Triângulo:");
        for (int i = 1; i <= tamanho; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void desenharLosango(int tamanho) {
        System.out.println("Losango:");

        //tamanho precisa ser impar, e meio seria o meio do losango
        int meio = tamanho / 2;
        for (int i = 0; i <= meio; i++) {
            for (int j = 0; j < meio - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = meio - 1; i >= 0; i--) {
            for (int j = 0; j < meio - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void desenharRetangulo(int altura, int largura) {
        System.out.println("Retangulo:");
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if (i == 0 || i == altura - 1 || j == 0 || j == largura - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}