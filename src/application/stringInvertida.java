package application2;

import java.util.Scanner;

public class stringInvertida {

    public static void swap(int i, char[] string, int n) {
        if (i == n || i > n) {
            return;
        }

        char aux = string[i];
        string[i] = string[n];
        string[n] = aux;
        swap(i + 1, string, n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma string: ");
        String string = scanner.nextLine();
        
        char[] caracteres = string.toCharArray();

        int tam = caracteres.length;

        swap(0, caracteres, tam - 1);

        
        String stringInvertida = new String(caracteres);

        System.out.println(stringInvertida);

        scanner.close();
    }
}