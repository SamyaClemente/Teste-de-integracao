import java.util.Date;

public class Atendente {
    private String nome;
    private String matricula;

    public Atendente(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void realizarVenda(Leitor leitor, Livro livro, int quantidade) {
        double totalVenda = livro.getPreco() * quantidade;

        if (quantidade > 0 && quantidade <= livro.getQuantidadeEstoque() && leitor.getSaldoTotal() >= totalVenda) {
            livro.realizarVenda(quantidade);
            leitor.debitarSaldo(totalVenda);
            System.out.println("Venda realizada com sucesso para o leitor " + leitor.getNome() +
                    ". Valor total: R$" + totalVenda + ". Atendente: " + nome);
        } else {
            System.out.println("Não foi possível realizar a venda. Verifique a quantidade em estoque ou o saldo do leitor.");
        }
    }

    public void processarDevolucao(Leitor leitor, Livro livro, int quantidade) {
        if (quantidade > 0 && quantidade <= livro.getQuantidadeEstoque()) {
            livro.realizarCompra(quantidade);
            leitor.creditarSaldo(livro.getPreco() * quantidade);
            System.out.println("Devolução processada com sucesso para o leitor " + leitor.getNome() +
                    ". Valor reembolsado: R$" + livro.getPreco() * quantidade + ". Atendente: " + nome);
        } else {
            System.out.println("Não foi possível processar a devolução. Verifique a quantidade em estoque.");
        }
    }

    public void realizarTransacao(ContaBancaria origem, ContaBancaria destino, double valor) {
        if (origem != null && destino != null && valor > 0 && origem.getSaldo() >= valor) {
            origem.sacar(valor);
            destino.depositar(valor);
            System.out.println("Transação de R$" + valor + " realizada com sucesso de " + origem.getTitular() +
                    " para " + destino.getTitular() + " por " + nome);
        } else {
            System.out.println("Não foi possível realizar a transação. Verifique as contas envolvidas ou o valor da transação.");
        }
    }
}
