package lab03;

import org.junit.jupiter.api.Test;

import lab03.model.Cliente;
import lab03.model.Evento;
import lab03.model.Ingresso;
import lab03.model.Local;
import lab03.model.Marketplace;
import lab03.model.OfertaIngresso;
import lab03.model.Organizadora;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Lab03Test {

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

    // Testar o método processarCompra na classe Marketplace, verificar a transferência do ingresso, a atualização dos saldos e o cálculo da comissão
    @Test 
    public void processarCompra(){
        Cliente vendedor = new Cliente("Gabriela",500.0);
        Cliente comprador = new Cliente("Gabriel", 300.0);

        Local localGameCon = new Local("Expo Center Norte – SP", 10000);
        Organizadora organizadora = new Organizadora("Unicamp Eventos", 12345, "Barão Geraldo");
        Evento evento = new Evento("GameCon Brasil 2025", localGameCon, 80.0, organizadora, "27/11/2026");
        Ingresso ingresso = new Ingresso(evento, evento.getPrecoIngresso());
        Marketplace marketplace = new Marketplace(15.0);

        vendedor.adicionarIngresso(ingresso);
        vendedor.oferecerIngressoParaVenda(ingresso, 100.0, marketplace);

        OfertaIngresso oferta = marketplace.listarOfertas().getFirst();
        comprador.comprarIngressoNoMarketplace(oferta, marketplace);

        // verifica se o comprador possui o ingresso, e se o ingresso sai da lista do vendedor e de ofertas do marketplace
        assertTrue(comprador.getIngressos().contains(ingresso));
        assertFalse(vendedor.getIngressos().contains(ingresso));
        assertFalse(marketplace.listarOfertas().contains(oferta));

        // verifica a comissão e os saldos dos clientes
        assertEquals(200.0, comprador.getSaldo());
        assertEquals(585.0, vendedor.getSaldo());
        assertEquals(15.0, marketplace.getLucro());
    }

    // Testar a exceção IngressoNaoPertenceAoClienteException
    @Test 
    public void ingressoNaoPertenceAoClienteException(){

        Cliente vendedor = new Cliente("Gabriela",500.0);

        Local localGameCon = new Local("Expo Center Norte – SP", 10000);
        Organizadora organizadora = new Organizadora("Unicamp Eventos", 12345, "Barão Geraldo");
        Evento evento = new Evento("GameCon Brasil 2025", localGameCon, 80.0, organizadora, "27/11/2026");
        Ingresso ingresso = new Ingresso(evento, evento.getPrecoIngresso());
        Marketplace marketplace = new Marketplace(15.0);

        
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        
        vendedor.oferecerIngressoParaVenda(ingresso, 100.0, marketplace);

        String expectedOutput = "Ingresso não pertence ao cliente\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    // Testar a exceção OfertaNaoEncontradaException
    @Test 
    public void iofertaNaoEncontradaException(){

        Cliente vendedor = new Cliente("Gabriela",500.0);
        Cliente comprador = new Cliente("Renata", 300.0);

        Local localGameCon = new Local("Expo Center Norte – SP", 10000);
        Organizadora organizadora = new Organizadora("Unicamp Eventos", 12345, "Barão Geraldo");
        Evento evento = new Evento("GameCon Brasil 2025", localGameCon, 80.0, organizadora, "27/11/2026");
        Ingresso ingresso = new Ingresso(evento, evento.getPrecoIngresso());
        Marketplace marketplace = new Marketplace(15.0);
        OfertaIngresso oferta = new OfertaIngresso(ingresso, 100.0, vendedor, false);
        
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        vendedor.adicionarIngresso(ingresso);
        comprador.comprarIngressoNoMarketplace(oferta, marketplace);

        String expectedOutput = "Oferta nao encontrada\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }


    // Testar a exceção SaldoInsuficienteException
    @Test 
    public void saldoInsuficienteException(){

        Cliente vendedor = new Cliente("Gabriela",500.0);
        Cliente comprador = new Cliente("Renata", 300.0);

        Local localGameCon = new Local("Expo Center Norte – SP", 10000);
        Organizadora organizadora = new Organizadora("Unicamp Eventos", 12345, "Barão Geraldo");
        Evento evento = new Evento("GameCon Brasil 2025", localGameCon, 80.0, organizadora, "27/11/2026");
        Ingresso ingresso = new Ingresso(evento, evento.getPrecoIngresso());
        Marketplace marketplace = new Marketplace(15.0);
        
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        vendedor.adicionarIngresso(ingresso);
        vendedor.oferecerIngressoParaVenda(ingresso, 500.0, marketplace);
        OfertaIngresso oferta = marketplace.listarOfertas().getFirst();
        comprador.comprarIngressoNoMarketplace(oferta, marketplace);

        String expectedOutput = "Saldo insuficiente\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

   
}