package lab02;

public class Email implements Notificavel {

    private String enderecoDeEmail;

    /**
     * Construtor da classe Email
     * @param enderecoDeEmail o email
     */
    public Email(String enderecoDeEmail){
        this.enderecoDeEmail = enderecoDeEmail;
    }

    /**
     * Imprime a notificação de uma nova mensagem
     * @param mensagem a mensagem a ser impressa
     */
    @Override
    public void notificar(String mensagem){
        System.out.println("Novo email para " + enderecoDeEmail + " na caixa de entrada : " + mensagem);
    }
    
}
