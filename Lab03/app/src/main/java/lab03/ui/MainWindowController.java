package lab03.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lab03.model.Cliente;
import javafx.event.ActionEvent;
import java.io.IOException;

/**
 * Controlador da janela principal após o login do cliente.
 * Responsável por exibir o nome do cliente e navegar entre telas.
 */
public class MainWindowController {

    @FXML
    private Label nomeClienteLabel;

    /**
     * Método chamado automaticamente após a carga do FXML.
     * Inicializa a interface com o nome do cliente logado.
     */
    @FXML
    public void initialize() {
        Cliente cliente = Sessao.getClienteLogado();
        if (cliente != null) {
            nomeClienteLabel.setText("Bem-vindo, " + cliente.getNome());
        } else {
            nomeClienteLabel.setText("Bem-vindo");
        }
    }

    /**
     * Manipula o clique no botão para visualizar eventos.
     * Troca a cena atual para a lista de eventos.
     */
    @FXML
    private void handleVisualizarEventos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventList.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Manipula o clique no botão para ver os ingressos do cliente.
     * Troca para a cena que lista os ingressos adquiridos.
     */
    @FXML
    private void handleMeusIngressos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MeusIngressos.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Manipula o clique para visualizar ofertas no marketplace.
     * Troca para a cena que mostra as ofertas disponíveis.
     */
    @FXML
    private void handleOfertasMarketplace(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/OfertasMarketplace.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Manipula o clique para visualizar o lucro do marketplace.
     * Troca para a cena que exibe o lucro acumulado.
     */
    @FXML
    private void handleLucroMarketplace(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LucroMarketplace.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Manipula o clique para sair da aplicação.
     * Limpa a sessão do usuário e volta para a tela de login.
     */
    @FXML
    private void handleSair(ActionEvent event) {
        try {
            Sessao.limpar(); // Desloga o usuário
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
