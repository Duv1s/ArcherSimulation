package logic;

import java.util.ArrayList;

/**
 * Clase que permite inicializar los valores para las condiciones de cada juego
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public class Game {
	private TeamArcher teamArcher;
	private StageWeatherEnum typeClimate;
	private double averageLuckPoint;
	private double averageExperiencePoint;
	private ArrayList<Archer> listArcher;

	
	/**
	 * Método constructor de la clase juego
	 * @param listArcher Lsita de arqueros del juego
	 */
	public Game(ArrayList<Archer> listArcher) {
		this.listArcher = listArcher;

	}

	/**
	 * Método constructor de la clase juego 
	 * @param teamArcher Equipo de Arqueros
	 * @param typeClimate Tipo de escenario en que se dará cada juego
	 * @param luckAverage Promedio de suerte
	 * @param experienceAverage Promedio de experiencia.
	 */
	public Game(TeamArcher teamArcher, StageWeatherEnum typeClimate, double luckAverage, double experienceAverage) {
		this.teamArcher = teamArcher;
		this.typeClimate = typeClimate;
		this.averageLuckPoint = luckAverage;
		this.averageExperiencePoint = experienceAverage;
		this.listArcher = new ArrayList<>();
	}

	//Creación de los métodos setters y getters
	/**
	 * @return  Método que obtiene el valor de la propiedad teamArcher.
	 */
	public TeamArcher getTeamArcher() {
		return teamArcher;
	}

	/**
	 * @param Método que asigna el valor de la propiedad teamArcher.
	 */
	public void setTeamArcher(TeamArcher teamArcher) {
		this.teamArcher = teamArcher;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad typeClimate.
	 */
	public StageWeatherEnum getTypeClimate() {
		return typeClimate;
	}

	/**
	 * @param Método que asigna el valor de la propiedad typeClimate.
	 */
	public void setTypeClimate(StageWeatherEnum typeClimate) {
		this.typeClimate = typeClimate;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad averageLuckPoint.
	 */
	public double getAverageLuckPoint() {
		return averageLuckPoint;
	}

	/**
	 * @param Método que asigna el valor de la propiedad averageLuckPoint.
	 */
	public void setAverageLuckPoint(double averageLuckPoint) {
		this.averageLuckPoint = averageLuckPoint;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad averageExperiencePoint.
	 */
	public double getAverageExperiencePoint() {
		return averageExperiencePoint;
	}

	/**
	 * @param Método que asigna el valor de la propiedad averageExperiencePoint.
	 */
	public void setAverageExperiencePoint(double averageExperiencePoint) {
		this.averageExperiencePoint = averageExperiencePoint;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad listPerson.
	 */
	public ArrayList<Archer> getListPerson() {
		return listArcher;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listPerson.
	 */
	public void setListPerson(ArrayList<Archer> listPerson) {
		this.listArcher = listPerson;
	}
}
