package lab01;

/**
 * Contém a estrutura de implementação de um Evento Festival.
 * 
 * @author Gabriela Taniguchi - 281773
 */

public class EventoFestival extends Evento {
    private int duracao;
    private String cultura;
    private String data;

    /**
     * Construtor da classe EventoFestival
     * @param duracao a duração do EventoFestival
     * @param cultura a cultura do EventoFestival
     * @param data o data do EventoFestival
     */
    public EventoFestival(int duracao, String cultura, String data, String nome, Local local, double precoIngresso){
        super(nome, local, precoIngresso);
        this.duracao = duracao;
        this.cultura = cultura;
        this.data = data;
    }

    /**
     * Retorna a duração do EventoFestival
     * @return a duração do EventoFestival
     */
    public int getDuracao(){
        return duracao;
    }

    /**
     * Altera a duração do EventoFestival para 'duracao' 
     * @param duracao o nova duração do EventoFestival
     */
    public void setDuracao(int duracao){
        this.duracao = duracao;
    }

    /**
     * Retorna a cultura do EventoFestival
     * @return a cultura do EventoFestival
     */
    public String getCultura(){
        return cultura;
    }

    /**
     * Altera a cultura do EventoFestival para 'cultura'
     * @param cultura a nova cultura do EventoFestival
     */
    public void setCultura(String cultura){
        this.cultura = cultura;
    }

    /**
     * Retorna a data do EventoFestival
     * @return a data do EventoShow
     */
    public String getData(){
        return data;
    }

    /**
     * Altera a data do EventoShow para 'data' 
     * @param data a nova data do EventoShow
     */
    public void setData(String data){
        this.data = data;
    }

    /**
     * Imprime os detalhes do EventoFestival
     * @param duracao a duração do EventoFestival
     * @param cultura a cultura do EventoFestival
     * @param data a data do EventoFestival
     */
    public void exibirDetalhes(){
        
        System.out.println("Evento Festival : " + this.getNome());
        System.out.println("Duração: " + duracao + " min");
        System.out.println("Cultura: " + cultura);
        System.out.println("Data: " + data);
        System.out.println();
    }
}
