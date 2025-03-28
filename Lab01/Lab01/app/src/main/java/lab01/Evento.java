/*
 * Evento.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

 package lab01;

 import java.util.List;
 import java.util.ArrayList;
 
 /**
  * Contém a estrutura de implementação de um Evento.
  * 
  * @author Gabriela Taniguchi - 281773
  */
 public abstract class Evento {
     private String nome;
     private Local local;
     private double precoIngresso;
     private List<Ingresso> ingressosVendidos;
 
     /**
      * Construtor da classe Evento
      * @param nome o nome do Evento
      * @param local o local associado ao Evento
      */
     public Evento(String nome, Local local, double precoIngresso){
         this.nome = nome;
         this.local = local;
         this.precoIngresso = precoIngresso;
         this.ingressosVendidos = new ArrayList<>();
     }
 
     /**
      * Retorna o nome do Evento
      * @return o nome do Evento
      */
     public String getNome(){
         return nome;
     }
 
     /**
      * Altera o nome do Evento para 'nome' 
      * @param nome o novo nome do Evento
      */
     public void setNome(String nome){
         this.nome = nome;
     }
 
     /**
      * Retorna o local do Evento
      * @return o local do Evento
      */
     public Local getLocal(){
         return local;
     }
 
     /**
      * Altera o local do Evento para 'local' 
      * @param local o novo local do Evento
      */
     public void setLocal(Local local){
         this.local = local;
     }
 
     /**
      * Retorna o preço do ingresso do Evento
      * @return o precoIngresso do Evento
      */
     public double getPrecoIngresso(){
         return precoIngresso;
     }
 
     /**
      * Altera o precoIngresso do Evento para `precoIngresso` 
      * @param precoIngresso o novo precoIngresso do Evento
      */
     public void setPrecoIngresso(double precoIngresso){
         this.precoIngresso = precoIngresso;
     }
 
     /**
      * Adiciona o ingresso vendido ao usuário à lista de ingressos vendidos
      * @param ingressosVendidos a lista com os ingressos vendidos
      * @param usuario o usuario que comprou o ingresso
      */
     public void adicionaIngresso(Ingresso ingresso, Usuario usuario){
         this.ingressosVendidos.add(ingresso); 
         usuario.setingresso(ingresso);
     }
 
     /**
      * Retorna a lista com os ingressos vendidos
      * @return lista ingressos vendidos
      */
     public List<Ingresso> getIngressosVendidos(){
         return this.ingressosVendidos;
     }
 
     /**
      * Calcula o valor total de faturamento
      * @return o faturamento total
      */
     public double calcularFaturamento(){
         double FaturamentoTotal = 0.0;
 
         for(Ingresso ingresso : ingressosVendidos){
             FaturamentoTotal += ingresso.getPreco();
         }
 
         return FaturamentoTotal;
     }
 }
 
