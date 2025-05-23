package lab02.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lab02.model.Cliente;
import lab02.model.Evento;
import lab02.model.Ingresso;

public class ClienteRepository {

    private static ObservableList<Cliente> clientes = FXCollections.observableArrayList();

    public static ObservableList<Cliente> definirClientes(){
        ObservableList<Evento> eventos = EventoRepository.definirEventos();

        Cliente cliente1 = new Cliente("Maria", 500.0);
        Cliente cliente2 = new Cliente("Pedro Lucas Costa", 200.0);
        
        Ingresso ingresso1 = new Ingresso(eventos.get(1),eventos.get(1).getPrecoIngresso());
        Ingresso ingresso2 = new Ingresso(eventos.get(2), eventos.get(2).getPrecoIngresso());
        Ingresso ingresso3 = new Ingresso(eventos.get(3), eventos.get(3).getPrecoIngresso());
        Ingresso ingresso4 = new Ingresso(eventos.get(4), eventos.get(4).getPrecoIngresso());
        
        cliente1.adicionarIngresso(ingresso1);
        cliente1.adicionarIngresso(ingresso2);
        cliente1.adicionarIngresso(ingresso3);
        cliente2.adicionarIngresso(ingresso4);

        clientes.add(cliente1);
        clientes.add(cliente2);

        return clientes;
    }

    public static class ClienteNaoEncontradoException extends Exception{
        public ClienteNaoEncontradoException(String mensagem) {
            super(mensagem);
        }
    }


    public static Cliente buscarCliente(String usuario) throws ClienteNaoEncontradoException{
       
        for(Cliente cliente: clientes){
            if(cliente.getNome().equalsIgnoreCase(usuario)){
                return cliente;
            }
        }

        throw new ClienteNaoEncontradoException("Cliente não encontrado");
    }

}
