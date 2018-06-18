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
		this.mano = new ZonaMano();
		this.cementerio = new Cementerio();
		this.zonaCartasMagicasOTrampas = new ZonaDeCartasMagicasOTrampas();
		this.zonaMonstruos = new ZonaDeCartasMonstruos();
		this.zonaCartasDeCampo = new ZonaDeCartasDeCampo();
		for (int i = 0; i<5; i++ ) {
			this.mano.agarrarCarta(this.mazo);
		}
	}

	public void quitarPuntosDeVida(int puntosPerdidos) {
		this.puntosDeVida = this.puntosDeVida - puntosPerdidos;
	}

	public int darPuntosDeVida() {
		return this.puntosDeVida;
	}

	
	public void colocarBocaArriba(CartaCampo carta) {
		this.colocarBocaArriba(carta);
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
	
	public void colocarMonstruo(CartaMonstruo monstruo, int posicion) {
		this.zonaMonstruos.agregarCarta(monstruo, posicion);
	}

	public void colocarCartaTrampaOMagica(CartaTrampaOMagica carta, int posicion) {
		this.zonaCartasMagicasOTrampas.agregarCarta(carta, posicion);
	}
	
	public void colocarCartaCampo(CartaCampo campo, int posicion) {
		this.zonaCartasDeCampo.agregarCarta(campo, posicion);
	}
	
	public boolean noTieneMonstruos() {
		return this.zonaMonstruos.estaVacia();
	}
	
	public void colocarBocaArriba(CartaTrampaOMagica carta) {
		this.zonaCartasMagicasOTrampas.agregarCarta(carta, 0);
		carta.colocarBocaArriba();	
	}
	
	public void colocarBocaArriba(CartaMonstruo carta, int posicion) {
		ArrayList<CartaMonstruo> monstruosSacrificados = this.zonaMonstruos.sacrificarMonstruos(carta.numeroDeSacrificios());
		Iterator<CartaMonstruo> m = monstruosSacrificados.iterator();
		while (m.hasNext()) {
			CartaMonstruo monstruo = m.next();
			this.enviarAlCementerio(monstruo);
		}
		this.zonaMonstruos.agregarCarta(carta, posicion);
		carta.colocarBocaArriba();
	}

	public boolean estaEnElCampo(CartaMonstruo cartaMonstruo) {
		return this.zonaMonstruos.obtenerCartas().contains(cartaMonstruo);
	}
	
	public boolean estaEnElCampo(CartaTrampaOMagica cartaTrampaOMagica) {
		return false;
	}	
	
	public boolean estaEnElCampo(CartaCampo cartaCampo) {
		return false;
	}
	
	public void agarrarCarta() {
		this.mano.agarrarCarta(this.mazo);
	}
	
	public void ponerCartaEnTablero(CartaTrampaOMagica carta, int posicion) {
		this.mano.eliminarCarta(carta);
		this.zonaCartasMagicasOTrampas.agregarCarta(carta, posicion);
	}

	public void ponerCartaEnTablero(CartaCampo carta, int posicion) {
		this.mano.eliminarCarta(carta);
		this.zonaCartasDeCampo.agregarCarta(carta, posicion);
	}
	
	public void ponerCartaEnTablero(CartaMonstruo carta, int posicion) {
		this.mano.eliminarCarta(carta);
		this.zonaMonstruos.agregarCarta(carta,posicion);
	}
}