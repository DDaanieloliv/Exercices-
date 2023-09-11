package contaBanco;


//Importando as bibliotecas necessárias
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


/*
Banco de Dados CRIADO

 CREATE TABLE Contas (    
    numeroConta int PRIMARY KEY,     
    nomeCliente VARCHAR(50) NOT NULL,
    saldo DECIMAL(9,2)  NOT NULL);

 select * from Contas;

*/

//Classe que representa uma conta bancária
class ContaBancaria {
    private String nomeCliente;
    private int numeroConta;
    private double saldo;

    // Construtor para inicializar a conta
    public ContaBancaria(String nomeCliente, int numeroConta, double saldo) {
        this.nomeCliente = nomeCliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    // Métodos para obter informações da conta
    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    // Método para representar a conta como uma string
    @Override
    public String toString() {
        return "ContaBancaria [nomeCliente=" + nomeCliente + ", numeroConta=" + numeroConta + ", saldo=" + saldo + "]";
    }
}

//Classe principal do sistema bancário
public class SistemaBancario {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/ContaBD";
    private static final String USUARIO = "root";
    private static final String SENHA = "minha_senha";
    private static Connection conexao;
    private static ArrayList<ContaBancaria> contas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Método principal que inicia o sistema bancário
    public static void main(String[] args) {
        
    	// Estabelecendo a conexão com o banco de dados
    	try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    	
    	 // Loop principal do sistema
    	int opcao;
        do {
            System.out.println("1- Cadastrar conta");
            System.out.println("2- Consultar conta");
            System.out.println("3- Alterar conta");
            System.out.println("4- Remover conta");
            System.out.println("5- Exibir todas as contas");
            System.out.println("6- Sair do sistema");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarConta();
                    break;
                case 2:
                    consultarConta();
                    break;
                case 3:
                    alterarConta();
                    break;
                case 4:
                    removerConta();
                    break;
                case 5:
                    exibirTodasAsContas();
                    break;
                case 6:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

 // Método para cadastrar uma nova conta
    public static void cadastrarConta() {
    	try {
    		// Lendo os dados da nova conta do usuário
            System.out.print("Digite o número da conta: ");
            int numeroConta = scanner.nextInt();
            scanner.nextLine();	// Limpa o buffer

            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = scanner.nextLine();

            System.out.print("Digite o saldo inicial: ");
            double saldo = scanner.nextDouble();
            
            // Preparando a instrução SQL para inserir a nova conta no banco de dados
            PreparedStatement statement = conexao.prepareStatement("INSERT INTO contas (numeroConta, nomeCliente, saldo) VALUES (?, ?, ?)");
            statement.setInt(1, numeroConta);
            statement.setString(2, nomeCliente);
            statement.setDouble(3, saldo);

            // Executando a inserção e verificando se foi bem-sucedida	
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Conta cadastrada com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para consultar uma conta existente
    public static void consultarConta() {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                System.out.println(conta);
                return;
            }
        }

        System.out.println("Conta não encontrada.");
    }

    // Métodos para alterar e remover contas
    public static void alterarConta() {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                System.out.print("Digite o novo saldo: ");
                double novoSaldo = scanner.nextDouble();
                conta.setSaldo(novoSaldo);
                System.out.println("Saldo atualizado com sucesso.");
                return;
            }
        }

        System.out.println("Conta não encontrada.");
    }

    public static void removerConta() {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                contas.remove(conta);
                System.out.println("Conta removida com sucesso.");
                return;
            }
        }

        System.out.println("Conta não encontrada.");
    }

 // Método para exibir todas as contas cadastradas
    public static void exibirTodasAsContas() {
        for (ContaBancaria conta : contas) {
            System.out.println(conta);
        }
    }
}


