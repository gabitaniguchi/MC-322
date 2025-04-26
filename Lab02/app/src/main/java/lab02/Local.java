/*
 * Local.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;

/**
 * Contém a estrutura de implementação de um Local.
 * 
 * @author Gabriela Taniguchi - 281773
 */
public class Local{
    private String nome;
    private double capacidadeMaxima;
    private boolean disponivel;

    /**
     * Construtor da classe Local
     * @param nome o nome do local
     */
    public Local(String nome, double capacidadeMaxima){
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.disponivel = true;
    }

    /**
     * Retorna o nome do evento
     * @return o nome do evento
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do evento para `nome` 
     * @param nome o novo nome do evento
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna a capacidade do local
     * @return a capacidade do local
     */
    public double getCapacidade(){
        return capacidadeMaxima;
    }
    
    /**
     * Altera a capacidade máxima do local para `capacidadeMaxima` 
     * @param capacidadeMaxima a nova capacidade máxima do local
     */
    public void setCapacidade(double capacidadeMaxima){
        try{
            // se a capacidade for negativa é inválida e lança exceção
            if(capacidadeMaxima < 0){
                throw new IllegalArgumentException("Capacidade inválida");
            }
            
            this.capacidadeMaxima = capacidadeMaxima;

        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Retorna se o evento está disponível ou não
     * @return a disponibilidade do local
     */
    public boolean getDisponibilidade(){
        return disponivel;
    }

    /**
     * Exceção referente à capacidade do local do evento
     * Se o local não tiver capacidade suficiente lança uma exceção
     */
    public class CapacidadeInsuficienteException extends Exception{
        public CapacidadeInsuficienteException(String mensagem) {
            super(mensagem);
        }
    }

    /**
     * Exceção referente à disponibilidade do local do evento
     * Se o local estiver indisponível lança uma exceção
     */
    public class LocalIndisponivelException extends Exception{
        public LocalIndisponivelException (String mensagem) {
            super(mensagem);
        }
    }

    public void alocarParaEvento(Evento evento){
        try{
            if(this.capacidadeMaxima < evento.getIngressosVendidos().size()){
                throw new CapacidadeInsuficienteException("Capacidade Insuficiente");
            }

            if(!this.disponivel){
                throw new LocalIndisponivelException("Local Indisponivel");
            }

            evento.setLocal(this);
            this.disponivel = false;

        } catch(CapacidadeInsuficienteException e){
            System.out.println(e.getMessage());
        } catch(LocalIndisponivelException e){
            System.out.println(e.getMessage());
        }

    }
}
