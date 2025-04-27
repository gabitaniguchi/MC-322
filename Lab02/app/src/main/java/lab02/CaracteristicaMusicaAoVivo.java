package lab02;

public class CaracteristicaMusicaAoVivo extends CaracteristicaDeEvento{

    private String nomeDoArtista;
    private String generoMusical;

    public CaracteristicaMusicaAoVivo(String nomeArtista, String generoMusical) {
        this.nomeDoArtista = nomeArtista;
        this.generoMusical = generoMusical;
    }
    
    @Override
    public String descricao(){
        return("Musica ao vivo com " + nomeDoArtista + "(" + generoMusical + ")");
    }

    
}
