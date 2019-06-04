package logic;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Clase que permite definir el concepto de un equipo de arqueros
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TeamArcher extends ArrayList<TeamArcher> {
	public static final int NUMBER_ARCHERS = 20;
	ArrayList<Archer> listArcher;
	private Random randomGender;
	private ManagerArcher managerArcher;
	private ManagerShot managerShot;
	private String nameTeam;
	private int pointGame;
	private double teamShotDistance;

	/**
	 * Método constructor de la clase Equipo de Arqueros
	 * @param name Nombre del equipo
	 */
	public TeamArcher(String name) {
		this.nameTeam = name;
		listArcher = new ArrayList<>();
		randomGender = new Random();
		managerArcher = new ManagerArcher();
		managerShot = new ManagerShot();
		personAddTeam();
		managerArcher.archerDefinePrecision(listArcher);
		managerArcher.archerDefineResistenceAndLuck(listArcher);
		managerShot.makeShot(listArcher);
	}

	/**
	 * Método que permite definir el tipo de escenario(Clima) en el cual se jugara cada partida
	 * @return
	 */
	public int stageRandom() {
		Random random = new Random();
		return random.nextInt(4); 
	}

	/**
	 * Método constructor sobreescrito sin parametros para la creación de equipos de la segunda ronda en adelante.
	 */
	public TeamArcher() {
		listArcher = new ArrayList<>();
		randomGender = new Random();
		managerArcher = new ManagerArcher();
		managerShot = new ManagerShot();
	}

	/**
	 * Metodo que perimte añadir agregar una cantidad n de arqueros a un equipo.
	 */
	public void personAddTeam() {
		for (int i = 0; i < NUMBER_ARCHERS; i++) {
			listArcher.add(new Archer(gender(), "Arquero" + Integer.toString(i + 1), new GregorianCalendar().getTime()));
		}
	}

	/**
	 * Método que permite generar un género psudo-aleatorio a un aequero.
	 * @return
	 */
	public GenderEnum gender() {
		int genre = randomGender.nextInt(2);
		if (genre == 1) {
			return GenderEnum.MALE;
		} else
			return GenderEnum.FEMALE;
	}

	//Creación de los métodos setters y getters
	/**
	 * @return  Método que obtiene el valor de la propiedad listPlayer.
	 */
	public ArrayList<Archer> getListPlayer() {
		return listArcher;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listPlayer.
	 */
	public void setListPlayer(ArrayList<Archer> listPlayer) {
		this.listArcher = listPlayer;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad randomGeder.
	 */
	public Random getRandomGeder() {
		return randomGender;
	}

	/**
	 * @param Método que asigna el valor de la propiedad randomGeder.
	 */
	public void setRandomGeder(Random randomGeder) {
		this.randomGender = randomGeder;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad managerArcher.
	 */
	public ManagerArcher getManagerArcher() {
		return managerArcher;
	}

	/**
	 * @param Método que asigna el valor de la propiedad managerArcher.
	 */
	public void setManagerArcher(ManagerArcher managerArcher) {
		this.managerArcher = managerArcher;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad gestorShot.
	 */
	public ManagerShot getGestorShot() {
		return managerShot;
	}

	/**
	 * @param Método que asigna el valor de la propiedad gestorShot.
	 */
	public void setGestorShot(ManagerShot gestorShot) {
		this.managerShot = gestorShot;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad nameTeam.
	 */
	public String getNameTeam() {
		return nameTeam;
	}

	/**
	 * @param Método que asigna el valor de la propiedad nameTeam.
	 */
	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad pointGame.
	 */
	public int getPointGame() {
		return pointGame;
	}

	/**
	 * @param Método que asigna el valor de la propiedad pointGame.
	 */
	public void setPointGame(int pointGame) {
		this.pointGame = pointGame;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad teamShotDistance.
	 */
	public double getTeamShotDistance() {
		return teamShotDistance;
	}

	/**
	 * @param Método que asigna el valor de la propiedad teamShotDistance.
	 */
	public void setTeamShotDistance(double teamShotDistance) {
		this.teamShotDistance = teamShotDistance;
	}
}
