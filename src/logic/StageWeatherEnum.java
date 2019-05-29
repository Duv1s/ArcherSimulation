package logic;

/**
 * Enumerado que permite definir el tipo de escenario en que se llevar� cabo
 * cada partida.
 * 
 * @author Duvis Alejandro G�mez Neira
 * @version 1.0
 */
public enum StageWeatherEnum {
	/**
	 * Tipos de escensarios que ser�n tomados como caracter�sticas ex�genas de la
	 * simulaci�n.
	 */
	RAIN("lluvia"), WIND("Viento"), NORMAL("Normal"), RAINANDWIND("Lluvia y viento");

	String genre;

	StageWeatherEnum(String genre) {
		this.genre = genre;
	}
}
