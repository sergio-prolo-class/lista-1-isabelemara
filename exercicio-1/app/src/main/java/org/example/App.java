package org.example;

/// falta quadrado


public class App {
    public static void main(String[] args) {
        // Verifica se os parâmetros foram passados corretamente
        if (args.length < 2) {
            System.out.println("Por favor, forneça a forma e o tamanho.");
            return;
        }

        String forma = args[0];  // Forma escolhida (triangulo ou losango)
        int tamanho = Integer.parseInt(args[1]);  // Tamanho desejado (altura ou tamanho)

        // Condicional para desenhar a forma desejada
        if (forma.equals("triangulo")) {
            // Desenhando o triângulo do topo para a base
            System.out.println("Triangulo:");
            for (int i = 1; i <= tamanho; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        } else if (forma.equals("losango")) {
            // Desenhando o losango
            System.out.println("Losango:");

            // Parte superior do losango
            for (int i = 1; i <= tamanho; i += 2) {
                // Espaços antes dos asteriscos
                for (int j = 0; j < (tamanho - i) / 2; j++) {
                    System.out.print(" ");
                }
                // Asteriscos
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            // Parte inferior do losango
            for (int i = tamanho - 2; i > 0; i -= 2) {
                // Espaços antes dos asteriscos
                for (int j = 0; j < (tamanho - i) / 2; j++) {
                    System.out.print(" ");
                }
                // Asteriscos
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        } else {
            System.out.println("Forma inválida!");
        }
    }
}
