package lab01;

public class EventoTeatro extends Evento {
    private int duracao;
    private String peca;
    private String data;

    /**
     * Construtor da classe EventoTeatro
     * @param duracao a duração do EventoTeatro
     * @param peca a peça do EventoTeatro
     * @param data a data do EventoTeatro
     */
    public EventoTeatro(int duracao, String peca, String data, String nome, Local local, double precoIngresso){
        super(nome, local, precoIngresso);
        this.duracao = duracao;
        this.peca = peca;
        this.data = data;
    }

    /**
     * Retorna a duração do EventoTeatro
     * @return a duração do EventoTeatro
     */
    public int getDuracao(){
        return duracao;
    }

    /**
     * Altera a duração do EventoTeatro para 'duracao' 
     * @param duracao o nova duração do EventoTeatro
     */
    public void setDuracao(int duracao){
        this.duracao = duracao;
    }

    /**
     * Retorna a peça do EventoTeatro
     * @return a peça do EventoTeatro
     */
    public String getPeca(){
        return peca;
    }

    /**
     * Altera a peça do EventoTeatro para 'peca'
     * @param peca a nova peca do EventoTeatro
     */
    public void setPeca(String peca){
        this.peca = peca;
    }

    /**
     * Retorna a data do EventoTeatro
     * @return a data do EventoTeatro
     */
    public String getData(){
        return data;
    }

    /**
     * Altera a data do EventoTeatro para 'data' 
     * @param data a nova data do EventoTeatro
     */
    public void setData(String data){
        this.data = data;
    }

    /**
     * Imprime os detalhes do EventoTeatro
     * @param duracao a duração do EventoTeatro
     * @param peca a peça do EventoTeatro
     * @param data a data do EventoTeatro
     */
    public void exibirDetalhes(){
        System.out.println("Duração: " + duracao + "min");
        System.out.println("Peça: " + peca);
        System.out.println("Data: " + data);
    }
}
