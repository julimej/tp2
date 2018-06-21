package fiuba.algo3.tp2.Tableros;


import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;

public class ZonaMano extends Zona{
		
	public ZonaMano(Jugador jugador) {
		super(jugador);
		this.limite = 41;
		// TODO Auto-generated constructor stub
	}
	
	public void agregarCarta(Carta carta) {
		super.agregarCarta(carta, this.cartas.size());
		if (carta == null) { 
			return;
		}
		Efecto efecto = carta.obtenerEfecto();
		efecto.activarAlAgregarAZonaMano(this, carta);
		}
}
