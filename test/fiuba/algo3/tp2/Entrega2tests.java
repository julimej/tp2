package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.tp2.Cartas.CartaCampo;
import fiuba.algo3.tp2.Cartas.CartaFactory;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class Entrega2tests {
	
	@Test
	public void test01colocarCartaMagicaWastelandEnCampoYVerificarEfecto() {
		Jugador atacante = new Jugador();
		CartaFactory cartaFactoryAtacante = new CartaFactory(atacante);
		Jugador atacado = new Jugador();
		
		CartaFactory cartaFactoryAtacado = new CartaFactory(atacado);
		
		CartaMonstruo cA1 = cartaFactoryAtacante.crearCartaMonstruoGenerica(300, 500);
		atacante.colocarCartaEnZona(cA1, 0, new ArrayList<CartaMonstruo>());
		
		CartaMonstruo c1 = cartaFactoryAtacado.crearCartaMonstruoGenerica(500, 250);
		atacado.colocarCartaEnZona(c1, 0, new ArrayList<CartaMonstruo>());
		c1.colocarEnAccionDeDefensa();
		
		int cartaAtacantePuntosDeAtaque = cA1.obtenerPuntosAtaque();
		int cartaAtacadaPuntosDeDefensa = c1.obtenerPuntosDefensa();
		
		CartaCampo wasteland = cartaFactoryAtacante.crearCartaWasteland();
		atacante.colocarCartaEnZona(wasteland, atacado);
		
		cA1.atacar(c1);
		assertTrue(cartaAtacantePuntosDeAtaque + 200 == cA1.obtenerPuntosAtaque());
		assertTrue(cartaAtacadaPuntosDeDefensa + 300 == c1.obtenerPuntosDefensa());
		assertFalse(atacado.obtenerCartasEnCementerio().contains(c1));	
	}
	
	@Test
	public void test02colocarCartaMagicaSogenEnCampoYVerificarEfecto() {
		Jugador atacante = new Jugador();
		CartaFactory cartaFactoryAtacante = new CartaFactory(atacante);
		Jugador atacado = new Jugador();
		
		CartaFactory cartaFactoryAtacado = new CartaFactory(atacado);
		
		CartaMonstruo cA1 = cartaFactoryAtacante.crearCartaMonstruoGenerica(300, 100);
		atacante.colocarCartaEnZona(cA1, 0, new ArrayList<CartaMonstruo>());
		cA1.colocarEnAccionDeDefensa();
		
		CartaMonstruo c1 = cartaFactoryAtacado.crearCartaMonstruoGenerica(300, 250);
		atacado.colocarCartaEnZona(c1, 0, new ArrayList<CartaMonstruo>());
		
		
		int cartaAtacantePuntosDeDefensa = cA1.obtenerPuntosDefensa();
		int cartaAtacadaPuntosDeAtaque = c1.obtenerPuntosAtaque();
		
		CartaCampo sogen = cartaFactoryAtacante.crearCartaSogen();
		atacante.colocarCartaEnZona(sogen, atacado);
		
		c1.atacar(cA1);
		assertTrue(cartaAtacantePuntosDeDefensa + 500 == cA1.obtenerPuntosDefensa());
		assertTrue(cartaAtacadaPuntosDeAtaque + 200 == c1.obtenerPuntosAtaque());
		assertFalse(atacado.obtenerCartasEnCementerio().contains(c1));
	}

	@Test
	public void test03activarCartaMagicaOllaDeLaCodiciaYVerificarEfecto() {
		
	}
	
	@Test
	public void test04activarCartaMagicaFisuraYVerificarEfecto() {
		
	}

	@Test
	public void test05colocarJinzo7EnElCampoVerificarAtaqueALosPuntosDeVidaDirecto() {
		
	}

	@Test
	public void test06invocarAlDragonDefinitivoDeOjosAzulesSacrificando3DragonesBlancos() {
		
	}
	
	@Test
	public void test07colocarInsectoComeHombresEnDefensaBocaAbajoYProbarEfectoEnBatalla() {
		
	}

	@Test
	public void test08colocarCartaTrampaCilindroMagicoDelLadoDelCampoYAtacarConElMonstruoEnemigoVerificandoEfecto() {
		
	}

	@Test
	public void test09colocarCartaTrampaReinforcementsYProbarEfectoEnBatalla() {
		
	}

	@Test
	public void test10extraerTodasLasCartasDelMazoYVerificarPartidaTerminada() {
		
	}

	@Test
	public void test11colocarPartesDeExodiaEnLaManoYVerificarPartidaTerminada() {
		
	}

}
