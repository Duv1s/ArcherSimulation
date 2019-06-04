package logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que permite asignar los valores de las habilidades de los arqueros
 * según los requerimientos planteados.
 * 
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public class ManagerArcher {
	// Variables para la generaación de números pseudo-aleatorios.
	private Random randomPrecision;
	private Random randomReistence;
	private Random randomLuck;
	private Random randomAux;

	// Variables para definir la precisión de los arqueros
	private int sumPresicionOfMen;
	private int sumPrecisionOfWomen;
	private int numberOfMenPrecision;
	private int numberOfWomenPresicion;

	// Variables para definir la resistencia de los arqueros.
	private int sumResistenceMen;
	private int sumResistenceWomen;
	private int numberOfMenResistence;
	private int numberOfWomenResistence;

	/**
	 * Constructor de la clase Manager Archer Se encarga de inicializar las
	 * variables para la generación de números pseudo-aleatorios.
	 */
	public ManagerArcher() {
		this.randomPrecision = new Random();
		this.randomReistence = new Random();
		this.randomLuck = new Random();
		this.randomAux = new Random();
	}

	/**
	 ** Método que asigna la Resistencia de los arqueros teniendo en cuenta que los
	 *  arqueros siempre serán mas resistentes que las arqueras
	 *  También asigna un valor de suerte a los arqueros.
	 * @param listArcher
	 */
	public void archerDefineResistenceAndLuck(ArrayList<Archer> listArcher) {
		while (!isValidateResistence(listArcher)) {
			int aux = randomAux.nextInt(2);
			for (Archer person : listArcher) {
				person.setLuck(archerLuck());
				person.setResistance(archerResistance(aux));
				person.setResistenceOriginal(person.getResistance());
			}
		}
		System.out.println("Resistencia Promedio hombre: " + sumResistenceMen / numberOfMenResistence
				+ " - Resistencia Promedio mujer: " + sumResistenceWomen / numberOfWomenResistence);
	}

	/**
	 * Método que asigna la presición de los arqueros teniendo en cuenta que las
	 * arqueras siempre serán mas precisas que los arqueros
	 * 
	 * @param listArcher
	 */
	public void archerDefinePrecision(ArrayList<Archer> listArcher) {
		while (!isValidatePrecision(listArcher)) {
			int aux = randomAux.nextInt(2);
			for (Archer archer : listArcher) {
				archer.setPrecision(archerPrecision(aux));
				archer.setPrecisionOriginal(archer.getPrecision());
			}
		}
		System.out.println("Preicisión Promedio hombre: " + sumPresicionOfMen / numberOfMenPrecision
				+ " - Presición Promedio mujer: " + sumPrecisionOfWomen / numberOfWomenPresicion);
	}

	/**
	 * Método que valida la resistencia de los arqueros de modo que los arqueros
	 * siempre posean mayor Resistencia que las arqueras
	 * 
	 * @param listArcher
	 * @return
	 */
	public boolean isValidateResistence(ArrayList<Archer> listArcher) {
		sumResistenceMen = 0;
		sumResistenceWomen = 0;
		numberOfMenResistence = 0;
		numberOfWomenResistence = 0;
		for (Archer person : listArcher) {
			if (person.getGender() == GenderEnum.MALE) {
				sumResistenceMen += person.getResistenceOriginal();
				numberOfMenResistence++;
			} else {
				sumResistenceWomen += person.getResistenceOriginal();
				numberOfWomenResistence++;
			}
		}
		// Condicional que evalua que los arqueros sean en promedio más resistentes que
		// las arqueras
		if ( (sumResistenceMen/numberOfMenResistence) > (sumResistenceWomen/numberOfWomenResistence)) {
			return true;
		}
		return false;
	}

	/**
	 * Método que valida la precisión de los arqueros de modo que las mujeres
	 * siempre posean mayor precisión que los arqueros
	 * 
	 * @param listArcher
	 * @return
	 */
	public boolean isValidatePrecision(ArrayList<Archer> listArcher) {
		sumPresicionOfMen = 0;
		sumPrecisionOfWomen = 0;
		numberOfMenPrecision = 0;
		numberOfWomenPresicion = 0;
		for (Archer person : listArcher) {
			if (person.getGender() == GenderEnum.MALE) {
				sumPresicionOfMen += person.getPrecision();
				numberOfMenPrecision++;
			} else {
				sumPrecisionOfWomen += person.getPrecision();
				numberOfWomenPresicion++;
			}
		}
		// Condicional que evalua que las mujeres sean en promedio más precisas que los
		// hombres
		if ((sumPrecisionOfWomen / numberOfWomenPresicion) > (sumPresicionOfMen / numberOfMenPrecision)) {
			return true;
		}
		return false;
	}

	/**
	 * Método que genera valores entre 50+-4
	 * 
	 * @param aux Si el valor auxiliar es 0 genera valores entre 46-50, si es 1
	 *            genera valores entre 50-54
	 * @return
	 */
	public int archerPrecision(int aux) {
		if (aux == 1) {
			return randomPrecision.nextInt(5) + 50;
		} else {
			return 50 - randomPrecision.nextInt(5);
		}
	}

	/**
	 * Método que genera valores entre 50+-4
	 * 
	 * @param aux Si el valor auxiliar es 0 genera valores entre 46-50, si es 1
	 *            genera valores entre 50-54
	 * @return
	 */
	public int archerResistance(int aux) {
		if (aux == 1) {
			return randomReistence.nextInt(5) + 50;
		} else {
			return 50 - randomReistence.nextInt(5);
		}
	}

	/**
	 * Método que asigna valores entre 1 y 5
	 * @return
	 */
	public double archerLuck() {
		return randomLuck.nextFloat() * (5 - 1) + 1;
	}

	// Creación de los métodos setters y getters
	/**
	 * @return Método que obtiene el valor de la propiedad randomPrecision.
	 */
	public Random getRandomPrecision() {
		return randomPrecision;
	}

	/**
	 * @param Método que asigna el valor de la propiedad randomPrecision.
	 */
	public void setRandomPrecision(Random randomPrecision) {
		this.randomPrecision = randomPrecision;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad randomReistence.
	 */
	public Random getRandomReistence() {
		return randomReistence;
	}

	/**
	 * @param Método que asigna el valor de la propiedad randomReistence.
	 */
	public void setRandomReistence(Random randomReistence) {
		this.randomReistence = randomReistence;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad randomLuck.
	 */
	public Random getRandomLuck() {
		return randomLuck;
	}

	/**
	 * @param Método que asigna el valor de la propiedad randomLuck.
	 */
	public void setRandomLuck(Random randomLuck) {
		this.randomLuck = randomLuck;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad randomAux.
	 */
	public Random getRandomAux() {
		return randomAux;
	}

	/**
	 * @param Método que asigna el valor de la propiedad randomAux.
	 */
	public void setRandomAux(Random randomAux) {
		this.randomAux = randomAux;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad malePrecision.
	 */
	public int getMalePrecision() {
		return sumPresicionOfMen;
	}

	/**
	 * @param Método que asigna el valor de la propiedad malePrecision.
	 */
	public void setMalePrecision(int malePrecision) {
		this.sumPresicionOfMen = malePrecision;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad femalePrecision.
	 */
	public int getFemalePrecision() {
		return sumPrecisionOfWomen;
	}

	/**
	 * @param Método que asigna el valor de la propiedad femalePrecision.
	 */
	public void setFemalePrecision(int femalePrecision) {
		this.sumPrecisionOfWomen = femalePrecision;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad countMalePrecision.
	 */
	public int getCountMalePrecision() {
		return numberOfMenPrecision;
	}

	/**
	 * @param Método que asigna el valor de la propiedad countMalePrecision.
	 */
	public void setCountMalePrecision(int countMalePrecision) {
		this.numberOfMenPrecision = countMalePrecision;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad countFemalePrecision.
	 */
	public int getCountFemalePrecision() {
		return numberOfWomenPresicion;
	}

	/**
	 * @param Método que asigna el valor de la propiedad countFemalePrecision.
	 */
	public void setCountFemalePrecision(int countFemalePrecision) {
		this.numberOfWomenPresicion = countFemalePrecision;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad maleResistence.
	 */
	public int getMaleResistence() {
		return sumResistenceMen;
	}

	/**
	 * @param Método que asigna el valor de la propiedad maleResistence.
	 */
	public void setMaleResistence(int maleResistence) {
		this.sumResistenceMen = maleResistence;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad femaleResistence.
	 */
	public int getFemaleResistence() {
		return sumResistenceWomen;
	}

	/**
	 * @param Método que asigna el valor de la propiedad femaleResistence.
	 */
	public void setFemaleResistence(int femaleResistence) {
		this.sumResistenceWomen = femaleResistence;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad countMaleResistence.
	 */
	public int getCountMaleResistence() {
		return numberOfMenResistence;
	}

	/**
	 * @param Método que asigna el valor de la propiedad countMaleResistence.
	 */
	public void setCountMaleResistence(int countMaleResistence) {
		this.numberOfMenResistence = countMaleResistence;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad countFemaleResistence.
	 */
	public int getCountFemaleResistence() {
		return numberOfWomenResistence;
	}

	/**
	 * @param Método que asigna el valor de la propiedad countFemaleResistence.
	 */
	public void setCountFemaleResistence(int countFemaleResistence) {
		this.numberOfWomenResistence = countFemaleResistence;
	}
}