package lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Lab02Test {

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