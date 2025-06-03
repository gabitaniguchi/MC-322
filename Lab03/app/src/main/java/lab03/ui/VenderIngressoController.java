package lab03.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lab03.data.MarketplaceRepository;
import lab03.model.Cliente;
import lab03.model.Evento;
import lab03.model.Ingresso;

public class VenderIngressoController {

    // Referência ao label que exibe o saldo do cliente
    @FXML
    private Label saldoLabel;

    // Labels que exibem informações do evento relacionado ao ingresso
    @FXML
    private Label eventoLabel;

    @FXML
    private Label dataLabel;

    @FXML
    private Label localLabel;

    // Campo de texto onde o usuário insere o preço de venda do ingresso
    @FXML
    private TextField precoVenda;

    // Objeto ingresso que será vendido (recebido da tela anterior)
    private Ingresso ingresso;

    // Método para definir o ingresso que será vendido e atualizar os detalhes da tela
    public void setIngresso(Ingresso ingresso){
        this.ingresso = ingresso;
        mostrarDetalhes();
    }

    // Método chamado automaticamente após o carregamento do FXML para inicializar componentes
    @FXML
    public void initialize() {
        // Obtém o cliente que está logado na sessão
        Cliente cliente = Sessao.getClienteLogado(); 
        // Atualiza o label do saldo exibindo o saldo formatado com duas casas decimais
        saldoLabel.setText("R$ " + String.format("%.2f", cliente.getSaldo()));
    }

    // Atualiza os labels com os detalhes do evento do ingresso
    private void mostrarDetalhes() {
        Evento evento = ingresso.getEvento();
        eventoLabel.setText("Evento: " + evento.getNome());
        dataLabel.setText("Data: " + evento.getData());
        localLabel.setText("Local: " + evento.getLocal().getNome());
    }

    // Método chamado quando o usuário confirma a venda do ingresso (botão confirm)
    @FXML
    private void handleConfirmarVenda(ActionEvent event) {
        // Converte o texto do campo precoVenda para double (preço pedido pelo ingresso)
        double precoPedido = Double.parseDouble(precoVenda.getText());

        // Obtém o cliente vendedor que está logado na sessão
        Cliente vendedor = Sessao.getClienteLogado();

        // Marca o ingresso como "vendendo" para indicar que está à venda no marketplace
        ingresso.setVendendo(true);

        // Cria um alerta para informar o valor da comissão cobrada sobre a venda
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Comissão");
        alerta.setHeaderText(null);
        // Calcula a comissão (percentual da venda) e mostra no alerta
        alerta.setContentText(String.format("Será cobrado R$ %.2f do valor da venda", 
            (MarketplaceRepository.getMarketplace().getComissao()/100.0)*precoPedido));
        alerta.showAndWait(); // Exibe o alerta e espera o usuário fechar

        // Registra a oferta no marketplace com o ingresso, preço pedido e vendedor
        MarketplaceRepository.getMarketplace().receberOferta(ingresso, precoPedido , vendedor, false);

        // Tenta voltar para a tela principal após confirmar a venda
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);
    
            // Pega a janela atual a partir do evento e troca a cena para a principal
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        }catch (IOException ex) {
            ex.printStackTrace(); 
        }
    }

    // Método chamado quando o usuário clica para voltar (cancelar venda)
    @FXML
    private void handleVoltar(ActionEvent event) {
        try{
            // Carrega a cena anterior (MeusIngressos.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MeusIngressos.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);

            // Pega a janela atual e troca para a cena de ingressos do usuário
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        }catch (IOException ex) {
            ex.printStackTrace(); 
        }
    }
}
