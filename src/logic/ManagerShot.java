package logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que permite calcular la distancia de una flecha a partir de la formula
 * del movimiento parabólico.
 * 
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public class ManagerShot {
	private Random randomAngle;
	private Random randomVelocity;
	private double auxDistance;

	/**
	 * Construtor de la clase de Gestion de Disparos.
	 */
	public ManagerShot() {
		this.randomAngle = new Random();
		this.randomVelocity = new Random();
	}

	/**
	 * Método que permite realizar un disparo a una lista de arqueros siempre y
	 * cuando su resistencia sea superior o igual a 4
	 * 
	 * @param listArcher
	 */
	public void makeShot(ArrayList<Archer> listArcher) {
		for (Archer archer : listArcher) {
			// Mientras un arquero tenga resistencia superior a 4 permite agregar un
			// disparo a la lista de disparos de cada arquero y disminuye su resistencia
			while (archer.getResistance() >= 4) {
				archer.getListShot().add(new Shot(calculateAngle(), calculateVelocity()));
				archer.setResistance(archer.getResistance() - 4);
			}

			// Ciclo que permite agregar el valor de la distancia de cada lanzamiento y
			// agregarlo a la lsita de disparos de cada arquero.
			for (int i = 0; i < archer.getListShot().size(); i++) {
				auxDistance = calculateDistance(archer.getListShot().get(i).getVelocity(),
						archer.getListShot().get(i).getAngle());
				archer.getListShot().get(i).setDistance(auxDistance);

			}
			archer.setResistance(archer.getResistenceOriginal());
			archer.setPrecision(archer.getPrecisionOriginal());
		}
	}

	/**
	 * Método que permite calcular una distancia teniendo en cuenta la ecuación del movimietno parabólico.
	 * @param velocity Velocidad inicial del objeto
	 * @param angle Ángulo del objeto.
	 * @return
	 */
	public double calculateDistance(int velocity, int angle) {
		//Ecuación --> ((VelocidadInicial)^2 * Sen(2*Theta))/Gravedad
		return (Math.pow(velocity, 2) * Math.sin(Math.toRadians(2 * angle)) / 9.8);
	}

	/**
	 * Método que permite generar un valor pseudo-aleatorio entre 26-34
	 * @return
	 */
	public int calculateAngle() {
		return randomAngle.nextInt(9) + 26;
	}

	/**
	 * Método que permite generar un valor pseudo-aleatorio entre 90-110
	 * @return
	 */
	public int calculateVelocity() {
		return randomVelocity.nextInt(21) + 90;
	}

	// Creación de los métodos setters y getters

	/**
	 * @return Método que obtiene el valor de la propiedad randomAngle.
	 */
	public Random getRandomAngle() {
		return randomAngle;
	}

	/**
	 * @param Método que asigna el valor de la propiedad randomAngle.
	 */
	public void setRandomAngle(Random randomAngle) {
		this.randomAngle = randomAngle;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad randomVelocity.
	 */
	public Random getRandomVelocity() {
		return randomVelocity;
	}

	/**
	 * @param Método que asigna el valor de la propiedad randomVelocity.
	 */
	public void setRandomVelocity(Random randomVelocity) {
		this.randomVelocity = randomVelocity;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad auxDistance.
	 */
	public double getAuxDistance() {
		return auxDistance;
	}

	/**
	 * @param Método que asigna el valor de la propiedad auxDistance.
	 */
	public void setAuxDistance(double auxDistance) {
		this.auxDistance = auxDistance;
	}
}
