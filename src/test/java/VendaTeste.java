import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

public class VendaTeste {

    private Venda venda;
    private Leitor leitor;
    private Livro livro;

    @Before
    public void setup() {
        venda = new Venda("Atendente Teste", "12345");
        leitor = new Leitor("Nome Leitor", "123", 100.0);
        livro = new Livro("Livro Teste", "Autor Teste", 20.0, 10);
    }

    @Test
    public void testRealizarVendaComSucesso() {
        venda.realizarVenda(leitor, livro, 2);
        assertEquals(8, livro.getQuantidadeEstoque());
        assertEquals(60.0, leitor.getSaldoTotal(), 0.01);
    }

    @Test
    public void testRealizarVendaQuantidadeInsuficiente() {
        venda.realizarVenda(leitor, livro, 15);
        assertEquals(10, livro.getQuantidadeEstoque());
        assertEquals(100.0, leitor.getSaldoTotal(), 0.01);
    }

    @Test
    public void testProcessarDevolucaoComSucesso() {
        leitor.debitarSaldo(50.0); // Reduz o saldo para 50.0
        livro.realizarVenda(5); // Vende 5 unidades do livro
        venda.processarDevolucao(leitor, livro, 3);
        assertEquals(7, livro.getQuantidadeEstoque());
        assertEquals(90.0, leitor.getSaldoTotal(), 0.01);
    }

    @Test
    public void testProcessarDevolucaoQuantidadeInsuficiente() {
        venda.processarDevolucao(leitor, livro, 15);
        assertEquals(10, livro.getQuantidadeEstoque());
        assertEquals(100.0, leitor.getSaldoTotal(), 0.01);
    }
}
