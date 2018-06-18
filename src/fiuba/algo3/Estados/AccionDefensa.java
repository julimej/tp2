package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.CartaEnPosicionDefensaException;

public class AccionDefensa implements Accionable {

	private int puntosDeDefensa;
	
	public AccionDefensa (int puntosDefensa) {
		this.puntosDeDefensa = puntosDefensa;
	}
	
	public void atacarMonstruo(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		throw new CartaEnPosicionDefensaException();
	}

	public boolean estaEnPosicionAtaque() {
		// TODO Auto-generated method stub
		return false;
	}

	public void recibirAtaque(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante, CartaMonstruo cartaActual) {
		// TODO Auto-generated method stub
		int diferenciaAtaque = this.puntosDeDefensa - puntosDeAtaqueRecibidos;
		if(diferenciaAtaque > 0) {
			return;
		} else if ( diferenciaAtaque <= 0) {
			cartaActual.destruirCarta();
		}
	}


}
