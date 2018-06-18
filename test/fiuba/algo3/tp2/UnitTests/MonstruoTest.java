package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.Cartas.CartaFactory;
//import fiuba.algo3.tp2.Cartas.AgujeroNegro;
//import fiuba.algo3.tp2.Cartas.CartaMagica;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.CartaNoSeEncuentraEnZona;
import fiuba.algo3.Estados.*;
import fiuba.algo3.tp2.Jugador;

public class MonstruoTest {
	
	@Test
	public void test01colocarCartaMonstruoPosicionAtaque() {
		Jugador jugador = new Jugador();
		CartaMonstruo carta = new CartaMonstruo(4,1000,100,jugador); //estrellas,ataque,def
		carta.colocarEnAccionDeAtaque();
		Accionable accionMonstruo = carta.obtenerAccion();
		assertEquals(accionMonstruo.getClass(), AccionAtaque.class);
	}
	
	
	@Test
	public void test02colocarCartaMonstruoPosicionDefensa() {
		Jugador jugador = new Jugador();
		CartaMonstruo carta = new CartaMonstruo(4,1000,100,jugador);
		carta.colocarEnAccionDeDefensa();
		Accionable accionMonstruo = carta.obtenerAccion();
		assertEquals(accionMonstruo.getClass(), AccionDefensa.class); 
	}
	
	
	@Test
	public void test03monstruoConMayorAtaqueAtacaAOtroConMenorAtaqueAmbosEnPosicionDeAtaqueYQuitaPuntosDeVidaAlOponente(){
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacado);
		carta1.colocarEnAccionDeAtaque();
		CartaMonstruo carta2 = new CartaMonstruo(4,1800,100,atacante);
		carta2.colocarEnAccionDeAtaque();
		carta2.atacar(carta1);
		assertEquals(7200,atacado.obtenerPuntosDeVida());
	}
	
	
	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test04monstruoConMayorAtaqueAtacaAOtroConMenorAtaqueAmbosEnPosicionDeAtaqueYLoDestruye(){
		CartaMonstruo carta1 = CartaFactory.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = CartaFactory.crearCartaMonstruoGenerica(2000, 1000);
		carta1.colocarEnAccionDeAtaque();
		carta2.colocarEnAccionDeAtaque();
		// Ataca y lo destrulle.
		carta2.atacar(carta1); 
		// Ataca y lanza excepcion.
		carta2.atacar(carta1);
		
	}
	
	
	@Test
	public void test05monstruoConMenorAtaqueAtacaAOtroConMayorAtaqueAmbosEnPosicionDeAtaqueYSuJugadorPierdePuntosDeVida(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1800,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertEquals(7200,atacante.obtenerPuntosDeVida());
	}
	
	@Test
	public void test06monstruoConMenorAtaqueAtacaAOtroConMayorAtaqueAmbosEnPosicionDeAtaqueYSeDestruye(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1800,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertTrue(carta1.estaDestruida());
	}
	
	
	@Test
	public void test07monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaqueElPrimerMonstruoSeDestruye(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertTrue(carta1.estaDestruida()); // este metodo no esta bien
	}
	
	
	@Test
	public void test08monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaqueElSegundoSeTestruye(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertTrue(carta2.estaDestruida());
	}
	
	
	@Test
	public void test09monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaqueAtacanteNoPierdeVida(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertEquals(8000,atacante.obtenerPuntosDeVida());
	}
	
	
	@Test
	public void test10monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaqueAtacadoNoPierdeVida(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertEquals(8000,defensor.obtenerPuntosDeVida());
	}
	
	
	@Test
	public void test11monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMayorDefensaNoDestruyeAlDefensor(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnAccionDeDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertFalse(carta2.estaDestruida());
		
	}
	
	@Test
	public void test12monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMayorDefensaNoQuitaPuntosDeVidaAlDefensor(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnAccionDeDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertEquals(8000,defensor.obtenerPuntosDeVida());
		
	}
	
	@Test
	public void test13monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMenorDefensaYLoDestruye(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnAccionDeDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1800,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertTrue(carta2.estaDestruida());
	}
	
	@Test
	public void test14monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMenorDefensaYNoQuitaPuntosDeVidaAlDefensor(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnAccionDeDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1800,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertEquals(8000,defensor.obtenerPuntosDeVida());
	}
	
	
	
	
//	@Test
//	public void test15SacrificioDeUnMonstruoSacrificaElMonstruo() {
//		Jugador jugador = new Jugador();
//		CartaMonstruo monstruoSacrificado = new CartaMonstruo(4,1000,1200,jugador);
//		jugador.colocarBocaArriba(monstruoSacrificado, 0);
//		
//		CartaMonstruo monstruo6Estrellas = new CartaMonstruo(6,1000,1200,jugador);
//		jugador.colocarBocaArriba(monstruo6Estrellas, 0);
//		
//		assertTrue(monstruoSacrificado.estaDestruida());
//		
//	}
	
	
	@Test
	public void test16SacrificioDeUnMonstruoColocaElNuevoMonstruoEnElCampo() {
		Jugador jugador = new Jugador();
		CartaMonstruo monstruoSacrificado = new CartaMonstruo(4,1000,1200,jugador);
		jugador.colocarBocaArriba(monstruoSacrificado, 0);
		
		CartaMonstruo monstruo6Estrellas = new CartaMonstruo(6,1000,1200,jugador);
		jugador.colocarBocaArriba(monstruo6Estrellas, 0);
		
		assertTrue( monstruo6Estrellas.estaEnElCampo());
		
	}

}
