package fiuba.algo3.Estados;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class MonstruoPosicionArriba extends PosicionArriba implements MonstruoPosicionable {
	
	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada){
		Accionable accionAtacante = cartaAtacante.obtenerAccion(); 
		accionAtacante.atacar(cartaAtacante, cartaAtacada);
	}
	
	public void defender(CartaMonstruo cartaAtacante, Accionable posicion, Efecto efecto, CartaMonstruo cartaActual) {
		posicion.defender(cartaAtacante,cartaActual);
	}

	@Override
	public void atacarJugador(CartaMonstruo cartaAtacante, Jugador otro) {
		Accionable accionAtacante = cartaAtacante.obtenerAccion();
		accionAtacante.atacarJugador(cartaAtacante, otro);
	}

}
