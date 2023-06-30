public class VendasProduto extends Produto {
    private int quantidade;

    public VendasProduto(String nome, double preco, int quantidade) {
        super(nome, preco);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return quantidade * getPreco();
    }
}
