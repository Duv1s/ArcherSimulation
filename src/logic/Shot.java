package logic;

/**
 * Clase que permite defininir la infomración del disparo de cada flecha
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public class Shot {
	private int angle;
	private double distance;
	private int velocity;

	/**
	 * Método constructor de la clase Disparo
	 * 
	 * @param angle    Ángulo de disparo de la flecha.
	 * @param velocity Velocidad de disparo de la flecha.
	 */
	public Shot(int angle, int velocity) {
		this.angle = angle;
		this.velocity = velocity;
	}

	//Creación de los métodos setters y getters
	/**
	 * @return  Método que obtiene el valor de la propiedad angle.
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * @param Método que asigna el valor de la propiedad angle.
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad distance.
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param Método que asigna el valor de la propiedad distance.
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad velocity.
	 */
	public int getVelocity() {
		return velocity;
	}

	/**
	 * @param Método que asigna el valor de la propiedad velocity.
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
}