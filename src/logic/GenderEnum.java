package logic;

/**
 * Enumerado que permite definir los g�neros de cada arquero.
 * @author Duvis Alejandro G�mez Neira
 * @version 1.0
 */
public enum GenderEnum {
	MALE("Hombre"), FEMALE("Mujer");

	String gender;

	GenderEnum(String gender) {
		this.gender = gender;
	}

}
