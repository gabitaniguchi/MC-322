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

        Evento eventoPequeno = new Evento("Clube do livro", praca, 15.0, organizadora, "10/04/2025");
        // deve lançar uma erro de ingressos esgotados
        for(int i=1; i<=110; i++){
            eventoPequeno.venderIngresso(cliente);
        }

        // 4 - Cancelamento de ingressos com tratamento de IngressoNaoEncontradoException e CancelamentoNaoPermitidoException
        Evento mfp = new Evento("Maratona Feminina de Programacao", InstitutoDeComputacao, 0, organizadora, "06/07/2025");
        // lança erro de ingresso não encontrado
        cliente.cancelarIngresso(mfp, "27/04/2025");
        // lança erro de cancelamento não permitido
        cliente.cancelarIngresso(eventoPequeno, "27/04/2025");
        
        
        // 5 - Utilização das sobrecargas dos métodos de busca

        // 6 - Utilização dos filtros da subseção 3.4

        
        // 7 - Demonstração da classe de notificação email

        Email email = new Email("g281773@dac.unicamp.br");
        SMS sms = new SMS(98889822);

        cliente.adicionarMeioDeNotificacao(email);
        cliente.adicionarMeioDeNotificacao(sms);
        cliente.todasNotificacoes("Prazo do laboratorio 02 para terca-feira");
        cliente.notificarCliente("Votacao para reitor, confira as instrucoes", email);
        cliente.notificarCliente("Seu pacote de dados venceu e precisa ser renovado", sms);
        
        // 8 - Comparação entre Clientes com os dois cenários de possuirem o ingresso para o mesmo evento
        Cliente cliente1 = new Cliente("Ana Clara");
        Cliente cliente2 = new Cliente("Ana Lucia");
        Ingresso ingressoShow = new Ingresso(eventoLotado, 300);
        Ingresso ingressoMaratona = new Ingresso(mfp, 0);

        cliente1.adicionarIngresso(ingressoShow);
        cliente2.adicionarIngresso(ingressoMaratona);

        if(cliente1.compareTo(cliente2)<0){
            System.out.println(cliente1 + " e " + cliente2 + " nao vao juntas para o evento " + mfp.getNome());
        }
        cliente1.adicionarIngresso(ingressoMaratona);

        if(cliente1.compareTo(cliente2)==0){
            System.out.println(cliente1 + " e " + cliente2 + " vao para o evento " + mfp.getNome());
        }
        
    }
}