public class Venda {
    private String nomeAtendente;
    private String matriculaAtendente;

    public Venda(String nomeAtendente, String matriculaAtendente) {
        this.nomeAtendente = nomeAtendente;
        this.matriculaAtendente = matriculaAtendente;
    }

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public String getMatriculaAtendente() {
        return matriculaAtendente;
    }

    public void realizarVenda(Leitor leitor, Livro livro, int quantidade) {
        double totalVenda = livro.getPreco() * quantidade;

        if (quantidade > 0 && quantidade <= livro.getQuantidadeEstoque() && leitor.getSaldoTotal() >= totalVenda) {
            livro.realizarVenda(quantidade);
            leitor.debitarSaldo(totalVenda);
            System.out.println("Venda realizada com sucesso para o leitor " + leitor.getNome() +
                    ". Valor total: R$" + totalVenda + ". Atendente: " + nomeAtendente);
        } else {
            System.out.println("Não foi possível realizar a venda. Verifique a quantidade em estoque ou o saldo do leitor.");
        }
    }

    public void processarDevolucao(Leitor leitor, Livro livro, int quantidade) {
        if (quantidade > 0 && quantidade <= livro.getQuantidadeEstoque()) {
            livro.realizarCompra(quantidade);
            leitor.creditarSaldo(livro.getPreco() * quantidade);
            System.out.println("Devolução processada com sucesso para o leitor " + leitor.getNome() +
                    ". Valor reembolsado: R$" + livro.getPreco() * quantidade + ". Atendente: " + nomeAtendente);
        } else {
            System.out.println("Não foi possível processar a devolução. Verifique a quantidade em estoque.");
        }
    }
}
