package exerc;

import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do array:\n ");
        int tamanhoArray = scanner.nextInt();

        PessoaIMC[] pessoas = new PessoaIMC[tamanhoArray];
        
        // Criando objetos de pessoas e adicionando dados
        for (int i = 0; i < tamanhoArray; i++) {
            System.out.print("\nDigite o tipo de objeto (Homem - H ou Mulher - M):\n ");
            String tipo = scanner.next();

            System.out.print("Digite o nome:\n  ");
            String nome = scanner.next();

            System.out.print("Digite a data de nascimento:\n  ");
            String dataNascimento = scanner.next();

            System.out.print("Digite o peso:\n ");
            double peso = scanner.nextDouble();

            System.out.print("Digite a altura:\n ");
            double altura = scanner.nextDouble();

            if (tipo.equalsIgnoreCase("H")) {
                pessoas[i] = new Homem(nome, dataNascimento, peso, altura);
            } else if (tipo.equalsIgnoreCase("M")) {
                pessoas[i] = new Mulher(nome, dataNascimento, peso, altura);
            } else {
                System.out.println("\nTipo inválido. Tente novamente.");
                i--; // retornando para uma interação passada, se for digitado um valor diferente do esperado.
            }
        }

        // Mostrando Informações
        for (PessoaIMC pessoa : pessoas) {
            System.out.println("\n" + pessoa);
            System.out.println("IMC: " + pessoa.resultIMC());
        }

        scanner.close();
    }
}
