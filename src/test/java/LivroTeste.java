import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LivroTeste {

    @Test
    public void testeRealizarVendaComEstoqueSuficiente() {
        Livro livroMock = Mockito.mock(Livro.class);

        Mockito.when(livroMock.getQuantidadeEstoque()).thenReturn(10);
        Mockito.when(livroMock.getTitulo()).thenReturn("Quantidade");

        livroMock.realizarVenda(3);

        Mockito.verify(livroMock).realizarVenda(3);

        assertEquals(7, livroMock.getQuantidadeEstoque());
    }

    @Test
    public void testeRealizarVendaComEstoqueInsuficiente() {
        Livro livroMock = Mockito.mock(Livro.class);

        Mockito.when(livroMock.getQuantidadeEstoque()).thenReturn(2); 
        Mockito.when(livroMock.getTitulo()).thenReturn("Qauntidade");
        livroMock.realizarVenda(5);

        Mockito.verify(livroMock, Mockito.never()).realizarVenda(Mockito.anyInt());

        assertEquals(2, livroMock.getQuantidadeEstoque());
    }
}
