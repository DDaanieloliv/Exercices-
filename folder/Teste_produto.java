package exerc_0;

public class Teste_produto {
    public static void main(String[] args) {
       Fornecedor fornecedor1 = new Fornecedor("123456789", "987654321", "Fornecedor A");

        Produto produto1 = new Produto(1, "Produto A", 100.0f, fornecedor1);

        System.out.println("Valor do produto antes do aumento: " + produto1.getValor());

        produto1.atualizarPreco(10.0f);

        System.out.println("Valor do produto após o aumento: " + produto1.getValor());
    }
    
}
