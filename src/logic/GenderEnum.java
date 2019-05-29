package logic;

/**
 * Enumerado que permite definir los géneros de cada arquero.
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public enum GenderEnum {
	MALE("Hombre"), FEMALE("Mujer");

	String gender;

	GenderEnum(String gender) {
		this.gender = gender;
	}

}
