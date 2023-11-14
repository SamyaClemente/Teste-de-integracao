import org.junit.Test;
import static org.junit.Assert.*;

public class LeitorTeste {

    @Test
    public void testEmprestimoEDevolucao() {
        Leitor leitor = new Leitor("João", "123456789");
        
        Livro livro1 = new Livro("Aventuras no Espaço");
        Livro livro2 = new Livro("História Antiga");

        leitor.realizarEmprestimo(livro1);

        assertTrue(leitor.getLivrosEmprestados().contains(livro1));

        Livro livroNaoEmprestado = new Livro("Livro Não Emprestado");
        leitor.devolverLivro(livroNaoEmprestado);

        assertTrue(leitor.getLivrosEmprestados().contains(livro1));

        leitor.devolverLivro(livro1);

        assertFalse(leitor.getLivrosEmprestados().contains(livro1));
    }
}

