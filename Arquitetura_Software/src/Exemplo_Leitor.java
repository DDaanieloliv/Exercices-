import java.io.*;

public class Exemplo_Leitor {
    public static void main(String[] args) {
        // Declaração da variável inputstream
        InputStream inputstream;

        try {
            // Cria uma nova instância de FileInputStream associada ao arquivo "exemplo.txt"
            inputstream = new FileInputStream("Haja.txt");

            // Lê o primeiro byte do arquivo
            int data = inputstream.read();

            // Imprime uma mensagem indicando que o conteúdo do arquivo será exibido
            System.out.println("Conteúdo do arq. Haja.txt:");

            // Enquanto o valor lido não for -1 (final do arquivo)
            while (data != -1) {
                // Converte o valor inteiro lido em um caractere e o imprime
                System.out.print((char) data);

                // Lê o próximo byte do arquivo
                data = inputstream.read();
            }

            // Fecha o fluxo de entrada
            inputstream.close();
        } catch (Exception e1) {
            // Em caso de erro, imprime o rastreamento da exceção
            e1.printStackTrace();
        }
    }
}
