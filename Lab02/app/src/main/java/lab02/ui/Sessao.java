package lab02.ui;

import lab02.model.Cliente;

public class Sessao {

    private static Cliente clienteLogado;

    public static void setClienteLogado(Cliente cliente) {
        clienteLogado = cliente;
    }

    public static Cliente getClienteLogado() {
        return clienteLogado;
    }

    public static void limpar() {
        clienteLogado = null;
    }
    
}
