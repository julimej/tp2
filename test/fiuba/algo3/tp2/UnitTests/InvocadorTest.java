package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.Efectos.EfectoVacio;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class InvocadorTest {

	@Test
	public void test01CreacionInvocadorBasico() {
		Jugador jugador = new Jugador();
		EfectoVacio efecto = new EfectoVacio();
		CartaMonstruo carta = new CartaMonstruo("Nombre", jugador, efecto, 1, 1000, 1000);
		
		assertTrue(carta.invocacionValida(new ArrayList<CartaMonstruo>()));
	}
	
	@Test
	public void test02CreacionInvocadorDragonDefinitivo() {
		Jugador jugador = new Jugador();
		EfectoVacio efecto = new EfectoVacio();
		
		CartaMonstruo carta = new CartaMonstruo("Dragon Definitivo De Ojos Azules", jugador, efecto, 8, 4500, 3800);
		CartaMonstruo dragon1 = new CartaMonstruo("Dragon Blanco De Ojos Azules", jugador, efecto, 7, 3000, 2500);
		CartaMonstruo dragon2 = new CartaMonstruo("Dragon Blanco De Ojos Azules", jugador, efecto, 7, 3000, 2500);
		CartaMonstruo dragon3 = new CartaMonstruo("Dragon Blanco De Ojos Azules", jugador, efecto, 7, 3000, 2500);
		
		ArrayList<CartaMonstruo> sacrificios = new ArrayList<CartaMonstruo>();
		sacrificios.add(dragon1);
		sacrificios.add(dragon2);
		sacrificios.add(dragon3);
		
		assertTrue(carta.invocacionValida(sacrificios));
	}

}
