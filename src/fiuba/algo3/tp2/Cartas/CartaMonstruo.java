package fiuba.algo3.tp2.Cartas;

import java.util.ArrayList;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Estados.AccionAtaque;
import fiuba.algo3.Estados.AccionDefensa;
import fiuba.algo3.Estados.Accionable;
import fiuba.algo3.Estados.MonstruoPosicionAbajo;
import fiuba.algo3.Estados.MonstruoPosicionArriba;
import fiuba.algo3.Estados.MonstruoPosicionable;
import fiuba.algo3.Estados.Posicionable;
import fiuba.algo3.tp2.Invocador;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Excepciones.CartaNoSeEncuentraEnZona;

public class CartaMonstruo extends Carta{
	
	private int puntosDeAtaque;
    private int puntosDeDefensa;
    private int estrellas;
	private MonstruoPosicionable posicion;
	private Accionable accion;
	private Invocador invocador;
	
    public CartaMonstruo(String nombre, Jugador jugador, Efecto efecto, int estrella, int ataque, int defenza) {
    	super(jugador, efecto);
		this.estrellas = estrella;
		this.nombre = nombre;
		this.invocador = Invocador.obtenerInvocador(this);
    	this.puntosDeAtaque = ataque;
		this.puntosDeDefensa = defenza;
		this.posicion = new MonstruoPosicionArriba(); 
		this.accion = new AccionAtaque();
	}
    
	public void atacar(CartaMonstruo otro) {
		if(!this.jugador.estaEnElCampo(this)) throw new CartaNoSeEncuentraEnZona();
		this.posicion.atacar(this, otro);
    }

	public void defender(CartaMonstruo cartaAtacante) {
		if(!this.estaEnElCampo()) throw new CartaNoSeEncuentraEnZona();
		this.posicion.defender(cartaAtacante, this.accion, this);
	}
	
	public void colocarEnAccionDeDefensa() {
		this.accion = new AccionDefensa();
	}

	public void colocarEnAccionDeAtaque() {
		this.accion = new AccionAtaque();
	}
	
	public int obtenerPuntosAtaque() {
		return this.puntosDeAtaque;
	}
	
	public int obtenerPuntosDefensa() {
		return this.puntosDeDefensa;
	}
	
	public void configurarPuntosAtaque(int puntos) {
		this.puntosDeAtaque = puntos;
	}
	
	public void configurarPuntosDefensa(int puntos) {
		this.puntosDeDefensa = puntos;
	}
	
	public void enviarAlCementerio() {
		this.jugador.enviarAlCementerio(this);
	}
	
	public Accionable obtenerAccion() {
		return this.accion;
	}
	
	public Posicionable obtenerPosicion() {
		return (Posicionable) this.posicion;
	}

	public void quitarVidaAJugador(int puntosPerdidos) {
		// TODO Auto-generated method stub
		this.jugador.quitarPuntosDeVida(puntosPerdidos);
	}

	public void activar(Jugador atacado) {
		this.efecto.activarSobreJugadorAtacante(this.jugador);
		this.efecto.activarSobreJugadorAtacado(atacado);
		
	}

	public void colocarBocaAbajo() {
		this.posicion = new MonstruoPosicionAbajo();
		
	}

	public void colocarBocaArriba() {
		this.posicion = new MonstruoPosicionArriba();
		
	}

	public boolean estaEnElCampo() {
		return this.jugador.estaEnElCampo(this);
	}

	public int numeroDeSacrificios() {
		if (4 < this.estrellas && this.estrellas < 7) {
			return 1;
		}
		if (6 < this.estrellas) {
			return 2;
		}
		else {
			return 0;
		}
	}

	public boolean invocacionValida(ArrayList<CartaMonstruo> cartasSacrificadas) {
		return this.invocador.invocacionValida(cartasSacrificadas);
	}

	public int estrellas() {
		return this.estrellas;
	}
	
	public String nombre() {
		return this.nombre;
	}
}
