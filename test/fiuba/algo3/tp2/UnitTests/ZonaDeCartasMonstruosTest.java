package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.tp2.Tableros.ZonaDeCartasMonstruos;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Excepciones.*;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class ZonaDeCartasMonstruosTest {
	
	@Test
	public void test01agregoUnaCartaALaZonaYVerificoQueSeAgrego() {
		Jugador jugador = new Jugador();
		CartaMonstruo carta = new CartaMonstruo(3,1000,2000,jugador);
		ZonaDeCartasMonstruos zona = new ZonaDeCartasMonstruos();
		zona.agregarCarta(carta, 1);
		assertTrue(zona.obtenerCartas().contains(carta));
	}

	@Test
	public void test02agregoCincoCartaALaZonaYVerificoQueSeAgregaron() {
		Jugador jugador = new Jugador();
		CartaMonstruo carta1 = new CartaMonstruo(3,1000,2000,jugador);
		CartaMonstruo carta2 = new CartaMonstruo(3,1000,2000,jugador);
		CartaMonstruo carta3 = new CartaMonstruo(3,1000,2000,jugador);
		CartaMonstruo carta4 = new CartaMonstruo(3,1000,2000,jugador);
		CartaMonstruo carta5 = new CartaMonstruo(3,1000,2000,jugador);
		ZonaDeCartasMonstruos zona = new ZonaDeCartasMonstruos();
		zona.agregarCarta(carta1, 1);
		zona.agregarCarta(carta2, 2);
		zona.agregarCarta(carta3, 3);
		zona.agregarCarta(carta4, 4);
		zona.agregarCarta(carta5, 5);
		assertTrue(zona.obtenerCartas().contains(carta1) &&
				zona.obtenerCartas().contains(carta2) &&
				zona.obtenerCartas().contains(carta3) &&
				zona.obtenerCartas().contains(carta4) &&
				zona.obtenerCartas().contains(carta5));
	}
	
	@Test(expected = PosicionDeLaZonaOcupadaException.class) 
	public void test03agregoCartaEnPosicionOcupadaDaExcepcion() {
		Jugador jugador = new Jugador();
		CartaMonstruo carta1 = new CartaMonstruo(3,1000,2000,jugador);
		CartaMonstruo carta2 = new CartaMonstruo(3,1000,2000,jugador);
		ZonaDeCartasMonstruos zona = new ZonaDeCartasMonstruos();
		zona.agregarCarta(carta1, 1);
		zona.agregarCarta(carta2, 1);
	}
	
	@Test(expected = PosicionDeZonaFueraDeRangoExcepcion.class) 
	public void test04agregoCartaEnPosicionSeisDaExceptionFueraDeRango() {
		Jugador jugador = new Jugador();
		CartaMonstruo carta1 = new CartaMonstruo(3,1000,2000,jugador);
		ZonaDeCartasMonstruos zona = new ZonaDeCartasMonstruos();
		zona.agregarCarta(carta1, 6);
	}
	
}