
public class AtendenteTeste {

    public static void main(String[] args) {
        // Criar um leitor
        Leitor leitor = new Leitor("Alice", "123456789");

        // Criar um livro
        Livro livro = new Livro("12345", "Java Programming", "John Doe", 49.99, 10);

        // Criar um atendente
        Atendente atendente = new Atendente("Carlos", "A123");

        // Realizar uma venda de 3 exemplares do livro para o leitor
        atendente.realizarVenda(leitor, livro, 3);

        // Listar os livros emprestados pelo leitor
        leitor.listarLivrosEmprestados();
    }
}
