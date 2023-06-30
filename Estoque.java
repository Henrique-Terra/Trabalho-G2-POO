public class Estoque extends Produto {
    private int quantidade;
    //private Produto produto;

    public Estoque(String nome, double preco, int quantidade) {
        //produto = new Produto(nome, preco)
        
        super(nome, preco);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
