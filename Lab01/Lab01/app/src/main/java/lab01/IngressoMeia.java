package lab01;

/**
 * Contém a estrutura de implementação de um Ingresso Meia.
 * 
 * @author Gabriela Taniguchi - 281773
 */

public class IngressoMeia extends Ingresso{
   
    /**
     * Construtor da classe IngressoMeia
     * @param evento o evento associado ao IngressoMeia
     */
    public IngressoMeia(Evento evento){
        super(evento);
    }

    /**
     * Retorna o preço do Ingresso
     * @return o preço do Ingresso
     */

    @Override
    public double getPreco() {
        // Ingresso meia recebe metade do valor do ingresso do evento
        return this.getEvento().getPrecoIngresso()/2;
    }


}
