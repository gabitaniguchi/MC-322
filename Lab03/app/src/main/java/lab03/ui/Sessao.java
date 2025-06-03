package lab03.ui;

import lab03.model.Cliente;

public class Sessao {

    // Armazena o cliente que está atualmente logado no sistema
    private static Cliente clienteLogado;

    // Define qual cliente está logado na sessão atual
    public static void setClienteLogado(Cliente cliente) {
        clienteLogado = cliente;
    }

    // Retorna o cliente que está logado na sessão
    public static Cliente getClienteLogado() {
        return clienteLogado;
    }

    // Limpa a sessão, removendo o cliente logado (logout)
    public static void limpar() {
        clienteLogado = null;
    }
    
}
