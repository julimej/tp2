package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.Cartas.CartaCampo;
import fiuba.algo3.tp2.Excepciones.PosicionDeLaZonaOcupadaException;
import fiuba.algo3.tp2.Excepciones.PosicionDeZonaFueraDeRangoExcepcion;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasDeCampo;

public class ZonaDeCartasDeCampoTest {

	@Test
	public void test01agregoUnaCartaALaZonaYVerificoQueSeAgrego() {
		CartaCampo carta = new CartaCampo();
		ZonaDeCartasDeCampo zona = new ZonaDeCartasDeCampo();
		zona.agregarCarta(carta, 1);
		assertTrue(zona.obtenerCartas().contains(carta));
	}
	
	@Test(expected = PosicionDeLaZonaOcupadaException.class) 
	public void test02agregoCartaEnPosicionOcupadaDaExcepcion() {
		CartaCampo carta1 = new CartaCampo();
		CartaCampo carta2 = new CartaCampo();
		ZonaDeCartasDeCampo zona = new ZonaDeCartasDeCampo();
		zona.agregarCarta(carta1, 1);
		zona.agregarCarta(carta2, 1);
	}
	
	@Test(expected = PosicionDeZonaFueraDeRangoExcepcion.class) 
	public void test03agregoCartaEnPosicionSeisDaExceptionFueraDeRango() {
		CartaCampo carta = new CartaCampo();
		ZonaDeCartasDeCampo zona = new ZonaDeCartasDeCampo();
		zona.agregarCarta(carta, 2);
	}
	
	@Test
	public void test04agregarCartaYEliminarCarta() {
		CartaCampo carta = new CartaCampo();
		ZonaDeCartasDeCampo zona = new ZonaDeCartasDeCampo();
		zona.agregarCarta(carta, 1);
		zona.eliminarCarta(carta);
		assertFalse(zona.obtenerCartas().contains(carta));
	}
	
	@Test
	public void test05agregarCartaEliminarCartaYAgregarNuevamente() {
		CartaCampo carta = new CartaCampo();
		ZonaDeCartasDeCampo zona = new ZonaDeCartasDeCampo();
		zona.agregarCarta(carta, 1);
		zona.eliminarCarta(carta);
		zona.agregarCarta(carta, 1);
		assertTrue(zona.obtenerCartas().contains(carta));
	}
}
