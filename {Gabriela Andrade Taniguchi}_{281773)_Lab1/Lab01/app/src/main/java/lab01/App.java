/*
 * App.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

 package lab01;

 /**
  * Contém a estrutura de implementação da aplicação.
  * 
  * @author Gabriela Taniguchi - 281773
  */
 public class App {
 
     /**
      * Aplicação principal
      * @param args
      */
     public static void main(String[] args) {
 
 
         // DEMONSTRAÇÃO CÓDIGO PRELIMINAR
         
         Local local = new Local("Theatro Municipal de São Paulo", 300);
         Usuario usuario1 = new Usuario("Gabriel", "gabriel@gmail.com");
 
         // Dados sobre evento
         System.out.println("Código preliminar :");
         System.out.println();
         System.out.println("Local: " + local.getNome());
         System.out.println("Nome do usuário: " + usuario1.getNome());
         System.out.println();
 
         // DEMONSTRAÇÃO PASSO 1
         EventoTeatro eventoteatro = new EventoTeatro(200,"Romeu e Julieta", "10/04/2025", "Clássicos da arte", local, 200.0);
         Ingresso ingressointeira = new IngressoInteira(eventoteatro);
         Ingresso ingressomeia = new IngressoMeia(eventoteatro);
         Ingresso ingressoVIP = new IngressoVIP(eventoteatro);
         
         System.out.println("DEMONSTRAÇÃO PASSO 1: ");
         System.out.println();

         // Dados sobre os ingressos
         System.out.println("Valor Ingresso inteira : " + ingressointeira.getPreco());
         System.out.println("Valor Ingresso meia : " + ingressomeia.getPreco());
         System.out.println("Valor Ingresso VIP : " + ingressoVIP.getPreco());
         System.out.println();
 
         // DEMONSTRAÇÃO PASSO 2
         System.out.println("DEMONSTRAÇÃO PASSO 2: ");
         System.out.println();
         eventoteatro.exibirDetalhes();

         Local quadradefutebol = new Local("Mineirao", 300);
         EventoEsporte eventoesporte = new EventoEsporte(90,"Futebol", "25/04/2025", "Quartas de final", quadradefutebol,100);
         eventoesporte.exibirDetalhes();

         Local praca = new Local("Praça da paz", 500);
         EventoFestival eventofestival = new EventoFestival(300, "japonesa", "11/07/2025", "Festival Oriental", praca, 50);
         eventofestival.exibirDetalhes();

         Local palco = new Local("Campinas Hal", 500);
         EventoShow eventoshow = new EventoShow(300, "Pagode", "Menos é Mais", "30/10/2025", "Show de pagode Menos é Mais", palco, 150);
         eventoshow.exibirDetalhes();

         // DEMONSTRAÇÃO PASSO 3

         Usuario usuario2 = new Usuario("Gabriela", "andradetaniguchi@gmail.com");
         Usuario usuario3 = new Usuario("Natália","nataliataniguchi@gmail.com");
        
         System.out.println("DEMONSTRAÇÃO PASSO 3: ");
         System.out.println();
         eventoteatro.adicionaIngresso(ingressoVIP, usuario1);
         eventoteatro.adicionaIngresso(ingressomeia, usuario2);
         eventoteatro.adicionaIngresso(ingressointeira, usuario3);

         System.out.println("Lista de ingresso Evento Teatro: ");
         eventoteatro.getIngressosVendidos();
         System.out.println("Usuário 1: " + usuario1.getNome() + " " + usuario1.getIngresso());
         System.out.println("Usuário 2: " + usuario2.getNome() + " " + usuario2.getIngresso());
         System.out.println("Usuário 3: " + usuario3.getNome() + " " + usuario3.getIngresso());
         System.out.println("Faturamento Evento Teatro: " + eventoteatro.calcularFaturamento());
         System.out.println();
 
     }
 }
 
 