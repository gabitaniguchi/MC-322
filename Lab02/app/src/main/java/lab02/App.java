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

        // ETAPA 0 - Demonstração da composição
        
        // Visto que fui realizada uma reestruturação da hierarquia de classes, agora com composição, não há mais razões para utilizar a sobrecarga de criarEvento
        // Sendo assim, a demonstração desse passo será substituída pela demonstração da composição, justificada e detalhada no pdf enviado na submissão do lab
        // Agora, cada evento é instanciado como um objeto da classe Evento, e suas particularidades são modeladas por meio de objetos de CaracteristicaDeEvento.
        // Dessa forma, cada Evento possui uma ou mais características associadas a ele, seguindo a proposta da composição de "ter uma característica"
        System.out.println("ETAPA 0 - Demonstração da Composição:");
        Local localFestival = new Local("Autodromo de Interlagos", 300000);
        Organizadora organizadora = new Organizadora("Time For Fun (T4F)", 12345, "Faria Lima");
        Evento eventoFestival = new Evento("Lollapalooza Brasil 2025", localFestival, 200.0, organizadora,"27/04/2025");
        organizadora.adicionarEvento(eventoFestival);
        CaracteristicaFestival caracteristicaFestival = new CaracteristicaFestival(List.of("Coldplay", "Justin Timberlake", "Sepultura", "Olivia Rodrigo"), "3 dias");
        eventoFestival.adicionarCaracteristica(caracteristicaFestival);
        eventoFestival.descricao();
        System.out.println();

        Local localBar = new Local("Barão Geraldo, nº 33", 100);
        Evento eventoEmBar = new Evento("Noite de Samba ao Vivo", localBar, 50.0, organizadora, "20/08/2025");
        organizadora.adicionarEvento(eventoEmBar);
        CaracteristicaBar caracteristicaBar = new CaracteristicaBar("Boteco do João", "20:00 h", "4 horas");
        CaracteristicaMusicaAoVivo caracteristicaMusicaAoVivoEmBar = new CaracteristicaMusicaAoVivo("Clara Nunes", "Samba");
        eventoEmBar.adicionarCaracteristica(caracteristicaBar);
        eventoEmBar.adicionarCaracteristica(caracteristicaMusicaAoVivoEmBar);
        eventoEmBar.descricao();
        System.out.println();

        Local localJogo = new Local("Estádio do Maracanã", 78000);
        Evento eventoJogo = new Evento("Final da Copa do Brasil", localJogo, 250.0, organizadora, "30/09/2025");
        organizadora.adicionarEvento(eventoJogo);
        CaracteristicaJogo caracteristicaJogo = new CaracteristicaJogo(List.of("Brasil", "Alemanha"));
        eventoJogo.adicionarCaracteristica(caracteristicaJogo);
        eventoJogo.descricao();
        System.out.println();
        
        Local localShow = new Local("Allianz Parque", 45000);
        Evento eventoShow = new Evento("Show Coldplay Live in São Paulo", localShow, 400.0, organizadora, "15/11/2025");
        organizadora.adicionarEvento(eventoShow);
        CaracteristicaShow caracteristicaShow = new CaracteristicaShow("Coldplay");
        CaracteristicaMusicaAoVivo caracteristicaMusicaAoVivo = new CaracteristicaMusicaAoVivo("Coldplay", "Rock");
        eventoShow.adicionarCaracteristica(caracteristicaShow);
        eventoShow.adicionarCaracteristica(caracteristicaMusicaAoVivo);
        eventoShow.descricao();
        System.out.println();

        
        // ETAPA 1 - Criação de objetos utilizando as sobrecargas
        // Sobrecarga do método Adicionar Ingresso
        Evento evento = new Evento("Show Menos é mais", localShow, 400.0, organizadora, "30/10/2025");
        organizadora.adicionarEvento(evento);
        Ingresso ingresso = new Ingresso(evento, 200.0);
        List<Ingresso> ingressos = new ArrayList<Ingresso>() {{
            add(new Ingresso(evento, 200.0));
            add(new Ingresso(evento, 200.0));
            add(new Ingresso(evento, 200.0));
            add(new Ingresso(evento, 200.0));
        }};

        Cliente cliente = new Cliente("Joao Pedro Silva");
        cliente.adicionarIngresso(ingresso);
        evento.venderIngresso(cliente);
        cliente.adicionarIngresso(ingressos);
        for(int i=1; i<=ingressos.size(); i++){
            evento.venderIngresso(cliente);
        }

        // Imprime todos os ingressos do cliente
        List<Ingresso> todosOsIngressos = cliente.getIngressos();
        System.out.println("ETAPA 1\nSobrecarga de Adicionar Ingresso: ");
        for(Ingresso umIngresso: todosOsIngressos){
            System.out.println(" Ingresso : " + umIngresso);
        }
        System.out.println();

        // Sobrecarga do método Buscar Local
        // O passo 3.8.5 do arquivo de instuções corresponde à essa demonstração, juntamente com as demais sobrecargas
        ImobiliariaDeEventos imobiliaria = new ImobiliariaDeEventos("Rio Eventos");
        imobiliaria.adicionarLocal(localFestival);

        System.out.println("Sobrecarga de Buscar Local:");
        System.out.println("0 local buscado é: " + imobiliaria.buscarLocal(300000).getNome());
        System.out.println("0 local buscado é: " + imobiliaria.buscarLocal("Autodromo de Interlagos").getNome() + "\n");


        // 2 - Alocação de locais com tratamento de LocalIndisponivelException e CapacidadeInsuficienteException
        
        System.out.println("ETAPA 2 - Exceções para alocar local");
        
        Evento eventoLotado = new Evento("Show Lady Gaga", localFestival, 300.0, organizadora, "10/05/2025");
        organizadora.adicionarEvento(eventoLotado);

        for(int i=1; i<=200; i++){
            Ingresso ingressoShow = new Ingresso(eventoLotado, 300.0);
            eventoLotado.venderIngresso(cliente);
            cliente.adicionarIngresso(ingressoShow);
        }

        Local localPraca = new Local("Praca do Coco", 100);
        Local localIC = new Local("Instituto de Computação", 2000);
        localIC.setDisponibilidade(false);

        // lança um erro de local indisponível
        localIC.alocarParaEvento(eventoLotado);
        // lança um erro de capacidade insuficiente
        localPraca.alocarParaEvento(eventoLotado);
        System.out.println();


        // 3 - Venda de ingressos com tratamento de IngressoEsgotadoException

        System.out.println("ETAPA 3 - Exceções para vender ingresso");

        Organizadora organizadora2 = new Organizadora("Campinas Eventos", 10102, "Barão Geraldo, Avenida Doutor Romeu Tortima");

        Evento eventoPequeno = new Evento("Clube do livro", localPraca, 15.0, organizadora2, "27/04/2025");
        organizadora2.adicionarEvento(eventoPequeno);
        
        // lança uma erro de ingressos esgotados
        for(int i=1; i<=101; i++){
            eventoPequeno.venderIngresso(cliente);
        }
        cliente.adicionarIngresso(eventoPequeno.getIngressosVendidos());
        System.out.println();

        // // 4 - Cancelamento de ingressos com tratamento de IngressoNaoEncontradoException e CancelamentoNaoPermitidoException
        System.out.println("ETAPA 4 - Exceções para cancelar ingresso");
        Evento eventoMFP = new Evento("Maratona Feminina de Programação", localIC, 0, organizadora2, "06/07/2025");
        organizadora2.adicionarEvento(eventoMFP);
        // lança erro de ingresso não encontrado
        cliente.cancelarIngresso(eventoMFP, "27/04/2025");
        // lança erro de cancelamento não permitido
        cliente.cancelarIngresso(eventoPequeno, "30/04/2025");
        System.out.println();

        // 5 - Utilização da sobrecarga dos métodos de busca - já aplicado na etapa 1

        // 6 - Utilização dos filtros da subseção 3.4

        Evento eventoProva = new Evento("Prova de MC322", localIC, 0, organizadora2, "29/05/2025");
        organizadora2.adicionarEvento(eventoProva);
        Evento eventoAvaliacaoCurso = new Evento("Avaliação de Curso 1º semestre 2025", localIC, 0, organizadora2, "10/06/2025");
        organizadora2.adicionarEvento(eventoAvaliacaoCurso);

        System.out.println("ETAPA 6 - Demonstração dos filtros de evento");
        
        // Filtro por Data
        System.out.println("FILTRO POR DATA:");
        System.out.println("Eventos com data: 27/04/2025");
        List<Evento> eventosData1 = organizadora.buscarEventos(new EventoPorDataFilter("27/04/2025"));
        List<Evento> eventosData2 = organizadora2.buscarEventos(new EventoPorDataFilter("27/04/2025"));

        System.out.println(" Organizadora 1: ");
        for(Evento eventoFiltro : eventosData1){
            System.out.println(" - " + eventoFiltro.getNome() + " ");
        }
        System.out.println("\n Organizadora 2:");
        for(Evento eventoFiltro : eventosData2){
            System.out.println(" - " + eventoFiltro.getNome() + " ");
        }
        System.out.println();

        // Filtro por Local
        System.out.println("FILTRO POR LOCAL:");
        System.out.println("Eventos com local: Autodromo de Interlagos");
        List<Evento> eventosLocal1 = organizadora.buscarEventos(new EventoPorLocalFilter(localFestival));
        List<Evento> eventosLocal2 = organizadora2.buscarEventos(new EventoPorLocalFilter(localFestival));

        System.out.println(" Organizadora 1: ");
        for(Evento eventoFiltro : eventosLocal1){
            System.out.println(" - " + eventoFiltro.getNome() + " ");
        }
        System.out.println(" \n Organizadora 2:");
        for(Evento eventoFiltro : eventosLocal2){
            System.out.println(" - " + eventoFiltro.getNome() + " ");
        }
        System.out.println();

        System.out.println("Eventos com local: Instituto de Computação");
        List<Evento> eventosLocal3 = organizadora.buscarEventos(new EventoPorLocalFilter(localIC));
        List<Evento> eventosLocal4 = organizadora2.buscarEventos(new EventoPorLocalFilter(localIC));

        System.out.println(" Organizadora 1: ");
        for(Evento eventoFiltro : eventosLocal3){
            System.out.println(" - " + eventoFiltro.getNome() + " ");
        }
        System.out.println(" \n Organizadora 2:");
        for(Evento eventoFiltro : eventosLocal4){
            System.out.println(" - " + eventoFiltro.getNome() + " ");
        }
        System.out.println();

        // Filtro por Nome
        System.out.println("FILTRO POR NOME:");
        System.out.println("Eventos com nome: Maratona Feminina de Programação");
        List<Evento> eventosNome1 = organizadora.buscarEventos(new EventoPorNomeFilter("Maratona Feminina de Programação"));
        List<Evento> eventosNome2 = organizadora2.buscarEventos(new EventoPorNomeFilter("Maratona Feminina de Programação"));

        System.out.print(" Organizadora 1: ");
        for(Evento eventoFiltro : eventosNome1){
            System.out.println(" - " + eventoFiltro.getNome());
        }
        System.out.println(" \n Organizadora 2:");
        for(Evento eventoFiltro : eventosNome2){
            System.out.println(" - " + eventoFiltro.getNome() + " ");
        }
        System.out.println();
    
        // Filtro por Organizadora
        System.out.println("FILTRO POR ORGANIZADORA:");
        List<Evento> eventosOrganizadora1 = organizadora.buscarEventos(new EventoPorOrganizadorFilter(organizadora));
        List<Evento> eventosOrganizadora2 = organizadora2.buscarEventos(new EventoPorOrganizadorFilter(organizadora2));

        System.out.println(" Organizadora 1: ");
        for(Evento eventoFiltro : eventosOrganizadora1){
            System.out.println(" - " + eventoFiltro.getNome());
        }
        System.out.println("\n Organizadora 2:");
        for(Evento eventoFiltro : eventosOrganizadora2){
            System.out.println(" - " +eventoFiltro.getNome() + " ");
        }
        System.out.println("\n");

        // Junção dos filtros por Data e por Organizadora
        System.out.println("FILTRO POR DATA E POR ORGANIZADORA:");
        System.out.println("Eventos com data 27/04/2025 e Organizadora 1:");

        List<Evento> eventosDataAndOrganizadora1 = organizadora.buscarEventos(new AndFilter(new EventoPorOrganizadorFilter(organizadora), new EventoPorDataFilter("27/04/2025")));
        List<Evento> eventosDataAndOrganizadora2 = organizadora2.buscarEventos(new AndFilter(new EventoPorOrganizadorFilter(organizadora), new EventoPorDataFilter("27/04/2025")));

        System.out.println(" Organizadora 1: ");
        for(Evento eventoFiltro : eventosDataAndOrganizadora1){
            System.out.println(" - " + eventoFiltro.getNome());
        }
        System.out.println("\n Organizadora 2:");
        for(Evento eventoFiltro : eventosDataAndOrganizadora2){
            System.out.println(" - " +eventoFiltro.getNome() + " ");
        }
        System.out.println("\n");

        
        // 7 - Demonstração da classe de notificação email

        System.out.println("ETAPA 7 - Demonstração da classe de notificação");

        Email email = new Email("g281773@dac.unicamp.br");
        SMS sms = new SMS(98889822);

        cliente.adicionarMeioDeNotificacao(email);
        cliente.adicionarMeioDeNotificacao(sms);
        cliente.todasNotificacoes("Prazo do laboratório 02 para terça-feira");
        cliente.notificarCliente("Votação para reitor, confira as instruçõs", email);
        cliente.notificarCliente("Seu pacote de dados venceu e precisa ser renovado", sms);
        System.out.println();
        
        // 8 - Comparação entre Clientes com os dois cenários de possuirem o ingresso para o mesmo evento
        System.out.println("ETAPA 8 - Comparar dois clientes");
        Cliente cliente1 = new Cliente("Ana Clara");
        Cliente cliente2 = new Cliente("Ana Lucia");
        Ingresso ingressoShow = new Ingresso(eventoLotado, 300);
        Ingresso ingressoMaratona = new Ingresso(eventoMFP, 0);

        cliente1.adicionarIngresso(ingressoShow);
        cliente2.adicionarIngresso(ingressoMaratona);

        if(cliente1.compareTo(cliente2)<0){
            System.out.println(cliente1.getNome() + " e " + cliente2.getNome() + " não vão juntas para o evento " + eventoMFP.getNome());
        }
        cliente1.adicionarIngresso(ingressoMaratona);

        if(cliente1.compareTo(cliente2)==0){
            System.out.println(cliente1.getNome() + " e " + cliente2.getNome() + " vão para o evento " + eventoMFP.getNome());
        }
        System.out.println();
        
    }
}