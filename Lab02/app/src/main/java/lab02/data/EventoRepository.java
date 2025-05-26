package lab02.data;

// import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
// import lab02.model.CaracteristicaBar;
// import lab02.model.CaracteristicaFestival;
// import lab02.model.CaracteristicaMusicaAoVivo;
import lab02.model.Evento;
import lab02.model.Local;
import lab02.model.Organizadora;

public class EventoRepository {

    public static ObservableList<Evento> definirEventos(){
        ObservableList<Evento> eventos = FXCollections.observableArrayList();
        
        Organizadora organizadora = new Organizadora("Unicamp Eventos", 12345, "Barão Geraldo");
        
        Local localFestival= new Local("Autodromo de Interlagos", 300000);
        Local localBar = new Local("Embreev", 500);
        Local localTeatro = new Local("Teatro Municipal", 5000);
        Local localArena = new Local("Arena Cultural", 300);
        Local localJogo = new Local("Estádio do Maracanã", 78000);
        Local localShow = new Local("Allianz Parque", 45000);
        Local localCinema = new Local("Cine Belas Artes - SP", 4000);
        Local localOlimpiadas = new Local("SoFi Stadium", 50000);
        Local localMasterchef = new Local("Estúdios Vera Cruz - SP", 5000);
        Local localGameCon = new Local("Expo Center Norte – SP", 10000);

        eventos.add(new Evento("Lollapalooza Brasil 2025", localFestival, 200.0, organizadora,"27/09/2025"));
        eventos.add(new Evento("Noite de Karaoke", localBar, 25.0, organizadora, "20/08/2025"));
        eventos.add(new Evento("Final da Copa do Brasil", localJogo, 250.0, organizadora, "30/09/2025"));
        eventos.add(new Evento("Concerto Clássico", localTeatro, 50.0, organizadora, "01/06/2025"));
        eventos.add(new Evento("Show Coldplay Live in São Paulo", localShow, 400.0, organizadora, "15/11/2025"));
        eventos.add(new Evento("Festival de Jazz", localArena, 70.0, organizadora, "15/07/2025"));
        eventos.add(new Evento("Peça Teatral", localTeatro, 40.0, organizadora, "10/08/2025"));
        eventos.add(new Evento("Festival de Cinema", localCinema, 40.0,organizadora, "30/10/2025"));
        eventos.add(new Evento("Olimpíadas 2028", localOlimpiadas, 200.0, organizadora, "11/07/2028"));
        eventos.add(new Evento("Final do Masterchef", localMasterchef, 0, organizadora, "20/12/2025"));
        eventos.add(new Evento("GameCon Brasil 2025", localGameCon, 80.0, organizadora, "27/11/2026"));
        return eventos;
    }
    
}
