package lab02;

import org.junit.jupiter.api.Test;

import lab02.model.CaracteristicaBar;
import lab02.model.CaracteristicaFestival;
import lab02.model.CaracteristicaJogo;
import lab02.model.CaracteristicaMusicaAoVivo;
import lab02.model.CaracteristicaShow;
import lab02.model.Cliente;
import lab02.model.Evento;
import lab02.model.Ingresso;
import lab02.model.Local;
import lab02.model.Marketplace;
import lab02.model.OfertaIngresso;
import lab02.model.Organizadora;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;


public class Lab02Test {

    /**
     * Testar o método receber oferta na classe Marketplace
     */
    @Test 
    public void verificarReceberOferta(){
        Cliente vendedor = new Cliente("Gabriela",500.0);

        Local localGameCon = new Local("Expo Center Norte – SP", 10000);
        Organizadora organizadora = new Organizadora("Unicamp Eventos", 12345, "Barão Geraldo");
        Evento evento = new Evento("GameCon Brasil 2025", localGameCon, 80.0, organizadora, "27/11/2026");
        Ingresso ingresso = new Ingresso(evento, evento.getPrecoIngresso());
        Marketplace marketplace = new Marketplace(15.0);

        vendedor.adicionarIngresso(ingresso);
        vendedor.oferecerIngressoParaVenda(ingresso, 200.0, marketplace);

        boolean ofertaExiste = marketplace.listarOfertas().stream().anyMatch(o ->
            o.getPrecoPedido() == 200.0 &&
            o.getIngresso().equals(ingresso) &&
            o.getVendedor().equals(vendedor) &&
            !o.getOficial()
        );

        assertTrue(ofertaExiste);
    }

    /**
     * Teste refrente ao método de compararClientes
     * Verifica condições em que os clientes não possuem e que possuem ingresso para o mesmo evento
     */
    @Test
    public void compararClientes(){
        Cliente cliente1 = new Cliente("Gabriela Taniguchi",0);
        Cliente cliente2 = new Cliente("Diana Andrade",0);

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
     * Teste referente ao tratamento de exceção personalizada para o caso de esgotamento de ingressos
     * Verifica se a mensagem impressa indica o tratamento de exceção utilizado para lidar com esse caso
     */
    // @Test
    // public void ingressoEsgotadosException(){

    //     Local local = new Local("Praça do Coco", 100);
    //     Organizadora organizadora = new Organizadora("SP eventos", 123456, "Barão Geraldo");
    //     Evento evento = new Evento("Corrida", local, 50.0, organizadora, "12/07/2025");
    //     Cliente cliente = new Cliente("Gabriela Taniguchi");

    //     ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    //     System.setOut(new PrintStream(outputStreamCaptor));

    //     for(int i=1; i<=101; i++) evento.venderIngresso(cliente);

    //     String expectedOutput = "Ingressos Esgotados\n";
    //     assertEquals(expectedOutput, outputStreamCaptor.toString());
    // }

   
    
}