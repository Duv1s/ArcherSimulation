package logic;

import java.util.ArrayList;

/**
 * 
 * @author Duvis Alejandro G�mez Neira
 * @version 1.0
 */
public class Game {
	private TeamArcher teamArcher;
	private StageWeatherEnum typeClimate;
	private double averageLuckPoint;
	private double averageExperiencePoint;
	private ArrayList<Archer> listPerson;

	public Game(ArrayList<Archer> listPerson) {
		this.listPerson = listPerson;

	}

	public Game(TeamArcher teamArcher, StageWeatherEnum typeClimate, double luckAverage, double experienceAverage) {
		this.teamArcher = teamArcher;
		this.typeClimate = typeClimate;
		this.averageLuckPoint = luckAverage;
		this.averageExperiencePoint = experienceAverage;
		this.listPerson = new ArrayList<>();
	}

	//Creaci�n de los m�todos setters y getters
	/**
	 * @return M�todo que obtiene el valor de la propiedad teamArcher
	 */
	public TeamArcher getTeamArcher() {
		return teamArcher;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad teamArcher.
	 */
	public void setTeamArcher(TeamArcher teamArcher) {
		this.teamArcher = teamArcher;
	}

	/**
	 * @return M�todo que obtiene el valor de la propiedad typeClimate
	 */
	public StageWeatherEnum getTypeClimate() {
		return typeClimate;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad typeClimate.
	 */
	public void setTypeClimate(StageWeatherEnum typeClimate) {
		this.typeClimate = typeClimate;
	}

	/**
	 * @return M�todo que obtiene el valor de la propiedad averageLuckPoint
	 */
	public double getAverageLuckPoint() {
		return averageLuckPoint;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad averageLuckPoint.
	 */
	public void setAverageLuckPoint(double averageLuckPoint) {
		this.averageLuckPoint = averageLuckPoint;
	}

	/**
	 * @return M�todo que obtiene el valor de la propiedad averageExperiencePoint
	 */
	public double getAverageExperiencePoint() {
		return averageExperiencePoint;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad averageExperiencePoint.
	 */
	public void setAverageExperiencePoint(double averageExperiencePoint) {
		this.averageExperiencePoint = averageExperiencePoint;
	}

	/**
	 * @return M�todo que obtiene el valor de la propiedad listPerson
	 */
	public ArrayList<Archer> getListPerson() {
		return listPerson;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad listPerson.
	 */
	public void setListPerson(ArrayList<Archer> listPerson) {
		this.listPerson = listPerson;
	}

	

}
