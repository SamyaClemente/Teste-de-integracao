public class TesteLivraria {

    public static void main(String[] args) {
        // 1. Criação de Livraria
        Livraria minhaLivraria = new Livraria("Livraria Central");
        assert minhaLivraria.getNome().equals("Livraria Central") : "Nome da livraria incorreto";

        // 2. Adição de Clientes
        Cliente cliente1 = new Cliente("Alice");
        Cliente cliente2 = new Cliente("Bob");
        Cliente cliente3 = new Cliente("Carlos");

        minhaLivraria.adicionarCliente(cliente1);
        minhaLivraria.adicionarCliente(cliente2);
        minhaLivraria.adicionarCliente(cliente3);

        assert minhaLivraria.getClientes().contains(cliente1) : "Cliente1 não adicionado corretamente";
        assert minhaLivraria.getClientes().contains(cliente2) : "Cliente2 não adicionado corretamente";
        assert minhaLivraria.getClientes().contains(cliente3) : "Cliente3 não adicionado corretamente";

        // 3. Listagem de Clientes
        minhaLivraria.listarClientes();

        // 4. Remoção de Cliente
        minhaLivraria.removerCliente(cliente2);
        assert !minhaLivraria.getClientes().contains(cliente2) : "Cliente2 não removido corretamente";

        Cliente clienteNaoExistente = new Cliente("David");
        minhaLivraria.removerCliente(clienteNaoExistente); // Mensagem esperada: O cliente não pertence a esta livraria.
    }
}
