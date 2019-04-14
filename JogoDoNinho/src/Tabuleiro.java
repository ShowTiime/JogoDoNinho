
import java.util.ArrayList;

public class Tabuleiro {

	private char[] pecas;
	private ArrayList<Integer> trioNumerico;
	
	public Tabuleiro(int numPecas, ArrayList<Integer> trioNumerico) {
		pecas = new char[numPecas + 1];
		this.trioNumerico = trioNumerico;
	}
	
	public void gerarResultados() {
		
		// setar como G os números do trio numérico
		for (int i = 0; i < 3; i++) {
			this.pecas[this.trioNumerico.get(i)] = 'G';
		}
		
		int maiorQue = 0;
		
		// calcular o resto do tabuleiro
		for (int i = 0; i < this.pecas.length; i++) {
			
			if(this.hasIn(i, trioNumerico)) { // verificar se o i testado é um dos trios numéricos
				continue;
			} else {
				
				for(int j = 0; j < 3; j++) { // verifica para quais valores do trio o i é maior
					if (i > this.trioNumerico.get(j)) {
						maiorQue++;
					}
				}
				
				this.pecas[i] = this.calcularPG(i, maiorQue);
				maiorQue = 0;
				
			}
			
		}
		
		this.mostrarTabela();
		
	}
	
	private boolean hasIn(int num, ArrayList<Integer> lista) {
		boolean has = false;
		
		for (int i = 0; i < lista.size(); i++) {
			if (num == lista.get(i)) {
				has = true;
			}
		}
		
		return has;
	}
	
	private char calcularPG (int num, int maiorQue) {
		
		char PG = 'N';
		
		switch (maiorQue) {
		case 1:
			int sub = num - this.trioNumerico.get(0);
			if (this.pecas[sub] == 'G') {
				PG = 'P';
			} else {
				PG = 'G';
			}
			
			break;
		case 2:
			int numP = 0;
			
			int sub1 = num - this.trioNumerico.get(0);
			int sub2 = num - this.trioNumerico.get(1);
			
			if(this.pecas[sub1] == 'P') {
				numP++;
			}
			
			if(this.pecas[sub2] == 'P') {
				numP++;
			}
			
			if (numP == 0) {
				PG = 'P';
			} else {
				PG = 'G';
			}
						
			break;
		case 3:
			int qtdP = 0;
			
			int num1 = num - this.trioNumerico.get(0);
			int num2 = num - this.trioNumerico.get(1);
			int num3 = num - this.trioNumerico.get(2);
			
			if(this.pecas[num1] == 'P') {
				qtdP++;
			}
			
			if(this.pecas[num2] == 'P') {
				qtdP++;
			}
			
			if(this.pecas[num3] == 'P') {
				qtdP++;
			}
			
			if (qtdP == 0) {
				PG = 'P';
			} else {
				PG = 'G';
			}
						
			break;
		default:
			PG = 'P';
			break;
		}
		
		return PG;
	}
	
	public void mostrarTabela() {
		
		for (int i = 0; i < this.pecas.length; i++) {
			System.out.print(i +  "\t");
		}
		System.out.println("");
		for (int i = 0; i < this.pecas.length; i++) {
			System.out.print(this.pecas[i] + "\t");
		}
		
	}
	
}
