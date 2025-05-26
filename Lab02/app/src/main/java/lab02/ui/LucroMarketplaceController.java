package lab02.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import lab02.data.MarketplaceRepository;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class LucroMarketplaceController {

    @FXML
    private Label lucroValueLabel;

    // Exemplo: método para definir o lucro exibido na tela
    public void initialize() {
        lucroValueLabel.setText(String.format("R$ %.2f", MarketplaceRepository.getMarketplace().getLucro()));
    }

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
