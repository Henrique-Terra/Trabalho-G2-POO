import java.util.Scanner;

public class CarrinhoProduto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Estoque[] Estoque = {
                new Estoque("Camisa", 75.0, 10),
                new Estoque("Calça", 150.0, 5),
                new Estoque("Casaco", 200.0, 3),
                new Estoque("Pijama", 175.0, 8)
        };

        VendasProduto[] VendasProdutos = new VendasProduto[Estoque.length];
        double total = 0.0;

        System.out.print("Digite o seu nome: ");
        String nome = input.nextLine();

        System.out.println("Bem-Vindo à Loja Use, aqui estão nossos produtos:");
        for (int i = 0; i < Estoque.length; i++) {
            System.out.println((i + 1) + " - " + Estoque[i].getNome() + " - R$ " + Estoque[i].getPreco() + " (unidade)");
        }

        boolean continuar = true;
        while (continuar) {
            System.out.print("\nDigite o número do produto que deseja adicionar (ou 0 para ir ao checkout): ");
            int escolha = input.nextInt();

            if (escolha == 0) {
                continuar = false;
            } else if (escolha < 1 || escolha > Estoque.length) {
                System.out.println("Opção inválida.");
            } else {
                System.out.print("Digite a quantidade desejada: ");
                int quantidade = input.nextInt();
                Estoque produtoEscolhido = Estoque[escolha - 1];

                if (produtoEscolhido.getQuantidade() >= quantidade) {
                    produtoEscolhido.setQuantidade(produtoEscolhido.getQuantidade() - quantidade);

                    VendasProduto VendasProduto = new VendasProduto(produtoEscolhido.getNome(), produtoEscolhido.getPreco(), quantidade);
                    VendasProdutos[escolha - 1] = VendasProduto;

                    System.out.println(VendasProduto.getNome() + " adicionado(a) ao carrinho.");
                } else {
                    System.out.println("Quantidade indisponível no estoque.");
                }
            }
        }

        System.out.println("\nResumo do Carrinho do(a) " + nome + ":");

        for (int i = 0; i < VendasProdutos.length; i++) {
            if (VendasProdutos[i] != null) {
                double subtotal = VendasProdutos[i].getSubtotal();
                System.out.println(VendasProdutos[i].getQuantidade() + " " + VendasProdutos[i].getNome() + "(s)" + " - Subtotal: R$ " + subtotal);
                total += subtotal;
            }
        }

        System.out.println("Valor total: R$ " + total);

        DataHora dataHora = new DataHora(nome, total);
        dataHora.printVendaHorario();


        System.out.println("Agradecemos pela parceria e pela preferência!");

        input.close();
    }
}
