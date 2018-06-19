package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaCampo;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Cartas.CartaTrampaOMagica;
import fiuba.algo3.tp2.Tableros.Cementerio;
import fiuba.algo3.tp2.Tableros.Mazo;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasMagicasOTrampas;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasMonstruos;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasDeCampo;
import fiuba.algo3.tp2.Tableros.ZonaMano;

public class Jugador {
	
	private int puntosDeVida;
	private ZonaMano mano;
	private Mazo mazo;
	private ZonaDeCartasMonstruos zonaMonstruos;
	private ZonaDeCartasDeCampo zonaCartasDeCampo;
	private ZonaDeCartasMagicasOTrampas zonaCartasMagicasOTrampas;
	private Cementerio cementerio;
	
	public Jugador() {
		this.puntosDeVida = 8000;
		this.mano = new ZonaMano(this);
		this.mazo = new Mazo(this);
		this.cementerio = new Cementerio();
		this.zonaCartasMagicasOTrampas = new ZonaDeCartasMagicasOTrampas(this);
		this.zonaMonstruos = new ZonaDeCartasMonstruos(this);
		this.zonaCartasDeCampo = new ZonaDeCartasDeCampo(this);
	}

	public void agarrarCartasDelMazo(int numero) {
		for (int i = 0; i < numero; i++ ) {
			this.mano.agarrarCarta(this.mazo);
		}
	}
	
	public void quitarPuntosDeVida(int puntosPerdidos) {
		this.puntosDeVida = this.puntosDeVida - puntosPerdidos;
	}

	public int obtenerPuntosDeVida() {
		return this.puntosDeVida;
	}

	public void destruirMonstruos() {
		this.zonaMonstruos.vaciar();
		Collection<Carta> monstruos = this.zonaMonstruos.obtenerCartas();
		Iterator<Carta> i = monstruos.iterator();
		while (i.hasNext()) {
			CartaMonstruo monstruo = (CartaMonstruo) i.next();
			this.enviarAlCementerio(monstruo);
		}
	}	
	
	public void enviarAlCementerio(CartaCampo carta) {
		cementerio.agregarCarta(carta);
		zonaCartasDeCampo.eliminarCarta(carta);
	}
	
	public void enviarAlCementerio(CartaTrampaOMagica carta) {
		cementerio.agregarCarta(carta);
		zonaCartasMagicasOTrampas.eliminarCarta(carta);
	}
	
	public void enviarAlCementerio(CartaMonstruo carta) {
		cementerio.agregarCarta(carta);
		zonaMonstruos.eliminarCarta(carta);
	}
	
	public void colocarCartaEnZona(CartaMonstruo carta, int posicion, ArrayList<CartaMonstruo> cartasSacrificadas) {
		this.mano.eliminarCarta(carta);
		this.zonaMonstruos.agregarCarta(carta, posicion, cartasSacrificadas);
	}

	public void colocarCartaEnZona(CartaTrampaOMagica carta, int posicion) {
		this.mano.eliminarCarta(carta);
		this.zonaCartasMagicasOTrampas.agregarCarta(carta, posicion);
	}
	
	public void colocarCartaEnZona(CartaCampo carta, Jugador jugadorOponente) {
		this.mano.eliminarCarta(carta);
		this.zonaCartasDeCampo.agregarCarta(carta, jugadorOponente);
	}
	
	public boolean noTieneMonstruos() {
		return this.zonaMonstruos.estaVacia();
	}
	
	public boolean estaEnElCampo(CartaMonstruo cartaMonstruo) {
		return this.zonaMonstruos.obtenerCartas().contains(cartaMonstruo);
	}
	
	public void agarrarCarta() {
		this.mano.agarrarCarta(this.mazo);
	}

	public Collection<Carta> obtenerCartasMagicasYTrampas() {
		return this.zonaCartasMagicasOTrampas.obtenerCartas();
	}

	public Collection<Carta> obtenerMonstruos() {
		return this.zonaMonstruos.obtenerCartas();
	}

	public Collection<Carta> obtenerCartasEnCementerio() {
		return this.cementerio.obtenerCartas();
	}
	
	public Collection<Carta> obtenerCartasEnMano() {
		return this.mano.obtenerCartas();
	}
	
	public Collection<Carta> obtenerCartaCampo() {
		return this.zonaCartasDeCampo.obtenerCartas();
	}
	
	
}