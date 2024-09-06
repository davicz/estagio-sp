package application3;

import java.util.Scanner;

public class Fibo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Informe um número: ");
		int num = scanner.nextInt();

		if (pertenceFibonacci(num)) {
			System.out.println(num + " pertence à sequência de Fibonacci.");
		} else {
			System.out.println(num + " não pertence à sequência de Fibonacci.");
		}

		scanner.close();
	}

	public static boolean pertenceFibonacci(int num) {
		int i = 0, j = 1, k;

		if (num == 0 || num == 1) {
			return true;
		}

		while (j <= num) {
			k = i + j;
			i = j;
			j = k;

			if (j == num) {
				return true;
			}
		}
		return false;
	}
}
