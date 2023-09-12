
package exerc_0;


import java.util.ArrayList;
import java.util.Iterator;

public class ConjuntoProdutos {
    private ArrayList<Produto> produtos;

    public ConjuntoProdutos() {
        produtos = new ArrayList<>();
    }

    public void inserirProduto(Produto produto) {
        if (!existeProduto(produto.getCodigo())) {
            produtos.add(produto);
            System.out.println("Produto inserido com sucesso.");
        } else {
            System.out.println("Já existe um produto com o mesmo código.");
        }
    }

    public void removerProduto(int codigo) {
        Iterator<Produto> iterator = produtos.iterator();
        boolean encontrado = false;

        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getCodigo() == codigo) {
                iterator.remove();
                System.out.println("Produto removido com sucesso.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado.");
        }
    }

    public void atualizarProduto(Produto produtoAtualizado) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getCodigo() == produtoAtualizado.getCodigo()) {
                produtos.set(i, produtoAtualizado);
                System.out.println("Produto atualizado com sucesso.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public void mostrarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            System.out.println("Lista de Produtos:");
            for (Produto produto : produtos) {
                System.out.println("Código: " + produto.getCodigo());
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Valor: " + produto.getValor());
                System.out.println("Fornecedor: " + produto.getFornecedor().getNome());
                System.out.println("--------------------");
            }
        }
    }

    public void atualizarPrecos(float percentualAumento) {
        for (Produto produto : produtos) {
            produto.atualizarPreco(percentualAumento);
        }

        System.out.println("Preços atualizados com sucesso.");
    }

    private boolean existeProduto(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }
}
