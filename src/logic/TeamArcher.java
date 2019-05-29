package logic;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * 
 * @author Duvis Alejandro G�mez Neira
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TeamArcher extends ArrayList<TeamArcher> {
	ArrayList<Archer> listPlayer;
	private Random randomGeder;
	public static final int NUMBER_PARTICIPANTS = 20;
	private ManagerArcher managerArcher;
	private GestorShot gestorShot;
	private String nameTeam;
	private int pointGame;
	private double teamShotDistance;

	/**
	 * constrcutor con parametro para los equipos de la primera ronda
	 */
	public TeamArcher(String name) {
		this.nameTeam = name;
		listPlayer = new ArrayList<>();
		randomGeder = new Random();
		managerArcher = new ManagerArcher();
		gestorShot = new GestorShot();
		personAddTeam();
		managerArcher.archerDefinePrecision(listPlayer);
		managerArcher.archerAttributesR(listPlayer);
		gestorShot.shotAttributesPerson(listPlayer);
	}

	public int stageRandom() {
		Random random = new Random();
		return random.nextInt(4);
	}

	/**
	 * constructor sin parametros para los equipos de la segunda ronda en adelante
	 */
	public TeamArcher() {
		listPlayer = new ArrayList<>();
		randomGeder = new Random();
		managerArcher = new ManagerArcher();
		gestorShot = new GestorShot();
		// personAddTeam();esta linea me hizo sufrir :/
	}

	/**
	 * a�dir personas al equipo
	 */
	public void personAddTeam() {
		for (int i = 0; i < NUMBER_PARTICIPANTS; i++) {
			listPlayer.add(new Archer(genre(), Integer.toString(i + 1), new GregorianCalendar().getTime()));
		}
	}

	/**
	 * generar un genero aleatorio para una persona
	 * 
	 * @return
	 */
	public GenderEnum genre() {
		int genre = randomGeder.nextInt(2);
		if (genre == 1) {
			return GenderEnum.MALE;
		} else
			return GenderEnum.FEMALE;
	}

	//Creaci�n de los m�todos setters y getters
	/**
	 * @return M�todo que obtiene el valor de la propiedad listPlayer
	 */
	public ArrayList<Archer> getListPlayer() {
		return listPlayer;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad listPlayer.
	 */
	public void setListPlayer(ArrayList<Archer> listPlayer) {
		this.listPlayer = listPlayer;
	}

	/**
	 * @return M�todo que obtiene el valor de la propiedad randomGenre
	 */
	public Random getRandomGenre() {
		return randomGeder;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad randomGenre.
	 */
	public void setRandomGenre(Random randomGenre) {
		this.randomGeder = randomGenre;
	}

	/**
	 * @return M�todo que obtiene el valor de la propiedad gestorPerson
	 */
	public ManagerArcher getGestorPerson() {
		return managerArcher;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad gestorPerson.
	 */
	public void setGestorPerson(ManagerArcher gestorPerson) {
		this.managerArcher = gestorPerson;
	}

	/**
	 * @return M�todo que obtiene el valor de la propiedad gestorShot
	 */
	public GestorShot getGestorShot() {
		return gestorShot;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad gestorShot.
	 */
	public void setGestorShot(GestorShot gestorShot) {
		this.gestorShot = gestorShot;
	}

	/**
	 * @return M�todo que obtiene el valor de la propiedad nameTeam
	 */
	public String getNameTeam() {
		return nameTeam;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad nameTeam.
	 */
	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}

	/**
	 * @return M�todo que obtiene el valor de la propiedad pointGame
	 */
	public int getPointGame() {
		return pointGame;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad pointGame.
	 */
	public void setPointGame(int pointGame) {
		this.pointGame = pointGame;
	}

	/**
	 * @return M�todo que obtiene el valor de la propiedad teamShotDistance
	 */
	public double getTeamShotDistance() {
		return teamShotDistance;
	}

	/**
	 * @param M�todo que asigna el valor de la propiedad teamShotDistance.
	 */
	public void setTeamShotDistance(double teamShotDistance) {
		this.teamShotDistance = teamShotDistance;
	}

	/**
	 * @return M�todo que obtiene el valor de la propiedad numberParticipants
	 */
	public static int getNumberParticipants() {
		return NUMBER_PARTICIPANTS;
	}
}
