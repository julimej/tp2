package vista.eventHandlers;

import java.io.File;

import fiuba.algo3.tp2.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import vista.LayoutContenedorJuego;
import vista.SceneCompletarNombres;
import vista.SceneInicio;
import vista.SceneJuego;


public class BotonJuegoTerminadoEventHandler implements EventHandler<ActionEvent> {

	private Stage stageJuego;
	private Stage stageFinDeJuego;
	
	public BotonJuegoTerminadoEventHandler(Stage stageJuego,Stage stageFinDeJuego) {
		this.stageJuego = stageJuego;
		this.stageFinDeJuego = stageFinDeJuego;
    }
	
	public void handle(ActionEvent arg0) {
        this.stageJuego.close();
        this.stageFinDeJuego.close();
	}
}
