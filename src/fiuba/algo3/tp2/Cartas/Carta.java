package fiuba.algo3.tp2.Cartas ;

import fiuba.algo3.Estados.Posicionable;

public abstract class Carta {
	
	protected TieneUnEfecto efecto;
	protected Posicionable estado;
	
	public abstract void activarEfecto();
	public abstract void colocarBocaAbajo();
	public abstract void colocarBocaArriba();
	public abstract boolean estaBocaAbajo() ;
	public abstract boolean estaBocaArriba();
	public abstract boolean estaEnElCampo();
	public abstract void destruirCarta();
	public abstract boolean estaDestruida();
	

	public Posicionable obtenerEstado() {
		return this.estado ;
	}

}
