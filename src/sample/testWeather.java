package sample;

import java.util.Random;

import logic.StageWeatherEnum;

/**
 * Clase en la que se realizan las pruebas de la generaci�n de los escenarios(clima).
 * @author Duvis Alejandro G�mez Neira
 * @version 1.0
 */
public class testWeather {
	private Random randomClimate = new Random();

	/**
	 * M�todo que realiza la generaci�n de un numero pseudoaleatorio el cu�l determinar� el escenario(clima) en que se jugaran las partidas
	 * @return
	 */
	public StageWeatherEnum climate() {
		int genre = randomClimate.nextInt(4);
		switch (genre) {
		case 0:
			return StageWeatherEnum.RAINANDWIND;
		case 1:
			return StageWeatherEnum.RAIN;
		case 2: 
			return StageWeatherEnum.WIND;
		default:
			return StageWeatherEnum.NORMAL;
		}
	}

	
	public static void main(String[] args) {
		testWeather testAux = new testWeather();
		System.out.println("Escenario generado");
		for (int i = 0; i < 10; i++) {
			System.out.println((i+1) + " - " + testAux.climate());
		}
	}
}
