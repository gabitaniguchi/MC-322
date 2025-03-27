package lab01;

public class IngressoInteira extends Ingresso{

    /**
     * Construtor da classe IngressoInteira
     * @param evento o evento associado ao IngressoInteira
     */
    public IngressoInteira(Evento evento){
        super(evento);
    }

    /**
     * Retorna o preço do Ingresso
     * @return o preço do Ingresso
     */

    @Override
    public double getPreco() {
        // Ingresso inteira recebe o valor integral do ingresso do evento
        return this.getEvento().getPrecoIngresso();
    }

}
