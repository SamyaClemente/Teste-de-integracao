import java.util.ArrayList;
import java.util.List;

public class Leitor {
    private String nome;
    private String cpf;
    private List<Livro> livrosEmprestados;

    public Leitor(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.livrosEmprestados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void realizarEmprestimo(Livro livro) {
        livrosEmprestados.add(livro);
        System.out.println("Livro " + livro.getTitulo() + " emprestado para o leitor " + nome);
    }

    public void listarLivrosEmprestados() {
        System.out.println("Livros emprestados para o leitor " + nome + ":");
        for (Livro livro : livrosEmprestados) {
            System.out.println("Título do livro: " + livro.getTitulo());
        }
    }

    public void devolverLivro(Livro livro) {
        if (livrosEmprestados.contains(livro)) {
            livrosEmprestados.remove(livro);
            System.out.println("Livro " + livro.getTitulo() + " devolvido pelo leitor " + nome);
        } else {
            System.out.println("O livro não está registrado como emprestado para este leitor.");
        }
    }
}
