package logic;

import java.util.ArrayList;

/**
 * 
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public class Round {
	private int numberRoubd;
	private ArrayList<TeamArcher> listTeam;
	private Archer roundWinnerA;
	private Archer roundWinnerB;
	private TeamArcher teamWinner;

	public Round() {
	}

	/**
	 * constrcutor
	 * 
	 * @param number
	 * @param list
	 */
	public Round(int number, ArrayList<TeamArcher> list) {
		this.listTeam = list;
		this.numberRoubd = number;

	}

	//Creación de los métodos setters y getters
	/**
	 * @return Método que obtiene el valor de la propiedad numberRoubd
	 */
	public int getNumberRoubd() {
		return numberRoubd;
	}

	/**
	 * @param Método que asigna el valor de la propiedad numberRoubd.
	 */
	public void setNumberRoubd(int numberRoubd) {
		this.numberRoubd = numberRoubd;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad listTeam
	 */
	public ArrayList<TeamArcher> getListTeam() {
		return listTeam;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listTeam.
	 */
	public void setListTeam(ArrayList<TeamArcher> listTeam) {
		this.listTeam = listTeam;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad roundWinnerA
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
	 * @return Método que obtiene el valor de la propiedad roundWinnerB
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
	 * @return Método que obtiene el valor de la propiedad teamWinner
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
