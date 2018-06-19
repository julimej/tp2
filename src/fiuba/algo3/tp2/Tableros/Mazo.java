package fiuba.algo3.tp2.Tableros;

import java.util.ArrayList;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Excepciones.MazoDeCartasVacioException;

public class Mazo{
	
	private int cantidadDeCartas;
	private ArrayList<Carta> cartas;
	private Jugador jugador;
	
	public Mazo(Jugador _jugador, ArrayList<Carta> _cartas) {
		this.cantidadDeCartas = 40;
		this.cartas = _cartas;
		this.jugador = _jugador;
	}

	public Carta agarrarCarta() {
		if (this.cantidadDeCartas == 0) {
			throw new MazoDeCartasVacioException();
		}
		Carta carta = cartas.remove(cantidadDeCartas);
		this.cantidadDeCartas -=1;
		return carta;
	}
	
	
}
