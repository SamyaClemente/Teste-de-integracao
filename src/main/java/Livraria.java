import java.util.ArrayList;
import java.util.List;

public class Livraria {
    private String nome;
    private List<Cliente> clientes;

    public Livraria(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado à livraria " + nome);
    }

    public void listarClientes() {
        System.out.println("Clientes da livraria " + nome + ":");
        for (Cliente cliente : clientes) {
            System.out.println("Nome do cliente: " + cliente.getNome());
        }
    }

    public void removerCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
            System.out.println("Cliente " + cliente.getNome() + " removido da livraria " + nome);
        } else {
            System.out.println("O cliente não pertence a esta livraria.");
        }
    }
}
