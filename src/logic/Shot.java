package logic;

/**
 * Clase que permite defininir la infomraci�n del disparo de cada flecha
 * @author Duvis Alejandro G�mez Neira
 * @version 1.0
 */
public class Shot {
	private int angle;
	private double distance;
	private int velocity;

	/**
	 * M�todo constructor de la clase arquero
	 * 
	 * @param angle    �ngulo de disparo de la flecha.
	 * @param velocity Velocidad de disparo de la flecha.
	 */
	public Shot(int angle, int velocity) {
		this.angle = angle;
		this.velocity = velocity;
	}

	//Creaci�n de los m�todos setters y getters
	/**
	 * @return M�todo que obtiene el valor de la propiedad angle
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad angle.
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

	/**
	 * @return M�todo que obtiene el valor de la propiedad distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad distance.
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * @return M�todo que obtiene el valor de la propiedad velocity
	 */
	public int getVelocity() {
		return velocity;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad velocity.
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

}
