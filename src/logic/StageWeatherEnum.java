package logic;

/**
 * Enumerado que permite definir el tipo de escenario en que se llevará cabo
 * cada partida.
 * 
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public enum StageWeatherEnum {
	/**
	 * Tipos de escensarios que serán tomados como características exógenas de la
	 * simulación.
	 */
	RAIN("lluvia"), WIND("Viento"), NORMAL("Normal"), RAINANDWIND("Lluvia y viento");

	String genre;

	StageWeatherEnum(String genre) {
		this.genre = genre;
	}
}
