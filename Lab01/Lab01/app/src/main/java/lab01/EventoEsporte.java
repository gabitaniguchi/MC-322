package lab01;

public class EventoEsporte extends Evento {
    private int duracao;
    private String esporte;
    private String data;

    /**
     * Construtor da classe EventoEsporte
     * @param duracao a duração do EventoEsporte
     * @param esporte o esporte do EventoEsporte
     * @param data a data do EventoEsporte
     */
    public EventoEsporte(int duracao, String esporte, String data, String nome, Local local, double precoIngresso){
        super(nome, local, precoIngresso);
        this.duracao = duracao;
        this.esporte = esporte;
    }
    
    /**
     * Retorna a duração do EventoEsporte
     * @return a duração do EventoEsporte
     */
    public int getDuracao(){
        return duracao;
    }

    /**
     * Altera a duração do EventoEsporte para 'duracao' 
     * @param duracao o nova duração do EventoEsporte
     */
    public void setDuracao(int duracao){
        this.duracao = duracao;
    }

    /**
     * Retorna o esporte do EventoEsporte
     * @return o esporte do EventoEsporte
     */
    public String getEsporte(){
        return esporte;
    }

    /**
     * Altera o esporte do EventoEsporte para 'esporte' 
     * @param esporte o novo esporte do EventoEsporte
     */
    public void setEsporte(String esporte){
        this.esporte = esporte;
    }

    /**
     * Retorna a data do EventoEsporte
     * @return a data do EventoEsporte
     */
    public String getData(){
        return data;
    }

    /**
     * Altera a data do EventoEsporte para 'data' 
     * @param data a nova data do EventoEsporte
     */
    public void setData(String data){
        this.data = data;
    }

    /**
     * Imprime os detalhes do EventoEsporte
     * @param duracao a duração do EventoEsporte
     * @param esporte o esporte do EventoEsporte
     * @param data a data do EventoEsporte
     */
    public void exibirDetalhes(){
        System.out.println("Duração: " + duracao + "min");
        System.out.println("Esporte: " + esporte);
        System.out.println("Data: " + data);
    }
}
