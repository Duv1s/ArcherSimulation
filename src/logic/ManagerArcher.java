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
	private int malePrecision;
	private int femalePrecision;
	private int countMalePrecision;
	private int countFemalePrecision;

	// Variables para definir la resistencia de los arqueros.
	private int maleResistence;
	private int femaleResistence;
	private int countMaleResistence;
	private int countFemaleResistence;

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
	 * recorre una lista de personas y a cada una le agrega una valor de suerte,
	 * para todas las personas de esta lista tendra el mismo rango, resistencia y
	 * resistencia original, tiene un ciclo y termina siempre y cuando la
	 * resistencia del hombre sea mayor que el de la mujer
	 *
	 * @param listPerson
	 */
	public void archerAttributesR(ArrayList<Archer> listPerson) {
		while (!isValidateResistence(listPerson)) {
			int aux = randomAux.nextInt(2);
			for (Archer person : listPerson) {
				person.setLuck(archerLuck());
				person.setResistance(archerReisstence(aux));
				person.setResistenceOriginal(person.getResistance());
			}
		}
		System.out.println("Resistencia Promedio hombre: " + maleResistence / countMaleResistence
				+ " - Resistencia Promedio mujer: " + femaleResistence / countFemaleResistence);
	}


	/**
	 * Método que asigna la presición de los arqueros teniendo en cuenta que las
	 * arqueras siempre serán más precisas que los arqueros
	 * 
	 * @param listPerson
	 */
	public void archerDefinePrecision(ArrayList<Archer> listPerson) {
		while (!isValidatePrecision(listPerson)) {
			int aux = randomAux.nextInt(2);
			for (Archer person : listPerson) {
				person.setPrecision(archerPrecision(aux));
				person.setPrecisionOriginal(person.getPrecision());
			}
		}
		System.out.println("PreicisiÃ³n Promedio hombre: " + malePrecision / countMalePrecision
				+ " - PresiciÃ³n Promedio mujer: " + femalePrecision / countFemalePrecision);
	}

	/**
	 * si los hombres tienen mas resistencia se vuelve verdadera la condicion, si no
	 * se vuelve falsa
	 * 
	 * @param listPerson
	 * @return
	 */
	public boolean isValidateResistence(ArrayList<Archer> listPerson) {
		maleResistence = 0;
		femaleResistence = 0;
		countMaleResistence = 0;
		countFemaleResistence = 0;
		for (Archer person : listPerson) {
			if (person.getGender() == GenderEnum.MALE) {
				maleResistence += person.getResistenceOriginal();
				countMaleResistence++;
			} else {
				femaleResistence += person.getResistenceOriginal();
				countFemaleResistence++;
			}
		}
		if (maleResistence / countMaleResistence > femaleResistence / countFemaleResistence) {
			return true;
		}
		return false;
	}

	/**
	 * si las mujeres tienen mas precision se vuelve verdadera la condicion, si no
	 * se vuelve falsa
	 * 
	 * @param listPerson
	 * @return
	 */
	public boolean isValidatePrecision(ArrayList<Archer> listPerson) {
		malePrecision = 0;
		femalePrecision = 0;
		countMalePrecision = 0;
		countFemalePrecision = 0;
		for (Archer person : listPerson) {
			if (person.getGender() == GenderEnum.MALE) {
				malePrecision += person.getPrecision();
				countMalePrecision++;
			} else {
				femalePrecision += person.getPrecision();
				countFemalePrecision++;
			}
		}
		if (femalePrecision / countFemalePrecision > malePrecision / countMalePrecision) {
			return true;
		}
		return false;
	}

	/**
	 * tiene un aleatorio entre 1 y 0 si es uno el rango de valores va a estar entre
	 * 50 -54 si es cero el rango de valores cera 46-50
	 * 
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
	 * tiene un aleatorio entre 1 y 0 si es uno el rango de valores va a estar entre
	 * 50 -54 si es cero el rango de valores cera 46-50
	 *
	 * @return
	 */
	public int archerReisstence(int aux) {
		if (aux == 1) {
			return randomReistence.nextInt(5) + 50;
		} else {
			return 50 - randomReistence.nextInt(5);
		}
	}

	/**
	 * permite calcular la suerte entre 1-5
	 *
	 * @return
	 */
	public double archerLuck() {
		return randomLuck.nextFloat() * (5 - 1) + 1;
	}

	//Creación de los métodos setters y getters
	/**
	 * @return Método que obtiene el valor de la propiedad randomPrecision
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
	 * @return Método que obtiene el valor de la propiedad randomReistence
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
	 * @return Método que obtiene el valor de la propiedad randomLuck
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
	 * @return Método que obtiene el valor de la propiedad randomAux
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
	 * @return Método que obtiene el valor de la propiedad malePrecision
	 */
	public int getMalePrecision() {
		return malePrecision;
	}

	/**
	 * @param Método que asigna el valor de la propiedad malePrecision.
	 */
	public void setMalePrecision(int malePrecision) {
		this.malePrecision = malePrecision;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad femalePrecision
	 */
	public int getFemalePrecision() {
		return femalePrecision;
	}

	/**
	 * @param Método que asigna el valor de la propiedad femalePrecision.
	 */
	public void setFemalePrecision(int femalePrecision) {
		this.femalePrecision = femalePrecision;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad countMalePrecision
	 */
	public int getCountMalePrecision() {
		return countMalePrecision;
	}

	/**
	 * @param Método que asigna el valor de la propiedad countMalePrecision.
	 */
	public void setCountMalePrecision(int countMalePrecision) {
		this.countMalePrecision = countMalePrecision;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad countFemalePrecision
	 */
	public int getCountFemalePrecision() {
		return countFemalePrecision;
	}

	/**
	 * @param Método que asigna el valor de la propiedad countFemalePrecision.
	 */
	public void setCountFemalePrecision(int countFemalePrecision) {
		this.countFemalePrecision = countFemalePrecision;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad maleResistence
	 */
	public int getMaleResistence() {
		return maleResistence;
	}

	/**
	 * @param Método que asigna el valor de la propiedad maleResistence.
	 */
	public void setMaleResistence(int maleResistence) {
		this.maleResistence = maleResistence;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad femaleResistence
	 */
	public int getFemaleResistence() {
		return femaleResistence;
	}

	/**
	 * @param Método que asigna el valor de la propiedad femaleResistence.
	 */
	public void setFemaleResistence(int femaleResistence) {
		this.femaleResistence = femaleResistence;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad countMaleResistence
	 */
	public int getCountMaleResistence() {
		return countMaleResistence;
	}

	/**
	 * @param Método que asigna el valor de la propiedad countMaleResistence.
	 */
	public void setCountMaleResistence(int countMaleResistence) {
		this.countMaleResistence = countMaleResistence;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad countFemaleResistence
	 */
	public int getCountFemaleResistence() {
		return countFemaleResistence;
	}

	/**
	 * @param Método que asigna el valor de la propiedad countFemaleResistence.
	 */
	public void setCountFemaleResistence(int countFemaleResistence) {
		this.countFemaleResistence = countFemaleResistence;
	}
}
