import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Qual a quantidade de peças? ");
		int numPecas = scan.nextInt();
		System.out.println("Qual o primeiro elemento do trio numérico? ");
		int trio1 = scan.nextInt();
		System.out.println("Qual o segundo elemento do trio numérico? ");
		int trio2 = scan.nextInt();
		System.out.println("Qual o terceiro elemento do trio numérico? ");
		int trio3 = scan.nextInt();
		
		ArrayList<Integer> trio = new ArrayList<>();
		trio.add(trio1);
		trio.add(trio2);
		trio.add(trio3);
		
		Tabuleiro tabuleiro = new Tabuleiro(numPecas, trio);
		System.out.println("\n");
		tabuleiro.gerarResultados();
		
		scan.close();

	}

}
