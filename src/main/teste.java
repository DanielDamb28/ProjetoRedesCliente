package main;
import java.util.Random;

public class teste {

	public static void main(String[] args) {
        // Defina os limites do intervalo
        int limiteInferior = 0;
        int limiteSuperior = 15;

        // Crie uma instância da classe Random
        Random random = new Random();

        // Gere um número aleatório dentro do intervalo
        int numeroAleatorio = random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;

        // Exiba o número aleatório gerado
        System.out.println("Número Aleatório: " + numeroAleatorio);
	}
}
