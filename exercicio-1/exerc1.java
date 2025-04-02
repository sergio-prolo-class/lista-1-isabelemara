import java.util.Scanner;

public class exerc1 {
    public static void main(String[] args) {
        //scanner para ler tamanho do teclado do usuario
        Scanner tamanho = new Scanner(System.in);
        System.out.println("Digite a altura:");
        //altura recebe o tamanho desejado
        int altura = tamanho.nextInt();
        tamanho.close();

        // Desenhando o triângulo do topo para a base
        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
