/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a estrutura de implementação da aplicação.
 * 
 * @author Gabriela Taniguchi - 281773
 */
public class App {

    /**
     * Aplicação principal
     * @param args
     */
    public static void main(String[] args) {

        // Desenvolvimento de Cenário de Uso
        // 1 - Criação de objetos utilizando as sobrecargas

        // Sobrecarga do método Adicionar Ingresso
        Local local = new Local("Autodromo de Interlagos", 300000);
        Organizadora organizadora = new Organizadora("Time For Fun (T4F)", 12345, "Faria Lima");
        Evento evento = new Evento("Lollapalooza Brasil 2025", local, 200.0, organizadora,"24/03/2025");
        Ingresso ingresso = new Ingresso(evento, 200.0);
        List<Ingresso> ingressos = new ArrayList<Ingresso>() {{
            add(new Ingresso(evento, 200.0));
            add(new Ingresso(evento, 200.0));
            add(new Ingresso(evento, 200.0));
            add(new Ingresso(evento, 200.0));
        }};

        Cliente cliente = new Cliente("Joao Pedro Silva");
        cliente.adicionarIngresso(ingresso);
        cliente.adicionarIngresso(ingressos);

        // Imprime todos os ingressos do cliente
        List<Ingresso> todosOsIngressos = cliente.getIngressos();
        System.out.println("Sobrecarga de Adicionar Ingresso: ");
        for(Ingresso umIngresso: todosOsIngressos){
            System.out.print(umIngresso + " ");
        }
        System.out.println();

        // Sobrecarga do método Buscar Local
        ImobiliariaDeEventos imobiliaria = new ImobiliariaDeEventos("Rio Eventos");
        imobiliaria.adicionarLocal(local);

        System.out.println("Sobrecarga de Buscar Local:");
        System.out.println(imobiliaria.buscarLocal(300000));
        System.out.println(imobiliaria.buscarLocal("Autodromo de Interlagos"));


        // 2 - Alocação de locais com tratamento de LocalIndisponivelException e CapacidadeInsuficienteException
        
        Evento eventoLotado = new Evento("Show Lady Gaga", local, 300.0, organizadora, "10/05/2025");

        for(int i=1; i<=200; i++){
            eventoLotado.venderIngresso(cliente);
        }

        Local praca = new Local("Praca do Coco", 100);
        Local InstitutoDeComputacao = new Local("IC", 2000);
        InstitutoDeComputacao.setDisponibilidade(false);
        // deve lançar um erro de local indisponível
        InstitutoDeComputacao.alocarParaEvento(eventoLotado);
        // deve lançar um erro de capacidade insuficiente
        praca.alocarParaEvento(eventoLotado);

        // 3 - Venda de ingressos com tratamento de IngressoEsgotadoException

        
        // 4 - Cancelamento de ingressos com tratamento de IngressoNaoEncontradoException e CancelamentoNaoPermitidoException
        // 5 - Utilização das sobrecargas dos métodos de busca
        // 6 - Utilização dos filtros da subseção 3.4
        // 7 - Demonstração da classe de notificação email
        // 8 - Comparação entre Clientes com os dois cenários de possuirem o ingresso para o mesmo evento
        
    }
}
