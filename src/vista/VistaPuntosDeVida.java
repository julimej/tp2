package vista;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.concurrent.Task;

public class VistaPuntosDeVida extends VBox {
	
	private VBox boxNombreJugador1;
	private VBox boxNombreJugador2;
	private ProgressBar pBar1;
	private ProgressBar pBar2;
	private int puntosDeVidaViejos1;
	private int puntosDeVidaViejos2;
	
	public class PuntosDeVidaObserver implements Observer { 
		private VistaPuntosDeVida vista;
		
		public PuntosDeVidaObserver(VistaPuntosDeVida vistaPuntosDeVida) {
			this.vista = vistaPuntosDeVida;
		}
		
		public void update(Observable observable, Object args) {
			this.vista.dibujar();
	    }
	}
	
	public void dibujar() {
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador1 = juego.obtenerJugador(0);
		Jugador jugador2 = juego.obtenerJugador(1);
		
		
		this.modificarVBoxJugador(this.boxNombreJugador1,jugador1);
		this.modificarVBoxJugador(this.boxNombreJugador2,jugador2);
		
        Task<?> task = taskCreator(jugador1.obtenerPuntosDeVida(),this.puntosDeVidaViejos1);
        this.pBar1.progressProperty().unbind();
        this.pBar1.progressProperty().bind(task.progressProperty());
        this.puntosDeVidaViejos1 = jugador1.obtenerPuntosDeVida();
        new Thread(task).start();
        
        task = taskCreator(jugador2.obtenerPuntosDeVida(),this.puntosDeVidaViejos2);
        this.pBar2.progressProperty().unbind();
        this.pBar2.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
        this.puntosDeVidaViejos2 = jugador2.obtenerPuntosDeVida();
	}
	
	public VistaPuntosDeVida(BorderPane layoutContenedorJuego) {
		super();
		
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador1 = juego.obtenerJugador(0);
		Jugador jugador2 = juego.obtenerJugador(1);
		
		PuntosDeVidaObserver puntosDeVidaObserver1 = new PuntosDeVidaObserver(this);
		jugador1.addObserver(puntosDeVidaObserver1);
		PuntosDeVidaObserver puntosDeVidaObserver2 = new PuntosDeVidaObserver(this);
		jugador2.addObserver(puntosDeVidaObserver2);
		
		VBox boxJugador1 = new VBox();
		VBox boxJugador2 = new VBox();
		
		this.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7);");
		
		this.pBar1 = new ProgressBar(8000);
		this.pBar2 = new ProgressBar(8000);
		this.puntosDeVidaViejos1 = 8000;
		this.puntosDeVidaViejos2 = 8000;
		
		this.boxNombreJugador1 = new VBox();
		this.boxNombreJugador1.setSpacing(10);
		this.boxNombreJugador1.setAlignment(Pos.BOTTOM_CENTER);
		this.boxNombreJugador2 = new VBox();
		this.boxNombreJugador2.setSpacing(10);
		this.boxNombreJugador2.setAlignment(Pos.BOTTOM_CENTER);
		
		boxJugador1.getChildren().add(this.boxNombreJugador1);
		boxJugador1.getChildren().add(this.pBar1);
		
		boxJugador2.getChildren().add(this.boxNombreJugador2);
		boxJugador2.getChildren().add(this.pBar2);
		
		
		boxJugador1.setAlignment(Pos.BOTTOM_CENTER);
		boxJugador2.setAlignment(Pos.BOTTOM_CENTER);
		
		this.getChildren().addAll(boxJugador1,boxJugador2);
		this.setSpacing(100);
		this.dibujar();
		this.setPrefWidth(300);
		this.setPrefWidth(getScaleY());
		this.setAlignment(Pos.CENTER_LEFT);
	}
	
	private void modificarVBoxJugador(VBox box,Jugador jugador) {
		final int puntosDeVida = jugador.obtenerPuntosDeVida();
		box.getChildren().clear();
		Text text0 = this.darTextoNombreJugador(jugador.obtenerNombre());
		Text text1 = this.darTextoNombreJugador(""+puntosDeVida);
		Juego juego = Juego.ObtenerJuego();
		Jugador jugadorActual = juego.jugadorOponente();
		box.getChildren().add(text0);
		box.getChildren().add(text1);
		if(jugador.equals(jugadorActual)) {
			Text active = new Text();
			active.setText("turno actual");
			active.setFill(Color.RED);
			box.getChildren().add(active);
		}
	}
	
	private Text darTextoNombreJugador(String jugador) {
		Text nombre = new Text(300, 300, jugador);
		nombre.setFill(Color.RED);
		nombre.setFont(Font.font(java.awt.Font.SERIF, FontWeight.EXTRA_BOLD, 30));
	    final Light.Distant light = new Light.Distant();
	    light.setAzimuth(-135.0);
	    final Lighting lighting = new Lighting();
	    lighting.setLight(light);
	    lighting.setSurfaceScale(9.0);
		return nombre;
	}
	
    //Create a New Task
    private Task<?> taskCreator(final int puntosActuales,final int puntosDeVidaViejos){
        return new Task<Object>() {

                   @Override
                   protected Object call() throws Exception {
                       for(float i=puntosDeVidaViejos; i>=puntosActuales;i-=10){
                           Thread.sleep(25);
                           updateProgress(i,8000);
                          
                          }
                       return true;
                   }
               };
    }
}
