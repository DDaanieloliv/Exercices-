import java.io.*;
import java.util.Scanner;

public class FiltroAssembler {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite o nome do arquivo de entrada:");
        String inputFile = s.nextLine();

        System.out.println("Digite o nome do arquivo de saída:");
        String outputFile = s.nextLine();

        System.out.println("Escolha o formato de saída (1 para decimal, 2 para hexadecimal, 3 para binário):");
        int formato = s.nextInt();

        try {
            InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);

            int byteRead = -1, contador_bytes=0, contador_linha = 0;
            String conteudo = "";

            while ((byteRead = inputStream.read()) != -1) {
                contador_bytes = contador_bytes + 1;

                if (contador_bytes == 1)  {
                    conteudo = formatOutput(formato, byteRead) + ",";
                }
                else if (contador_bytes % 8 == 0)  {
                    contador_linha++;
                    conteudo = formatOutput(formato, byteRead) + " ; linha "+ (contador_linha-1) + " \ndb ";
                }
                else {
                    conteudo = formatOutput(formato, byteRead) + ", ";
                }

                outputStream.write(conteudo.getBytes());
                conteudo = "";
            }

            outputStream.close();
            System.out.println("Arquivo gerado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String formatOutput(int formato, int valor) {
        switch (formato) {
            case 1: // Decimal
                return "db " + valor;
            case 2: // Hexadecimal
                return "db 0x" + Integer.toHexString(valor);
            case 3: // Binário
                return "db 0b" + Integer.toBinaryString(valor);
            default:
                return "";
        }
    }
}

/*
import java.io.*;
import java.util.Scanner;
public class FiltroAssembler {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
			System.out.println("Digite o nome do arquivo de entrada:");
			String inputFile = s.nextLine();
			System.out.println("Digite o nome do arquivo de saída:");
			String outputFile = s.nextLine(); 
			try {
			    InputStream inputStream = new FileInputStream(inputFile);
			    OutputStream outputStream = new FileOutputStream(outputFile);

 

			    int byteRead = -1, contador_bytes=0, contador_linha = 0;
			    String conteudo = "";
			    while ((byteRead = inputStream.read()) != -1) {
			        contador_bytes = contador_bytes + 1;
			        if (contador_bytes == 1)  {
			            conteudo = conteudo +"db " + byteRead + ",";
			        }
			        // momento da quebra de linha
			        else if (contador_bytes %8 == 0)  {
			            contador_linha++;
			            // adiciona quebra de linha
			            conteudo = conteudo +byteRead + " ; linha "+ (contador_linha-1) + " \ndb ";
			        }
			        else {
			            conteudo = conteudo + byteRead + ", ";
			        }
			        outputStream.write(conteudo.getBytes());
			        conteudo = "";
			    }
			    outputStream.close();
			    System.out.println("arquivo gerado com sucesso.");
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
    }
    
    public static String formatOutput(int formato, int valor) {
        switch (formato) {
            case 1: // Decimal
                return "db " + valor;
            case 2: // Hexadecimal
                return "db 0x" + Integer.toHexString(valor);
            case 3: // Binário
                return "db 0b" + Integer.toBinaryString(valor);
            default:
                return "";
        }
    }
}
*/
