package application4;

import java.util.Scanner;

public class faturamentoMensal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		 double sp = 67836.43;
		 double rj = 36678.66;
		 double mg = 292298.80;
		 double es = 27165.48;
		 double outros = 19849.53;

		 double total = sp + rj + mg + es + outros;
		 
	        System.out.printf("SP: %.2f%%\n", (sp / total) * 100);
	        System.out.printf("RJ: %.2f%%\n", (rj / total) * 100);
	        System.out.printf("MG: %.2f%%\n", (mg / total) * 100);
	        System.out.printf("ES: %.2f%%\n", (es / total) * 100);
	        System.out.printf("Outros: %.2f%%\n", (outros / total) * 100);
	}

}
