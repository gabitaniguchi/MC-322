package lab01;

public class IngressoVIP extends Ingresso {

    /**
     * Construtor da classe IngressoVIP
     * @param evento o evento associado ao IngressoVIP
     */
    public IngressoVIP(Evento evento){
        super(evento);
    }

    /**
     * Retorna o preço do Ingresso
     * @return o preço do Ingresso
     */

    @Override
    public double getPreco() {
        // Ingresso VIP recebe o valor integral do ingresso do evento
        return this.getEvento().getPrecoIngresso();
    }


}

