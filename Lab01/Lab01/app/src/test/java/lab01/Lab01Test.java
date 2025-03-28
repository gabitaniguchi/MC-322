package lab01;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Lab01Test {

    /**
     * Testa se o getCapacidadeEvento retorna a capacidade do local do Evento
     * Modificações nos parâmentro do EventoShow, de acordo com os métodos implementados nessa classe
     */
    @Test
    public void getCapacidadeEventoShow() {

        Local testLocal = new Local("Teatro Castro Mendes", 2000);
        EventoShow testEvento = new EventoShow(120,"MPB","Djavan","01/05/2025","MPB em Campinas",testLocal, 150.0);
        assertEquals(2000, testEvento.getLocal().getCapacidade());
    }

    /**
     * Testa o get e seter do EventoShow para o atributo artista
     * Modificações nos parâmentro do EventoShow, de acordo com os métodos implementados nessa classe
     * Espera-se a troca de "01/05/2025" por "Anavitória"
     */

    @Test
    public void setAndGetArtistaEventoShow() {

        Local testLocal = new Local("Teatro Castro Mendes", 2000);
        EventoShow testEvento = new EventoShow(180,"MPB","Djavan","01/05/2025","MPB em Campinas",testLocal, 150 );
        testEvento.setArtista("Anavitória");
        assertEquals("Anavitória", testEvento.getArtista());
    }

    /**
     * Testa o método getPreco para o IngressoMeia
     * Modificações nos parâmentro do EventoShow, de acordo com os métodos implementados nessa classe
     * Espera o retorno da metade do valor (100) do ingresso do EventoShow criado (200)
     */

    @Test
    public void getPrecoIngressoMeia() {

        Local testLocal = new Local("Teatro Castro Mendes", 2000);
        EventoShow testEvento = new EventoShow(180,"MPB","Djavan","01/05/2025","MPB em Campinas",testLocal, 200);
        IngressoMeia ingressoMeia = new IngressoMeia(testEvento);
        assertEquals(100, ingressoMeia.getPreco());
    }

    /**
     * Testa o método getPreco para o IngressoInteira
     * Modificações nos parâmentro do EventoShow, de acordo com os métodos implementados nessa classe
     * Espera o retorno do valor (250) do ingresso do EventoShow criado
     */
    @Test
    public void getPrecoIngressoInteira() {

        Local testLocal = new Local("Teatro Castro Mendes", 2000);
        EventoShow testEvento = new EventoShow(180,"MPB","Djavan","01/05/2025","MPB em Campinas",testLocal, 250);
        IngressoInteira ingressoInteira = new IngressoInteira(testEvento);
        assertEquals(250, ingressoInteira.getPreco());
    }

    /**
     * Testa o método adicionarIngressoMeia
     * Modificações nos parâmentro do EventoShow, de acordo com os métodos implementados nessa classe
     * Verifica se o ingresso foi adicionado à lista de ingressos vendidos
     * e se o usuario agora tem o ingresso
     */
    @Test
    public void adicionarIngressoMeia() {

        Local testLocal = new Local("Teatro Castro Mendes", 2000);
        EventoShow testEvento = new EventoShow(180,"MPB","Djavan","01/05/2025","MPB em Campinas",testLocal, 250);
        IngressoMeia ingressoMeia = new IngressoMeia(testEvento);
        Usuario usuarioTest = new Usuario("Gabriel", "gabriel@me.com");
        testEvento.adicionaIngresso(ingressoMeia, usuarioTest);
        assertEquals(1, testEvento.getIngressosVendidos().size());
        assertEquals(ingressoMeia, usuarioTest.getIngresso());

    }
}
