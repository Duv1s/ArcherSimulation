package logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public class GestorShot {
	private Random randomAngle;
	private Random randomVelocity;
	private double auxDistance;

	/**
	 * construtor de la clase
	 */
	public GestorShot() {
		this.randomAngle = new Random();
		this.randomVelocity = new Random();
	}

	/**
	 * mientras la resistencia de un jugador sea mayor o igual a 4 se agrega un
	 * nuevo tiro a la lista de tiros de ese jugador, en cada tiro se calcula un
	 * angulo y velocidad, para calcular luego la distancia del tiro
	 * 
	 * @param listPerson
	 */
	public void shotAttributesPerson(ArrayList<Archer> listPerson) {
		for (Archer person : listPerson) {
			while (person.getResistance() >= 4) {
				person.getListShot().add(new Shot(calculateAngle(), calculateVelocity()));
				person.setResistance(person.getResistance() - 4);
			}
			for (int i = 0; i < person.getListShot().size(); i++) {
				auxDistance = calculateDistance(person.getListShot().get(i).getVelocity(),
						person.getListShot().get(i).getAngle());
				person.getListShot().get(i).setDistance(auxDistance);

			}
			person.setResistance(person.getResistenceOriginal());
			person.setPrecision(person.getPrecisionOriginal());
		}
	}

	/**
	 * permite calcilar la distancia, formula de el lanzzamineto parabolico
	 * 
	 * @param velocity
	 * @param angle
	 * @return
	 */
	public double calculateDistance(int velocity, int angle) {
		return (Math.pow(velocity, 2) * Math.sin(Math.toRadians(2 * angle)) / 9.8);
	}

	/**
	 * calcula un angulo al azar entre 26-34
	 * 
	 * @return
	 */
	public int calculateAngle() {
		return randomAngle.nextInt(9) + 26;
	}

	/**
	 * calcula una velocidad al azar entre 90-110
	 * 
	 * @return
	 */
	public int calculateVelocity() {
		return randomVelocity.nextInt(21) + 90;
	}
	
	//Creación de los métodos setters y getters
	/**
	 * @return Método que obtiene el valor de la propiedad randomAngle
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
	 * @return Método que obtiene el valor de la propiedad randomVelocity
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
	 * @return Método que obtiene el valor de la propiedad auxDistance
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
