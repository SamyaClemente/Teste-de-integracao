public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private double preco;
    private int quantidadeEstoque;

    public Livro(String isbn, String titulo, String autor, double preco, int quantidadeEstoque) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int novaQuantidade) {
        this.quantidadeEstoque = novaQuantidade;
    }

    public void realizarVenda(int quantidade) {
        if (quantidade > 0 && quantidade <= quantidadeEstoque) {
            quantidadeEstoque -= quantidade;
            System.out.println("Venda de " + quantidade + " exemplar(es) do livro '" + titulo + "' realizada com sucesso.");
        } else {
            System.out.println("Quantidade inválida para venda ou estoque insuficiente.");
        }
    }

    public void realizarCompra(int quantidade) {
        if (quantidade > 0) {
            quantidadeEstoque += quantidade;
            System.out.println("Compra de " + quantidade + " exemplar(es) do livro '" + titulo + "' realizada com sucesso.");
        } else {
            System.out.println("Quantidade inválida para compra.");
        }
    }
}
