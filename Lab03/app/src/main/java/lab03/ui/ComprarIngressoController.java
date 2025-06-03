package lab03.ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import lab03.data.MarketplaceRepository;
import lab03.model.Cliente;
import lab03.model.Evento;
import lab03.model.Marketplace;
import lab03.model.OfertaIngresso;
import lab03.model.Cliente.SaldoInsuficienteException;

/**
 * Controlador responsável pela tela de compra de ingresso.
 * Permite exibir detalhes do ingresso e confirmar a compra, considerando saldo e tipo da oferta.
 */
public class ComprarIngressoController {

    @FXML
    private Label saldoLabel; // Mostra o saldo do cliente logado

    @FXML
    private Label eventoLabel; // Nome do evento do ingresso

    @FXML
    private Label dataLabel; // Data do evento

    @FXML
    private Label localLabel; // Local onde ocorrerá o evento

    @FXML
    private Label precoLabel; // Preço do ingresso

    @FXML
    private TextField precoIngresso; // Campo para o usuário inserir o valor da compra

    @FXML
    private Label messageLabel; // Mensagens de erro/validação

    private OfertaIngresso oferta; // Oferta selecionada para compra

    /**
     * Define a oferta selecionada e exibe os detalhes do ingresso.
     * @param oferta A oferta de ingresso a ser exibida e comprada
     */
    public void setOferta(OfertaIngresso oferta){
        this.oferta = oferta;
        mostrarDetalhes();
    }

    /**
     * Inicializa a tela com o saldo atual do cliente logado.
     */
    @FXML
    public void initialize() {
        Cliente cliente = Sessao.getClienteLogado(); 
        saldoLabel.setText("R$ " + String.format("%.2f", cliente.getSaldo()));
    }

    /**
     * Exibe os detalhes da oferta selecionada: nome, data, local e preço.
     */
    private void mostrarDetalhes() {
        Evento evento = oferta.getIngresso().getEvento();
        eventoLabel.setText("Evento: " + evento.getNome());
        dataLabel.setText("Data: " + evento.getData());
        localLabel.setText("Local: " + evento.getLocal().getNome());
        precoLabel.setText("Preço: R$ " + String.format("%.2f", oferta.getPrecoPedido()));
    }

    /**
     * Confirma a compra da oferta, validando o valor digitado e o saldo disponível.
     * Realiza a transação conforme o tipo de oferta (oficial ou marketplace).
     */
    @FXML
    private void handleConfirmarCompra(ActionEvent event) {
        double pagamento = Double.parseDouble(precoIngresso.getText());
        double valorIngresso = oferta.getPrecoPedido();

        // Validação: o valor informado deve ser exatamente igual ao valor do ingresso
        if (Math.abs(pagamento - valorIngresso) > 0.01) {
            messageLabel.setText("Insira o valor correto");
            return;
        }

        try {
            Cliente comprador = Sessao.getClienteLogado();
            Marketplace marketplace = MarketplaceRepository.getMarketplace();

            // Validação: saldo suficiente
            if (comprador.getSaldo() < oferta.getPrecoPedido()) {
                throw new SaldoInsuficienteException("Saldo Insuficiente");
            }

            // Compra depende se a oferta é oficial ou não
            if (oferta.getOficial()) {
                comprador.comprarIngressoOficial(oferta);
            } else {
                comprador.comprarIngressoNoMarketplace(oferta, marketplace);
            }

            // Informa o sucesso da compra
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Compra confirmada");
            alerta.setHeaderText(null);
            // Calcula a comissão (percentual da venda) e mostra no alerta
            alerta.setContentText("Ingresso comprado com sucesso!");
            alerta.showAndWait(); // Exibe o alerta e espera o usuário fechar

            if(oferta.getOficial()){
                // Após a compra, redireciona para tela de eventos oficiais
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventList.fxml"));
                Scene newScene = new Scene(loader.load(), 800, 600);
                Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
                stage.setScene(newScene);
            }

            else{
                // Após a compra, redireciona para tela de ofertas atualizada
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/OfertasMarketplace.fxml"));
                Scene newScene = new Scene(loader.load(), 800, 600);
                OfertasMarketplaceController controller = loader.getController();
                controller.atualizarOfertas();
    
                Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
                stage.setScene(newScene);
            }


        } catch (SaldoInsuficienteException e) {
            // Exibe alerta informando saldo insuficiente
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erro na compra");
            alert.setHeaderText(null);
            alert.setContentText("Saldo Insuficiente");

            Label contentLabel = new Label("Saldo Insuficiente");
            contentLabel.setStyle("-fx-alignment: center; -fx-text-alignment: center;");
            contentLabel.setWrapText(true);
            alert.getDialogPane().setContent(contentLabel);
            alert.showAndWait();

        } catch (IOException ex) {
            ex.printStackTrace(); 
        }
    }

    /**
     * Retorna para a tela principal (MainWindow.fxml).
     */
    @FXML
    private void handleVoltar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);

            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace(); 
        }
    }
}
