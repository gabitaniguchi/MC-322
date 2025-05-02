package lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;


public class Lab02Test {

    /**
     * Teste referente à interface Notificável
     * Verifica se as notificações, ou mensagens impressas correspondem ao esperado
     * O uso do sistema para captar as saídas geradas foi feito com o auxílio de IA
     */
    @Test 
    public void verificarNotificavel(){
        Cliente cliente = new Cliente("Gabriela Taniguchi");
        Email email = new Email("g281773@dac.unicamp.br");
        SMS sms = new SMS(99887766);
        cliente.adicionarMeioDeNotificacao(email);
        cliente.adicionarMeioDeNotificacao(sms);

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Chama o método que gera a notificação
        cliente.todasNotificacoes("Prazo do laboratório 02 para terça-feira");

        // Verifica se a saída contém a mensagem esperada
        String expectedOutput = "Novo email para g281773@dac.unicamp.br na caixa de entrada : Prazo do laboratório 02 para terça-feira\n" +
                                "Novo mensagem para 99887766 : Prazo do laboratório 02 para terça-feira\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    /**
     * Teste refrente ao método de compararClientes
     * Verifica condições em que os clientes não possuem e que possuem ingresso para o mesmo evento
     */
    @Test
    public void compararClientes(){
        Cliente cliente1 = new Cliente("Gabriela Taniguchi");
        Cliente cliente2 = new Cliente("Diana Andrade");

        Local local = new Local("Campinas Hall", 5000);
        Organizadora organizadora = new Organizadora("SP eventos", 123456, "Barão Geraldo");
        Evento evento = new Evento("Show Capital Inicial", local, 350.0, organizadora, "12/07/2025");
        Ingresso ingresso = new Ingresso(evento, 350.0);

        cliente1.adicionarIngresso(ingresso);
        assertEquals(-1, cliente1.compareTo(cliente2));
        cliente2.adicionarIngresso(ingresso);
        assertEquals(0, cliente1.compareTo(cliente2));
    }

    /**
     * Teste referente ao Evento Bar e ao Evento Música Ao Vivo
     * Devido à mudança para composição, os eventos passam a possuir características de um evento em bar e de um evento com música ao vivo
     * Verifica se os atributos correspondem aos valores esperados
     */
    @Test
    public void eventoBarEMusicaAoVivo(){
        Organizadora organizadora = new Organizadora("Comida de buteco Campinas", 123456, "Barão Geraldo, Avenida Santa Isabel");
        Local localBar = new Local("Barão Geraldo, nº 33", 100);
        Evento eventoEmBar = new Evento("Noite de Samba ao Vivo", localBar, 50.0, organizadora, "20/08/2025");
        organizadora.adicionarEvento(eventoEmBar);
        CaracteristicaBar caracteristicaBar = new CaracteristicaBar("Boteco do João", "20:00 h", "4 horas");
        CaracteristicaMusicaAoVivo caracteristicaMusicaAoVivoEmBar = new CaracteristicaMusicaAoVivo("Clara Nunes", "Samba");
        eventoEmBar.adicionarCaracteristica(caracteristicaBar);
        eventoEmBar.adicionarCaracteristica(caracteristicaMusicaAoVivoEmBar);
        

        assertEquals("Boteco do João", ((CaracteristicaBar)eventoEmBar.getCaracteristica(caracteristicaBar)).getNomeDoBar());
        assertEquals("20:00 h", ((CaracteristicaBar) eventoEmBar.getCaracteristica(caracteristicaBar)).getInicioHappyHour());
        assertEquals("4 horas", ((CaracteristicaBar) eventoEmBar.getCaracteristica(caracteristicaBar)).getDuracaoHappyHour());
        
        assertEquals("Clara Nunes", ((CaracteristicaMusicaAoVivo) eventoEmBar.getCaracteristica(caracteristicaMusicaAoVivoEmBar)).getNomeDoArtista());
        assertEquals("Samba", ((CaracteristicaMusicaAoVivo) eventoEmBar.getCaracteristica(caracteristicaMusicaAoVivoEmBar)).getGeneroMusical());

        Evento eventoMusicaAoVivo = new Evento("Noite de Pagode", localBar, 15.0, organizadora, "30/04/2025");
        CaracteristicaMusicaAoVivo caracteristicaMusicaAoVivo = new CaracteristicaMusicaAoVivo("Menos é Mais", "Pagode");
        eventoMusicaAoVivo.adicionarCaracteristica(caracteristicaMusicaAoVivo);


        assertEquals("Menos é Mais", ((CaracteristicaMusicaAoVivo) eventoMusicaAoVivo.getCaracteristica(caracteristicaMusicaAoVivo)).getNomeDoArtista());
        assertEquals("Pagode", ((CaracteristicaMusicaAoVivo) eventoMusicaAoVivo.getCaracteristica(caracteristicaMusicaAoVivo)).getGeneroMusical());
    }

    /**
     * Teste referente à nova forma de criar um Evento Festival, agora com Características Festival
     * Verifica se os atributos correspondem aos valores esperados
     */
    @Test
    public void hierarquiaEventoFestival(){

        Local localFestival = new Local("Autodromo de Interlagos", 300000);
        Organizadora organizadora = new Organizadora("Time For Fun (T4F)", 12345, "Faria Lima");
        Evento eventoFestival = new Evento("Lollapalooza Brasil 2025", localFestival, 200.0, organizadora,"27/04/2025");
        organizadora.adicionarEvento(eventoFestival);
        CaracteristicaFestival caracteristicaFestival = new CaracteristicaFestival(List.of("Coldplay", "Justin Timberlake", "Sepultura", "Olivia Rodrigo"), "3 dias");
        eventoFestival.adicionarCaracteristica(caracteristicaFestival);

        assertEquals("3 dias", ((CaracteristicaFestival)eventoFestival.getCaracteristica(caracteristicaFestival)).getDuracao());
        assertEquals(List.of("Coldplay", "Justin Timberlake", "Sepultura", "Olivia Rodrigo"), ((CaracteristicaFestival) eventoFestival.getCaracteristica(caracteristicaFestival)).getLineup());
    }

    /**
     * Teste referente à nova forma de criar um Evento Show, agora com Características Show
     * Verifica se os atributos correspondem aos valores esperados
     */
    @Test
    public void hierarquiaEventoShow(){

        Local localShow = new Local("Allianz Parque", 45000);
        Organizadora organizadora = new Organizadora("Time For Fun (T4F)", 12345, "Faria Lima");
        Evento eventoShow = new Evento("Show Coldplay Live in São Paulo", localShow, 400.0, organizadora, "15/11/2025");
        organizadora.adicionarEvento(eventoShow);
        CaracteristicaShow caracteristicaShow = new CaracteristicaShow("Coldplay");
        CaracteristicaMusicaAoVivo caracteristicaMusicaAoVivo = new CaracteristicaMusicaAoVivo("Coldplay", "Rock");
        eventoShow.adicionarCaracteristica(caracteristicaShow);
        eventoShow.adicionarCaracteristica(caracteristicaMusicaAoVivo);

        assertEquals("Coldplay", ((CaracteristicaShow)eventoShow.getCaracteristica(caracteristicaShow)).getArtista());
    }

    /**
     * Teste referente à nova forma de criar um Evento Jogo, agora com Características Jogo
     * Verifica se os atributos correspondem aos valores esperados
     */
    @Test 
    public void hierarquiaEventoJogo(){

        Local localJogo = new Local("Estádio do Maracanã", 78000);
        Organizadora organizadora = new Organizadora("Time For Fun (T4F)", 12345, "Faria Lima");
        Evento eventoJogo = new Evento("Final da Copa do Brasil", localJogo, 250.0, organizadora, "30/09/2025");
        organizadora.adicionarEvento(eventoJogo);
        CaracteristicaJogo caracteristicaJogo = new CaracteristicaJogo(List.of("Brasil", "Alemanha"));
        eventoJogo.adicionarCaracteristica(caracteristicaJogo);

        assertEquals(List.of("Brasil", "Alemanha"), ((CaracteristicaJogo)eventoJogo.getCaracteristica(caracteristicaJogo)).getTimes());
    }


    /**
     * Teste referente ao tratamento de exceção personalizada para o caso de esgotamento de ingressos
     * Verifica se a mensagem impressa indica o tratamento de exceção utilizado para lidar com esse caso
     */
    @Test
    public void ingressoEsgotadosException(){

        Local local = new Local("Praça do Coco", 100);
        Organizadora organizadora = new Organizadora("SP eventos", 123456, "Barão Geraldo");
        Evento evento = new Evento("Corrida", local, 50.0, organizadora, "12/07/2025");
        Cliente cliente = new Cliente("Gabriela Taniguchi");

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        for(int i=1; i<=101; i++) evento.venderIngresso(cliente);

        String expectedOutput = "Ingressos Esgotados\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    /**
     * Teste referente ao tratamento de exceção personalizada para o caso de cancelamento de ingresso não permitido
     * Verifica se a mensagem impressa indica o tratamento de exceção utilizado para lidar com esse caso
     */
    @Test 
    public void cancelamentoNaoPermitidoException(){
        Local local = new Local("República Vira Copos", 500);
        Organizadora organizadora = new Organizadora("SP eventos", 123456, "Barão Geraldo");
        Evento evento = new Evento("Churras a Trois", local, 50.0, organizadora, "30/03/2025");
        Cliente cliente = new Cliente("Gabriela Taniguchi");
        Ingresso ingresso = new Ingresso(evento,50.0);
        cliente.adicionarIngresso(ingresso);

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        cliente.cancelarIngresso(evento, "28/04/2025");

        String expectedOutput = "Não é possível cancelar um evento passado\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
    
}