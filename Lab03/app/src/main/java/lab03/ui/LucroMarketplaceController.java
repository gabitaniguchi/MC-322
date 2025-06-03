package lab03.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import lab03.data.MarketplaceRepository;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

/**
 * Controlador para a tela que exibe o lucro acumulado do marketplace.
 */
public class LucroMarketplaceController {

    @FXML
    private Label lucroValueLabel; // Label para mostrar o valor do lucro

    /**
     * Inicializa o controlador definindo o valor do lucro exibido na tela.
     * Método chamado automaticamente após o carregamento do FXML.
     */
    public void initialize() {
        // Obtém o lucro do marketplace e formata para exibição em moeda
        lucroValueLabel.setText(String.format("R$ %.2f", MarketplaceRepository.getMarketplace().getLucro()));
    }

    /**
     * Trata o clique no botão "Voltar".
     * Retorna para a tela principal do sistema.
     */
    @FXML
    private void handleVoltar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
            Scene mainScene = new Scene(loader.load(), 800, 600);

            // Pega a janela atual a partir do botão que disparou o evento
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(mainScene);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

}
