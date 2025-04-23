/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

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
    }

    /**
     * Adiciona um local à lista de locais disponíveis
     * @param local o local a ser adicionado
     */
    public void adicionarLocal(Local local) {
        this.locais.add(local);
    }

    public Local buscarLocal(String nome){
        for (Local atual : locais){
            if(atual.getNome().equals(nome)) return atual;
        }

        return null;
    }

    public Local buscarLocal(int capacidadeMaxima){
        for (Local atual : locais){
            if(atual.getCapacidade()==capacidadeMaxima) return atual;
        }
        return null;
    }
    
}
