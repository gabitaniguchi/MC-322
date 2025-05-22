/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

 package lab02.model;
import java.util.ArrayList;
import java.util.List;

public class ImobiliariaDeEventos {
    
    private List<Local> locais;
    private String nome;


    /**
     * Construtor da classe ImobiliariaDeEventos
     * @param nome o nome da imobiliária de eventos
     */
    public ImobiliariaDeEventos(String nome) {
        this.nome = nome;
        this.locais = new ArrayList<>();
    }

    /**
     * Retorna o nome da Imobiliaria de Eventos
     * @retun o nome da Imobiliaria de Eventos
     */
    public String getNome(){
        return nome;
    }

    /**
     * Adiciona um local à lista de locais disponíveis
     * @param local o local a ser adicionado
     */
    public void adicionarLocal(Local local) {
        this.locais.add(local);
    }

    /**
     * Dentre os locais da Imobiliária, retorna aquele com o nome em questão
     * @param nome o nome do local a ser buscado
     * @return o local procurado ou null caso não seja encontrado
     */
    public Local buscarLocal(String nome){
        for (Local atual : locais){
            if(atual.getNome().equals(nome)) return atual;
        }

        return null;
    }

    /**
     * Dentre os locais da Imobiliária, retorna aquele com a capacidade máxima em questão
     * @param capacidadeMaxima a capacidade máxima utilizada como parâmetro
     * @return o local procurado ou null caso não seja encontrado
     */
    public Local buscarLocal(int capacidadeMaxima){
        for (Local atual : locais){
            if(atual.getCapacidade()==capacidadeMaxima) return atual;
        }
        return null;
    }
    
}
