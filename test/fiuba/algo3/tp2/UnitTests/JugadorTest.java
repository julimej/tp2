package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.*;
import fiuba.algo3.tp2.Excepciones.CartaNoSeEncuentraEnZona;

public class JugadorTest {

	@Test
	public void test01AgarrarCartaDelMazoLaPoneEnLaMano() {
		Jugador jugador = new Jugador();
		jugador.agarrarCarta();
		Collection<Carta> mano = jugador.obtenerCartasEnMano();
		assertEquals(mano.size(), 1);
	}
	
	@Test
	public void test02enviarAlCementerioCartaCampoSacaLaCartaDelCampo() {
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		
		CartaCampo carta = factory.crearCartaCampoGenerica();
		jugador.colocarCartaEnZona(carta, oponente);
		
		jugador.enviarAlCementerio(carta);
		assertFalse(jugador.obtenerCartaCampo().contains(carta));
	}
	
	@Test
	public void test03enviarAlCementerioCartaCampoLaPoneEnElCementerio() {
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		
		CartaCampo carta = factory.crearCartaCampoGenerica();
		jugador.colocarCartaEnZona(carta, oponente);
		
		jugador.enviarAlCementerio(carta);
		assertTrue(jugador.obtenerCartasEnCementerio().contains(carta));
		
	}
	
	@Test
	public void test04enviarAlCementerioCartaTrampaSacaLaCartaDelCampo() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		
		CartaTrampa carta = factory.crearCartaTrampaGenerica();
		jugador.colocarCartaEnZona(carta, 1);
		
		jugador.enviarAlCementerio(carta);
		assertFalse(jugador.obtenerCartasMagicasYTrampas().contains(carta));
	}
	
	@Test
	public void test05enviarAlCementerioCartaMagicaLaPoneEnElCementerio() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		
		CartaTrampa carta = factory.crearCartaTrampaGenerica();
		jugador.colocarCartaEnZona(carta, 1);
		
		jugador.enviarAlCementerio(carta);
		assertTrue(jugador.obtenerCartasEnCementerio().contains(carta));
	}
	
//	@Test
//	public void test06colocarCartaEnZonaLaEliminaDeLaMano() {
//		Jugador jugador = new Jugador();
//		Carta carta = jugador.agarrarCarta();
//		
//		if (carta.getClass() == CartaCampo.class) {
//			jugador.colocarCartaEnZona((CartaCampo) carta, new Jugador());
//		}
//		else {
//			if (carta.getClass() == CartaTrampa.class || carta.getClass() == CartaMagica.class) {
//				jugador.colocarCartaEnZona((CartaTrampaOMagica) carta, 0);
//			}
//			else {
//				jugador.colocarCartaEnZona((CartaMonstruo) carta, 0, new ArrayList<CartaMonstruo>());
//			}
//		}
//		
//		assertEquals(jugador.obtenerCartasEnMano().size(), 0);
//	}
//	
	
	@Test
	public void test07Agarrar2CartasDelMazoLasPoneEnLaMano() {
		Jugador jugador = new Jugador();
		jugador.agarrarCartasDelMazo(2);
		Collection<Carta> mano = jugador.obtenerCartasEnMano();
		assertEquals(mano.size(), 2);
	}


}
