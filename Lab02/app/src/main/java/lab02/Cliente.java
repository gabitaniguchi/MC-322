/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String email;
    private List<Ingresso> ingressos;

    /**
     * Construtor da classe cliente
     * @param nome o nome do cliente
     * @param email o email do cliente
     */
    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.ingressos = new ArrayList<>();
    }

    /**
     * Retorna o nome do cliente
     * @return o nome do cliente
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do evento para `nome` 
     * @param nome o novo nome do cliente
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna o email do cliente
     * @return o email do cliente
     */
    public String getEmail(){
        return email;
    }

    /**
     * Altera o email do cliente para `email` 
     * @param email o novo email do cliente
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Adiciona o ingresso vendido ao cliente à lista de ingressos
     * @param ingresso o ingresso vendido
     */
    public void adicionarIngresso(Ingresso ingresso){
        this.ingressos.add(ingresso); 
    }

    /**
     * Adiciona uma lista de ingressos vendidos à lista de ingressos ao cliente
     * @param novosIngressos os novos ingressos vendidos
     */
    public void adicionarIngresso(List<Ingresso> novosIngressos){
        this.ingressos.addAll(novosIngressos);
    }

    /**
     *  Remove ingresso vendido ao cliente da lista de ingressos
     * @param ingresso o ingresso a ser removido
     */
    public void removerIngresso(Ingresso ingresso){
        this.ingressos.remove(ingresso);
    }

    /**
     * Retorna a lista de ingresso vendidos
     * @return a lista de ingresso vendidos
     */
    public List<Ingresso> getIngressos(){
        return ingressos;
    }

    public class IngressoNaoEncontradoException extends Exception{
        public IngressoNaoEncontradoException(String mensagem) {
            super(mensagem);
        }
    }

    public void cancelarIngresso(Evento evento){
        try{
            boolean encontrado = false;
            for(Ingresso ingresso: ingressos){
                if(ingresso.getEvento().equals(evento)){
                    this.ingressos.remove(ingresso);
                    encontrado = true;
                }
            }

            if(encontrado==false){
                throw new IngressoNaoEncontradoException("Ingresso não encontrado");
            } 
        } catch(IngressoNaoEncontradoException e){
            System.out.println(e.getMessage());
        }

    }


}