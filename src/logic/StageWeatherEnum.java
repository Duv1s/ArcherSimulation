package logic;

/**
 * Enumerado que permite definir el tipo de escenario en que se llevar a cabo
 * cada partida.
 * 
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public enum StageWeatherEnum {
	/**
	 * Tipos de escensarios que ser tomados como características exógenas de la
	 * simulación.
	 */
	RAIN("lluvia"), WIND("Viento"), NORMAL("Normal");

	String genre;

	StageWeatherEnum(String genre) {
		this.genre = genre;
	}
}
