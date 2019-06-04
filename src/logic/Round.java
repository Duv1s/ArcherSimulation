package logic;

import java.util.ArrayList;

/**
 * Clase que permite realizar la gestion de rondas.
 *@author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public class Round {
	private int numberRound;
	private ArrayList<TeamArcher> listTeamArcher;
	private Archer roundWinnerA;
	private Archer roundWinnerB;
	private TeamArcher teamWinner;

	/**
	 * Método constructor de la clase Ronda
	 */
	public Round() {
	}

	/**
	 * Método constructor de la clase Ronda
	 * @param numberRound Número de la ronda jugada
	 * @param listTeamArcher Lista del equipo de aruqeros
	 */
	public Round(int numberRound, ArrayList<TeamArcher> listTeamArcher) {
		this.listTeamArcher = listTeamArcher;
		this.numberRound = numberRound;

	}

	//Creación de los métodos setters y getters
	/**
	 * @return  Método que obtiene el valor de la propiedad numberRound.
	 */
	public int getNumberRound() {
		return numberRound;
	}

	/**
	 * @param Método que asigna el valor de la propiedad numberRound.
	 */
	public void setNumberRound(int numberRound) {
		this.numberRound = numberRound;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad listTeam.
	 */
	public ArrayList<TeamArcher> getListTeam() {
		return listTeamArcher;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listTeam.
	 */
	public void setListTeam(ArrayList<TeamArcher> listTeam) {
		this.listTeamArcher = listTeam;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad roundWinnerA.
	 */
	public Archer getRoundWinnerA() {
		return roundWinnerA;
	}

	/**
	 * @param Método que asigna el valor de la propiedad roundWinnerA.
	 */
	public void setRoundWinnerA(Archer roundWinnerA) {
		this.roundWinnerA = roundWinnerA;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad roundWinnerB.
	 */
	public Archer getRoundWinnerB() {
		return roundWinnerB;
	}

	/**
	 * @param Método que asigna el valor de la propiedad roundWinnerB.
	 */
	public void setRoundWinnerB(Archer roundWinnerB) {
		this.roundWinnerB = roundWinnerB;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad teamWinner.
	 */
	public TeamArcher getTeamWinner() {
		return teamWinner;
	}

	/**
	 * @param Método que asigna el valor de la propiedad teamWinner.
	 */
	public void setTeamWinner(TeamArcher teamWinner) {
		this.teamWinner = teamWinner;
	}
}
