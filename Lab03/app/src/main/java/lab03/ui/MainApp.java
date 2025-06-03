package lab03.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principal da aplicação JavaFX.
 * Inicializa a interface carregando a tela de login.
 */
public class MainApp extends Application {

    /**
     * Método principal chamado ao iniciar a aplicação.
     * Configura a janela principal com a cena de login.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega o arquivo FXML da tela de login
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        
        // Cria a cena a partir do FXML carregado
        Scene scene = new Scene(loader.load());
        
        // Aplica o estilo CSS personalizado aos botões
        scene.getStylesheets().add(getClass().getResource("/BotaoPersonalizado.css").toExternalForm());
        
        // Configura o título da janela principal
        primaryStage.setTitle("Venda e Compra de Ingressos");
        
        // Define a cena na janela principal
        primaryStage.setScene(scene);
        
        // Exibe a janela para o usuário
        primaryStage.show();
    }

    /**
     * Método main que inicia a aplicação.
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        launch(args);
    }
}
