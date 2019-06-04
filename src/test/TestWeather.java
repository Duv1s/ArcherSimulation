package test;

import java.util.Random;

import logic.StageWeatherEnum;

/**
 * Clase en la que se realizan las pruebas de la generación de los escenarios(clima).
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public class TestWeather {
	private Random randomClimate = new Random();

	/**
	 * Método que realiza la generación de un numero pseudoaleatorio el cuál determinará el escenario(clima) en que se jugaran las partidas
	 * @return
	 */
	public StageWeatherEnum climate() {
		int genre = randomClimate.nextInt(3);
		switch (genre) {
		case 0:
			return StageWeatherEnum.NORMAL;
		case 1:
			return StageWeatherEnum.RAIN;
		case 2: 
			return StageWeatherEnum.WIND;
		default:
			return StageWeatherEnum.NORMAL;
		}
	}

	
	public static void main(String[] args) {
		TestWeather testAux = new TestWeather();
		System.out.println("Escenario generado");
		for (int i = 0; i < 12; i++) {
			System.out.println("Escenario " + (i+1) + " - Clima generado: " + testAux.climate());
		}
	}
}
