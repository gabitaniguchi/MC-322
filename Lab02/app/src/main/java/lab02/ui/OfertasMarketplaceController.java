// package lab02.ui;

// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.stage.Stage;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.event.ActionEvent;

// import java.io.IOException;
// import java.util.ArrayList;

// import javafx.beans.value.ObservableValue;
// import lab02.model.Evento;
// import lab02.model.OfertaIngresso;
// import lab02.data.EventoRepository;
// import lab02.data.MarketplaceRepository;;

// public class OfertasMarketplaceController {

//     @FXML
//     private ListView<OfertaIngresso> ofertaListView;

//     @FXML
//     private Label nomeLabel;

//     @FXML
//     private Label dataLabel;

//     @FXML
//     private Label localLabel;

//     @FXML
//     private Label precoLabel;

//     @FXML
//     private Label messageLabel;

//     private List<OfertaIngresso> ofertas = new ArrayList<>();

//     @FXML
//     public void initialize() {
//         ofertas = MarketplaceRepository.getMarketplace().listarOrfertas();
//         ofertasListView.setItems(ofertas);
        
//         ofertasListView.setCellFactory(listView -> new ListCell<>() {
//             @Override
//             protected void updateItem(Ofertas, boolean empty) {
//                 super.updateItem(evento, empty);
//                 if (empty || evento == null) {
//                     setText(null);
//                 } else {
//                     setText(evento.getNome());
//                     setStyle("-fx-alignment: center;");
//                 }
//             }
//         });

//         eventoListView.getSelectionModel().selectedItemProperty().addListener(
//             (ObservableValue<? extends Evento> obs, Evento oldVal, Evento newVal) -> mostrarDetalhes(newVal)
//         );
//     }

//     private void mostrarDetalhes(Evento evento) {
//         if (evento != null) {
//             nomeLabel.setText("Nome: " + evento.getNome());
//             dataLabel.setText("Data: " + evento.getData());
//             localLabel.setText("Local: " + evento.getLocal().getNome());
//             precoLabel.setText("Preço: R$ " + evento.getPrecoIngresso());
//         } else {
//             nomeLabel.setText("Nome:");
//             dataLabel.setText("Data:");
//             localLabel.setText("Local:");
//             precoLabel.setText("Preço:");
//         }
//     }

//     @FXML
//     private void handleComprarIngresso(ActionEvent event) {
//         try {
//             Evento eventoSelecionado = eventoListView.getSelectionModel().getSelectedItem();
//             if(eventoSelecionado==null){
//                 messageLabel.setText("Selecione o evento");
//                 return;
//             }
//             FXMLLoader loader = new FXMLLoader(getClass().getResource("/ComprarIngresso.fxml"));
//             Scene newScene = new Scene(loader.load(), 800, 600);

//             ComprarIngressoController controller = loader.getController();
//             controller.setEvento(eventoSelecionado);

//             // Pega a janela atual a partir do botão que disparou o evento
//             Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
//             stage.setScene(newScene);
//         } catch (IOException ex) {
//             ex.printStackTrace(); // Para depuração
//         }
//     }


//     @FXML
//     private void handleVoltar(ActionEvent event) {
//         try {
//             // Carrega a nova cena do arquivo FXML
//             FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
//             Scene newScene = new Scene(loader.load(), 800, 600);

//             // Pega a janela atual a partir do botão que disparou o evento
//             Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
//             stage.setScene(newScene);
//         } catch (IOException ex) {
//             ex.printStackTrace(); // Para depuração
//         }
//     }

    
// }
