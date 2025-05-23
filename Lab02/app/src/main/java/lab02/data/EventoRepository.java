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

        // Evento evento1 = new Evento("Lollapalooza Brasil 2025", localFestival, 200.0, organizadora,"27/04/2025");
        // organizadora.adicionarEvento(evento1);
        // CaracteristicaFestival caracteristicaFestival = new CaracteristicaFestival(List.of("Coldplay", "Justin Timberlake", "Sepultura", "Olivia Rodrigo"), "3 dias");
        // evento1.adicionarCaracteristica(caracteristicaFestival);
        // eventos.add(evento1);

        // Evento eventoEmBar = new Evento("Noite de Karaoke", localBar, 25.0, organizadora, "20/08/2025");
        // organizadora.adicionarEvento(eventoEmBar);
        // CaracteristicaBar caracteristicaBar = new CaracteristicaBar("Boteco do João", "20:00 h", "4 horas");
        // CaracteristicaMusicaAoVivo caracteristicaMusicaAoVivoEmBar = new CaracteristicaMusicaAoVivo("Clara Nunes", "Samba");
        // eventoEmBar.adicionarCaracteristica(caracteristicaBar);
        // eventoEmBar.adicionarCaracteristica(caracteristicaMusicaAoVivoEmBar);


        eventos.add(new Evento("Lollapalooza Brasil 2025", localFestival, 200.0, organizadora,"27/04/2025"));
        eventos.add(new Evento("Noite de Karaoke", localBar, 25.0, organizadora, "20/08/2025"));
        eventos.add(new Evento("Final da Copa do Brasil", localJogo, 250.0, organizadora, "30/09/2025"));
        eventos.add(new Evento("Concerto Clássico", localTeatro, 50.0, organizadora, "01/06/2025"));
        eventos.add(new Evento("Show Coldplay Live in São Paulo", localShow, 400.0, organizadora, "15/11/2025"));
        eventos.add(new Evento("Festival de Jazz", localArena, 70.0, organizadora, "15/07/2025"));
        eventos.add(new Evento("Peça Teatral", localTeatro, 40.0, organizadora, "10/08/2025"));

        return eventos;
    }
    
}
