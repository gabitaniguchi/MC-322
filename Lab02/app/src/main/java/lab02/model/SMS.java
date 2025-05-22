package lab02.model;

public class SMS implements Notificavel{
    private int numeroDeTelefone;

    /**
     * Construtor da classe Email
     * @param numeroDeTelefone o número do telefone
     */
    public SMS(int numeroDeTelefone){
        this.numeroDeTelefone = numeroDeTelefone;
    }

    /**
     * Imprime a notificação de uma nova mensagem
     * @param mensagem a mensagem a ser impressa
     */
    @Override
    public void notificar(String mensagem){
        System.out.println("Novo mensagem para " + numeroDeTelefone + " : " + mensagem);
    }
    
    
}
