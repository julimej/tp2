package fiuba.algo3.tp2.Cartas;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Estados.PosicionArriba;
import fiuba.algo3.tp2.Jugador;

public class CartaCampo extends Carta{
	
	public CartaCampo(String nombre, Jugador jugador, Efecto efecto) {
		super(nombre, jugador, efecto);
		this.posicion = new PosicionArriba();
	}

	
	public boolean estaEnElCampo() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void activar(Jugador jugadorOponente) {
		this.efecto.activarSobreJugadorAtacante(this.jugador);
		this.efecto.activarSobreJugadorAtacado(jugadorOponente);
	}
	
	public void enviarAlCementerio() {
		this.jugador.enviarAlCementerio(this);
	}
	
}
