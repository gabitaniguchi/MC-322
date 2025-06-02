/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Comparable<Cliente>{

    private String nome;
    private List<Ingresso> ingressos;
    private List<Notificavel> meiosDeNotificacao;
    private double saldo;

    /**
     * Construtor da classe cliente
     * @param nome o nome do cliente
     */
    public Cliente(String nome, double saldo){
        this.nome = nome;
        this.ingressos = new ArrayList<>();
        this.meiosDeNotificacao = new ArrayList<>();
        this.saldo = saldo;
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
     * Retorna o saldo do cliente
     * @return o saldo do cliente
     */
    public double getSaldo(){
        return saldo;
    }

    /**
     * Altera o saldo do CLiente
     * @param saldo o novo saldo do cliente
     */
    public void creditar(double valor){
        this.saldo += valor;
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

    /**
     * Exceção referente a não encontrar ingresso que satisfaça alguma condição
     * Se nenhum ingresso for encontrado lança uma exceção
     */
    public class IngressoNaoEncontradoException extends Exception{
        public IngressoNaoEncontradoException(String mensagem) {
            super(mensagem);
        }
    }

    /**
     * Exceção referente a impossibilidade de cancelar um evento
     * Se o evento não pode ser cancelado, lança uma exceção
     */
    public static class CancelamentoNaoPermitidoException extends Exception{
        public CancelamentoNaoPermitidoException(String mensagem) {
            super(mensagem);
        }
    }

    public static class IngressoNaoPertenceAoClienteException extends Exception{
        public IngressoNaoPertenceAoClienteException(String mensagem){
            super(mensagem);
        }
    }

    public static class OfertaNaoEncontradaException extends Exception{
        public OfertaNaoEncontradaException(String mensagem){
            super(mensagem);
        }
    }

    public static class SaldoInsuficienteException extends Exception{
        public SaldoInsuficienteException(String mensagem){
            super(mensagem);
        }
    }

    /**
     * A função foi gerada com o auxílio de IA
     * Compara duas strings de data para ver qual ocorreu antes
     * Verifica se a data do Evento já passou em relação a data atual
     * @return true se o evento em questão já ocorreu e false se ainda irá acontecer
     */
    boolean eventoPassou(String dataEvento, String dataAtual){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate d1 = LocalDate.parse(dataEvento, formatter);
        LocalDate d2 = LocalDate.parse(dataAtual, formatter);

        if (d1.isBefore(d2)) {
            return true;
        } else{
            return false;
        }
    }

    /**
     * Cancela os ingressos referente a algum evento específico
     * @param evento o evento dos ingressos a serem cancelados
     * @param dataAtual a data do cancelamento para verificar se é possível
     */
    public void cancelarIngresso(Evento evento, String dataAtual){
        try{

            // se a data do evento já passou, lança uma exceção
            if(eventoPassou(evento.getData(), dataAtual)){
                throw new CancelamentoNaoPermitidoException("Não é possível cancelar um evento passado");
            }

            // busca os ingressos referente ao evento em questão
            List<Ingresso> ingressosParaRemover = new ArrayList<>();
            for(Ingresso ingresso: ingressos){
                if(ingresso.getEvento().equals(evento)){
                    ingressosParaRemover.add(ingresso);
                }
            }

            // se nenhum ingresso foi encontrado para ser cancelado, lança uma exceção
            if(ingressosParaRemover.isEmpty()){
                throw new IngressoNaoEncontradoException("Ingresso não encontrado");
            } 

            // remove todos os ingressos do evento em questão
            for(Ingresso ingresso: ingressosParaRemover){
                ingressos.remove(ingresso);
            }

        } catch(IngressoNaoEncontradoException e){
            System.out.println(e.getMessage());
        } catch(CancelamentoNaoPermitidoException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Compara se dois clientes possuem ingressos para o mesmo evento
     * @return 0 se possuem o ingresso em comum e -1 caso contrário
     */
    @Override
    public int compareTo(Cliente cliente2){
        for(Ingresso ingresso1: this.ingressos){
            for(Ingresso ingresso2 : cliente2.getIngressos()){
                if(ingresso1.getEvento().equals(ingresso2.getEvento())){
                    return 0;
                }
            }
        }

        return -1;
    }

    /**
     * Adiciona algum meio de notificação, como Email ou SMS
     * @param meioDeNotificao o meio de notificação a ser adiicionado
     */
    public void adicionarMeioDeNotificacao(Notificavel meioDeNotificacao){
        this.meiosDeNotificacao.add(meioDeNotificacao);
    }

    /**
     * Exibe a notificação por algum meio específico
     * @param mensagem a mensagem a ser notificada
     * @param meioDeNotificacao o meio que exibirá a notificação 
     */
    public void notificarCliente(String mensagem, Notificavel meioDeNotificacao){
        meioDeNotificacao.notificar(mensagem);
    }

    /**
     * Exibe a notificação por todos os veículos ou meios notificáveis
     * @param mensagem a mensagem a ser notificada
     */
    public void todasNotificacoes(String mensagem){
        for(Notificavel  meio: meiosDeNotificacao){
            meio.notificar(mensagem);
        }
    }

    public void oferecerIngressoParaVenda(Ingresso ingresso, double precoPedido, Marketplace marketplace){
        try{
            if(!this.getIngressos().contains(ingresso)){
                throw new IngressoNaoPertenceAoClienteException("Ingresso não pertence ao cliente");
            }
            
            marketplace.receberOferta(ingresso, precoPedido, this, false);
            this.removerIngresso(ingresso);

        }catch(IngressoNaoPertenceAoClienteException e){
            System.out.println(e.getMessage());
        }
    }

    public void comprarIngressoNoMarketplace(OfertaIngresso oferta, Marketplace marketplace){
        try{
            if(!marketplace.listarOfertas().contains(oferta)){
                throw new OfertaNaoEncontradaException("Oferta nao encontrada");
            }

            if(this.getSaldo() < oferta.getPrecoPedido()){
                throw new SaldoInsuficienteException(("Saldo insuficiente"));
            }
            marketplace.processarCompra(this, oferta);

        }catch(OfertaNaoEncontradaException e){
            System.out.println(e.getMessage());
        } catch(SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
        
    }

    public void comprarIngressoOficial(OfertaIngresso oferta){
        try{
            if(this.getSaldo() < oferta.getIngresso().getPreco()){
                throw new SaldoInsuficienteException("Saldo Insuficiente");
            }
            this.adicionarIngresso(oferta.getIngresso());
            this.creditar(-oferta.getIngresso().getPreco());
        }catch(SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

}