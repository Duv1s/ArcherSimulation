package logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Duvis Alejandro Gï¿½mez Neira
 * @version 1.0
 */
public class GestorGame {
	private ArrayList<Round> listRound;
	private ArrayList<TeamArcher> listTeam;
	public static final int NUMBER_ROUDS = 500;
	public static final int NUMBER_TEAMS = 2;
	public static final double FACTOR_LUCK = 0.05;
	private ManagerArcher gestorPerson;
	private GestorShot gestorShot;
	private ArrayList<TeamArcher> listRoundWinnerTeam;
	private Game game;
	private ArrayList<Game> listGameWinner;
	private ArrayList<Game> listGameWinnerPErson;

	private ArrayList<Integer> listLuckPoint;
	private ArrayList<Integer> listExperiencePoint;
	private Random randomClimate;
	private ArrayList<Archer> listPlayer;
	private String teamMostWinnerWind = "";
	private String teamMostWinnerRain = "";
	private String teamMostWinnerNormal = "";
	private String teamMostvictoryT = "";

	private String genreMostWinnerWind = "";
	private String genreMostWinnerRain = "";
	private String genreMostWinnerNormal = "";
	private String genreMostvictoryT = "";

	private String personMostLuckWinnerWind;
	private String personMostluckWinnerRain;
	private String personMostluckWinnerNormal;

	private String personMostExperienceWinnerWind;
	private String personMostExperienceWinnerRain;
	private String personMostExperienceWinnerNormal;

	/**
	 * constructor
	 */
	public GestorGame() {
		randomClimate = new Random();
		this.listGameWinnerPErson = new ArrayList<>();
		this.listPlayer = new ArrayList<>();
		this.listRound = new ArrayList<>();
		this.listTeam = new ArrayList<>();
		this.listRoundWinnerTeam = new ArrayList<>();
		this.listGameWinner = new ArrayList<>();
		this.listExperiencePoint = new ArrayList<>();
		this.listLuckPoint = new ArrayList<>();
		gestorPerson = new ManagerArcher();
		gestorShot = new GestorShot();
		addTeam();
		addRounds();
		teamWinGame();
		teamMostVictory();
		teamMostVictoryTotal();
		genreMostVictoryTotal();
		genreMostVictory();
		personMostLuck();
		personMostExperience();
	}

	/**
	 * jugador con mas experiencia
	 */
	public void personMostExperience() {
		this.personMostExperienceWinnerNormal = personMostExperience(StageWeatherEnum.NORMAL);
		this.personMostExperienceWinnerRain = personMostExperience(StageWeatherEnum.RAIN);
		this.personMostExperienceWinnerWind = personMostExperience(StageWeatherEnum.WIND);
	}

	/**
	 * jugador con mas experiencia segun escenario
	 * 
	 * @param climate
	 * @return
	 */
	public String personMostExperience(StageWeatherEnum climate) {
		double W = 0.0;
		String sA = "";
		for (int i = 0; i < listGameWinner.size(); i++) {
			if (listGameWinner.get(i).getTypeClimate() == climate) {
				for (int j = 0; j < listGameWinnerPErson.get(i).getListPerson().size(); j++) {
					if (listGameWinnerPErson.get(i).getListPerson().get(j).getExperience() >= W) {
						sA = "|" + listGameWinnerPErson.get(i).getListPerson().get(j).getExperience() + " | jugador: "
								+ listGameWinnerPErson.get(i).getListPerson().get(j).getNameArcher() + " | Equipo: "
								+ listGameWinner.get(i).getTeamArcher().getNameTeam();
						W = listGameWinnerPErson.get(i).getListPerson().get(j).getExperience();
					}
				}
			}
		}
		return sA;
	}

	/**
	 * jugador con mas suerte
	 */
	public void personMostLuck() {
		this.personMostluckWinnerNormal = personMostLuck(StageWeatherEnum.NORMAL);
		this.personMostluckWinnerRain = personMostLuck(StageWeatherEnum.RAIN);
		this.personMostLuckWinnerWind = personMostLuck(StageWeatherEnum.WIND);
	}

	/**
	 * jugador con mas suerte segun escenario
	 * 
	 * @param climate
	 * @return
	 */
	public String personMostLuck(StageWeatherEnum climate) {
		double W = 0.0;
		String sA = "";
		for (int i = 0; i < listGameWinnerPErson.size(); i++) {
			if (listGameWinner.get(i).getTypeClimate() == climate) {
				for (int j = 0; j < listGameWinnerPErson.get(i).getListPerson().size(); j++) {
					if (listGameWinnerPErson.get(i).getListPerson().get(j).getLuck() >= W) {
						sA = "|" + listGameWinnerPErson.get(i).getListPerson().get(j).getLuck() + " | jugador: "
								+ listGameWinnerPErson.get(i).getListPerson().get(j).getNameArcher() + " | Equipo: "
								+ listGameWinner.get(i).getTeamArcher().getNameTeam();
						W = listGameWinnerPErson.get(i).getListPerson().get(j).getLuck();
					}
				}
			}
		}
		return sA;
	}

	/**
	 * genero mas ganador
	 */
	public void genreMostVictory() {
		genreMostVictory(StageWeatherEnum.NORMAL);
		genreMostVictory(StageWeatherEnum.RAIN);
		genreMostVictory(StageWeatherEnum.WIND);
	}

	/**
	 * genero con mas victorias segun escenario
	 *
	 * @param climate
	 */
	public void genreMostVictory(StageWeatherEnum climate) {
		int A = 0;
		int B = 0;

		for (int i = 0; i < listGameWinnerPErson.size(); i++) {
			A = 0;
			B = 0;
			if (listGameWinner.get(i).getTypeClimate() == climate) {
				for (int j = 0; j < listGameWinnerPErson.get(i).getListPerson().size(); j++) {
					if (listGameWinnerPErson.get(i).getListPerson().get(j).getGender() == GenderEnum.MALE) {
						A++;
					} else if (listGameWinnerPErson.get(i).getListPerson().get(j).getGender() == GenderEnum.FEMALE) {
						B++;
					}
				}
				if (A > B) {
					if (climate == StageWeatherEnum.NORMAL) {
						this.genreMostWinnerNormal = GenderEnum.MALE.gender;
					} else if (climate == StageWeatherEnum.RAIN) {
						this.genreMostWinnerRain = GenderEnum.MALE.gender;
					} else if (climate == StageWeatherEnum.WIND) {
						this.genreMostWinnerWind = GenderEnum.MALE.gender;
					}
				} else if (A < B) {
					if (climate == StageWeatherEnum.NORMAL) {
						this.genreMostWinnerNormal = GenderEnum.FEMALE.gender;
					} else if (climate == StageWeatherEnum.RAIN) {
						this.genreMostWinnerRain = GenderEnum.FEMALE.gender;
					} else if (climate == StageWeatherEnum.WIND) {
						this.genreMostWinnerWind = GenderEnum.FEMALE.gender;
					}
				} else if (A == B) {
					if (climate == StageWeatherEnum.NORMAL) {
						this.genreMostWinnerNormal = "Empate";
					} else if (climate == StageWeatherEnum.RAIN) {
						this.genreMostWinnerRain = "Empate";
					} else if (climate == StageWeatherEnum.WIND) {
						this.genreMostWinnerWind = "Empate";
					}
				}
			}
		}
	}

	/**
	 * genero con mas victorias totales
	 */
	public void genreMostVictoryTotal() {
		int M = 0;
		int F = 0;
		for (Round round : listRound) {
			if (round.getRoundWinnerA().getGender() == GenderEnum.MALE) {
				M++;
			} else if (round.getRoundWinnerA().getGender() == GenderEnum.FEMALE) {
				F++;
			}
			if (round.getRoundWinnerB().getGender() == GenderEnum.MALE) {
				M++;
			} else if (round.getRoundWinnerB().getGender() == GenderEnum.FEMALE) {
				F++;
			}
		}
		if (M > F) {
			this.genreMostvictoryT = GenderEnum.MALE.gender;
		} else if (M < F) {
			this.genreMostvictoryT = GenderEnum.FEMALE.gender;
		} else if (M == F) {
			this.genreMostvictoryT = "Empate";
		}
	}

	/**
	 * calcula el equipo mas ganador en todos los escenarios
	 */
	public void teamMostVictoryTotal() {
		int A = 0;
		int B = 0;
		for (Game game : listGameWinner) {
			if (game.getTeamArcher().getNameTeam().equalsIgnoreCase("Equipo 1")) {
				A++;
			} else {
				B++;
			}
		}
		if (A > B) {
			this.teamMostvictoryT = "Equipo 1";
		} else if (A < B) {
			this.teamMostvictoryT = "Equipo 2";
		} else if (A == B) {
			this.teamMostvictoryT = "Empate";
		}
	}

	/**
	 * calcula el equipo con mas victoria en cada escenario
	 */
	public void teamMostVictory() {
		teamMostVictory(StageWeatherEnum.WIND);
		teamMostVictory(StageWeatherEnum.RAIN);
		teamMostVictory(StageWeatherEnum.NORMAL);
	}

	/**
	 * equipo con mas victorias en un determinado escenario
	 *
	 * @param climate
	 */
	public void teamMostVictory(StageWeatherEnum climate) {
		int A = 0;
		int B = 0;
		for (Game game : this.listGameWinner) {
			if (game.getTypeClimate() == climate) {
				if (game.getTeamArcher().getNameTeam().equalsIgnoreCase("Equipo 1")) {
					A++;
				} else {
					B++;
				}
			}
		}
		if (A > B) {
			if (climate == StageWeatherEnum.NORMAL) {
				this.teamMostWinnerNormal = "Equipo 1";
			} else if (climate == StageWeatherEnum.RAIN) {
				this.teamMostWinnerRain = "Equipo 1";
			} else if (climate == StageWeatherEnum.WIND) {
				this.teamMostWinnerWind = "Equipo 1";
			}
		} else if (A < B) {
			if (climate == StageWeatherEnum.NORMAL) {
				this.teamMostWinnerNormal = "Equipo 2";
			} else if (climate == StageWeatherEnum.RAIN) {
				this.teamMostWinnerRain = "Equipo 2";
			} else if (climate == StageWeatherEnum.WIND) {
				this.teamMostWinnerWind = "Equipo 2";
			}
		} else if (A == B) {
			if (climate == StageWeatherEnum.NORMAL) {
				this.teamMostWinnerNormal = "Empate";
			} else if (climate == StageWeatherEnum.RAIN) {
				this.teamMostWinnerRain = "Empate";
			} else if (climate == StageWeatherEnum.WIND) {
				this.teamMostWinnerWind = "Empate";
			}
		}
	}

	/**
	 * segÃºn la condiciÃ³n climatica afecta la distancia del tiro
	 *
	 * @param shot
	 * @param climate
	 * @return
	 */
	public double climateFactor(double shot, StageWeatherEnum climate) {
		if (climate == StageWeatherEnum.WIND) {
			return shot - (shot * 0.04);
		} else if (climate == StageWeatherEnum.RAIN) {
			return shot - (shot * 0.08);
		} else {
			return shot;
		}
	}

	/**
	 * generar un clima aleatorio
	 *
	 * @return
	 */
	public StageWeatherEnum climate() {
		int genre = randomClimate.nextInt(3);
		if (genre == 1) {
			return StageWeatherEnum.WIND;
		} else if (genre == 2) {
			return StageWeatherEnum.RAIN;
		} else
			return StageWeatherEnum.NORMAL;
	}

	/**
	 * metodo que calcula el ganador de una partida, ademÃ¡s llama al metodo de
	 * calcular la distancia del tiro segÃºn el clima una vez se gana una partida se
	 * reinicia el contador de rodas ganadas por equipo
	 */
	public void teamWinGame() {
		int A = 0;
		int B = 0;
		int cont = 0;
		StageWeatherEnum climate;

		for (TeamArcher teamArcher : this.listRoundWinnerTeam) {
			climate = climate();
			for (Archer person : teamArcher.getListPlayer()) {
				for (Shot shot : person.getListShot()) {
					shot.setDistance(climateFactor(shot.getDistance(), climate));
				}
			}
			if (teamArcher.getNameTeam().equalsIgnoreCase("Equipo 1")) {
				A++;
			} else if (teamArcher.getNameTeam().equalsIgnoreCase("Equipo 2")) {
				B++;
			}

			if (A == 10) {
				listGameWinner.add(new Game(teamArcher, climate, (A + B) * 2, (A + B)));

				// listGameWinner.get(cont).setListPerson(teamArcher.getListPlayer());
				listGameWinnerPErson.add(new Game(teamArcher.getListPlayer()));
				A = 0;
				B = 0;

			} else if (B == 10) {
				listGameWinner.add(new Game(teamArcher, climate, (A + B) * 2, (A + B)));
				// listGameWinner.get(cont).setListPerson(teamArcher.getListPlayer());
				listGameWinnerPErson.add(new Game(teamArcher.getListPlayer()));
				A = 0;
				B = 0;
			}
			// listGameWinnerPErson.add(new Game(teamArcher.getListPlayer()));
			cont++;
		}
	}

	/**
	 * ganadores por ronda
	 *
	 * @param teamArcher
	 */
	public void addListWinnerRound(TeamArcher teamArcher) {
		this.listRoundWinnerTeam.add(teamArcher);
	}

	/**
	 * con una lista de equipos y la distancia total de cada uno, devuelve el equipo
	 * ganador
	 *
	 * @return
	 */
	public TeamArcher teamWinnerRound(ArrayList<TeamArcher> list) {
		if (list.get(0).getTeamShotDistance() > list.get(1).getTeamShotDistance()) {
			return list.get(0);
		} else {
			return list.get(1);
		}
	}

	/**
	 * calcula la distancia total del equipo
	 *
	 * @param list
	 * @return
	 */
	public double distanceTotalForTeam(ArrayList<Archer> list) {
		double aux = 0.0;
		for (int i = 0; i < list.size(); i++) {
			aux += list.get(i).getTotalDistance();
		}
		return aux;
	}

	/**
	 * permite aÃ±adir a la lista de rounds una lista de equipos
	 */
	public void addRounds() {
		for (int i = 0; i < NUMBER_ROUDS; i++) {
			ArrayList<TeamArcher> listAux = new ArrayList<>();
			copyArray(listTeam, listAux);
			distanceTotalSum(listAux.get(0).getListPlayer());
			distanceTotalSum(listAux.get(1).getListPlayer());
			addShotDraw(listAux, shotDraw(listAux.get(0).getListPlayer()), shotDraw(listAux.get(1).getListPlayer()));
			listRound.add(new Round(i, listAux));// aÃ±ade un nuevo round a la lista de rounds
			listRound.get(i).setRoundWinnerA(personRoundWinner(listAux.get(0).getListPlayer()));// asigna el ganador
																								// individual del 1
																								// equipo al round
			listRound.get(i).setRoundWinnerB(personRoundWinner(listAux.get(1).getListPlayer()));// asigna el ganador
																								// individual del 2
																								// equipo al round
			// listGameWinnerPErson.add(new Game(teamArcher.getListPlayer()));
			listRound.get(i).getListTeam().get(0)
					.setTeamShotDistance(distanceTotalForTeam(listAux.get(0).getListPlayer()));
			listRound.get(i).getListTeam().get(1)
					.setTeamShotDistance(distanceTotalForTeam(listAux.get(1).getListPlayer()));

			listRound.get(i).setTeamWinner(teamWinnerRound(listAux));

			addListWinnerRound(listRound.get(i).getTeamWinner());
			addExperienceArcher(listRound.get(i).getRoundWinnerA(),
					listRound.get(i).getListTeam().get(0).getListPlayer());// aumenta experiencia 1 equipo
			addExperienceArcher(listRound.get(i).getRoundWinnerB(),
					listRound.get(i).getListTeam().get(1).getListPlayer());// aumenta experiencia 2 equipo
			listTeam = listRound.get(i).getListTeam();
		}

	}

	/**
	 * sera verdadera la condicion si la experiencie extra de un jugador llega a
	 * ocho
	 *
	 * @param person
	 * @return
	 */
	public boolean isExperienceWin(Archer person) {
		return person.getExperience() >= 18;
	}

	/**
	 * aÃ±ade dos puntos de experiencia al ganador de la ronda
	 *
	 * @param p
	 * @param listPerson
	 */
	public void addExperienceArcher(Archer p, ArrayList<Archer> listPerson) {
		for (int i = 0; i < listPerson.size(); i++) {
			if (p.equals(listPerson.get(i))) {
				listPerson.get(i).setExperience(listPerson.get(i).getExperience() + 2);
			}
		}
	}

	/**
	 * permite identificar al judador con mas distancia de una lista de personas
	 *
	 * @param listPerson
	 * @return
	 */
	public Archer personRoundWinner(ArrayList<Archer> listPerson) {
		Archer person = listPerson.get(0);
		for (int i = 1; i < listPerson.size(); i++) {
			if (listPerson.get(i).getTotalDistance() > person.getTotalDistance()) {
				person = listPerson.get(i);
			}
		}
		return person;
	}

	/**
	 * este metodo suma la disancia total de todos los tiros de un jugador
	 *
	 * @param listPerson
	 * @return
	 */
	public void distanceTotalSum(ArrayList<Archer> listPerson) {
		double auxDistance = 0.0;
		int aux = 0;
		for (int i = 0; i < listPerson.size(); i++) {
			for (int j = 0; j < listPerson.get(i).getListShot().size(); j++) {
				auxDistance += listPerson.get(i).getListShot().get(j).getDistance();
			}
			aux = listPerson.get(i).getListShot().size();
			listPerson.get(i).setTotalDistance(auxDistance / aux);
			auxDistance = 0.0;
			aux = 0;
		}
	}

	/**
	 * aumentar la experiencia de un jugador siempre y cuando tenga tres tiros de
	 * suerte
	 */
	public void luckIncrease(ArrayList<Archer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getExtraShot() == 3) {
				list.get(i).setLuck(list.get(i).getLuck() + FACTOR_LUCK);
				list.get(i).setExtraShot(0);
			}
		}
	}

	/**
	 * se le ingresa la posicion de un jugador y la busca en la lista y aÃ±ade un
	 * tiro adicional a la persona con mas suerte, ademas llama el metodo de
	 * verificar si una persona tiene tres tiros de suerte consecutivos
	 *
	 * @param list @
	 */
	public void addShotDraw(ArrayList<TeamArcher> list, int a, int b) {
		list.get(0).getListPlayer().get(a).getListShot()
				.add(new Shot(gestorShot.calculateVelocity(), gestorShot.calculateAngle()));
		list.get(0).getListPlayer().get(a).getListShot()
				.get(list.get(0).getListPlayer().get(a).getListShot().size() - 1)
				.setDistance(gestorShot.calculateDistance(gestorShot.calculateVelocity(), gestorShot.calculateAngle()));
		list.get(0).getListPlayer().get(a).setExtraShot(list.get(0).getListPlayer().get(a).getExtraShot() + 1);
		validateExtraShot(list.get(0).getListPlayer(), a);
		luckIncrease(list.get(0).getListPlayer());
		list.get(1).getListPlayer().get(b).getListShot()
				.add(new Shot(gestorShot.calculateVelocity(), gestorShot.calculateAngle()));
		list.get(1).getListPlayer().get(b).getListShot()
				.get(list.get(1).getListPlayer().get(b).getListShot().size() - 1)
				.setDistance(gestorShot.calculateDistance(gestorShot.calculateVelocity(), gestorShot.calculateAngle()));
		list.get(1).getListPlayer().get(b).setExtraShot(list.get(1).getListPlayer().get(b).getExtraShot() + 1);
		validateExtraShot(list.get(1).getListPlayer(), b);// resetea los tiros extras diferentes al ganador
		luckIncrease(list.get(1).getListPlayer());// aumenta experiencia segÃºn condiciÃ³n
	}

	/**
	 * metodo para eliminar los tiros extras si no son consecutivos por parametro
	 * entra una lista de jugadores y el numero de tiros de suerte de jugador actual
	 *
	 * @param list
	 * @param aux
	 */
	public void validateExtraShot(ArrayList<Archer> list, int aux) {
		for (int i = 0; i < list.size(); i++) {
			if (i != aux) {// si la posicion actual es diferente a la de la posicion del actual ganador, se
							// resetea el contador del tiro extra
				list.get(i).setExtraShot(0);
			}
		}
	}

	/**
	 * buscar la posicion del jugador con mas suerte
	 *
	 * @param list
	 * @return
	 */
	public int shotDraw(ArrayList<Archer> list) {
		double aux = 0.0;
		int a = 0;
		for (int i = 0; i < list.size(); i++) {
			if (aux < list.get(i).getLuck()) {
				aux = list.get(i).getLuck();
			}
		}
		for (int i = 0; i < list.size(); i++) {
			a = i;
			if (aux == list.get(i).getLuck()) {
				break;
			}
		}
		return a;
	}

	/**
	 * asignar equipos a una lista
	 */
	public void addTeam() {
		for (int i = 0; i < NUMBER_TEAMS; i++) {
			this.listTeam.add(new TeamArcher("Equipo " + (i + 1)));
		}
	}

	/**
	 * permite copiar un array sin apuntadores, esto es para recalcular la
	 * distancia, la suerte
	 *
	 * @param list
	 * @param listCopy
	 */
	public void copyArray(ArrayList<TeamArcher> list, ArrayList<TeamArcher> listCopy) {
		double auxDistance = 0.0;
		for (int i = 0; i < list.size(); i++) {// lista de equipos
			listCopy.add(new TeamArcher());
			for (int j = 0; j < list.get(i).getListPlayer().size(); j++) {// lista de jugadores
				Archer person = list.get(i).getListPlayer().get(j);
				// obtiene los datos de la ultima de la ultima lista
				listCopy.get(i).getListPlayer()
						.add(new Archer(person.getGender(), person.getNameArcher(), person.getDateOfBirth()));
				listCopy.get(i).getListPlayer().get(j).setPrecision(new Integer(person.getPrecision()));
				listCopy.get(i).getListPlayer().get(j).setResistance(new Integer(person.getResistance()));
				listCopy.get(i).getListPlayer().get(j).setExperience(new Integer(person.getExperience()));
				listCopy.get(i).getListPlayer().get(j).setExtraShot(new Integer(person.getExtraShot()));
				listCopy.get(i).getListPlayer().get(j).setGender(person.getGender());
				listCopy.get(i).getListPlayer().get(j).setLuck(new Double(gestorPerson.archerLuck()));// volver a
																										// calcular la
																										// suerte
				listCopy.get(i).setNameTeam(list.get(i).getNameTeam());
				for (int k = 0; k < list.get(i).getListPlayer().get(j).getListShot().size(); k++) {// lista de tiros
					int velocity = gestorShot.calculateVelocity();
					int angle = gestorShot.calculateAngle();
					listCopy.get(i).getListPlayer().get(j).getListShot().add(new Shot(velocity, angle));
					auxDistance = gestorShot.calculateDistance(velocity, angle);
					if (isExperienceWin(listCopy.get(i).getListPlayer().get(j))) {// si la experiencia extra ha sumado 8
																					// puntos
						listCopy.get(i).getListPlayer().get(j).getListShot().get(k)
								.setDistance(auxDistance + (auxDistance * 0.025));
					} else {// si no
						listCopy.get(i).getListPlayer().get(j).getListShot().get(k).setDistance(auxDistance);
					}
				}
			}
		}
	}

	//Creación de los métodos setters y getters
	/**
	 * @return Método que obtiene el valor de la propiedad listRound
	 */
	public ArrayList<Round> getListRound() {
		return listRound;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listRound.
	 */
	public void setListRound(ArrayList<Round> listRound) {
		this.listRound = listRound;
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
	 * @return Método que obtiene el valor de la propiedad gestorPerson
	 */
	public ManagerArcher getGestorPerson() {
		return gestorPerson;
	}

	/**
	 * @param Método que asigna el valor de la propiedad gestorPerson.
	 */
	public void setGestorPerson(ManagerArcher gestorPerson) {
		this.gestorPerson = gestorPerson;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad gestorShot
	 */
	public GestorShot getGestorShot() {
		return gestorShot;
	}

	/**
	 * @param Método que asigna el valor de la propiedad gestorShot.
	 */
	public void setGestorShot(GestorShot gestorShot) {
		this.gestorShot = gestorShot;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad listRoundWinnerTeam
	 */
	public ArrayList<TeamArcher> getListRoundWinnerTeam() {
		return listRoundWinnerTeam;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listRoundWinnerTeam.
	 */
	public void setListRoundWinnerTeam(ArrayList<TeamArcher> listRoundWinnerTeam) {
		this.listRoundWinnerTeam = listRoundWinnerTeam;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param Método que asigna el valor de la propiedad game.
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad listGameWinner
	 */
	public ArrayList<Game> getListGameWinner() {
		return listGameWinner;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listGameWinner.
	 */
	public void setListGameWinner(ArrayList<Game> listGameWinner) {
		this.listGameWinner = listGameWinner;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad listGameWinnerPErson
	 */
	public ArrayList<Game> getListGameWinnerPErson() {
		return listGameWinnerPErson;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listGameWinnerPErson.
	 */
	public void setListGameWinnerPErson(ArrayList<Game> listGameWinnerPErson) {
		this.listGameWinnerPErson = listGameWinnerPErson;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad listLuckPoint
	 */
	public ArrayList<Integer> getListLuckPoint() {
		return listLuckPoint;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listLuckPoint.
	 */
	public void setListLuckPoint(ArrayList<Integer> listLuckPoint) {
		this.listLuckPoint = listLuckPoint;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad listExperiencePoint
	 */
	public ArrayList<Integer> getListExperiencePoint() {
		return listExperiencePoint;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listExperiencePoint.
	 */
	public void setListExperiencePoint(ArrayList<Integer> listExperiencePoint) {
		this.listExperiencePoint = listExperiencePoint;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad randomClimate
	 */
	public Random getRandomClimate() {
		return randomClimate;
	}

	/**
	 * @param Método que asigna el valor de la propiedad randomClimate.
	 */
	public void setRandomClimate(Random randomClimate) {
		this.randomClimate = randomClimate;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad listPlayer
	 */
	public ArrayList<Archer> getListPlayer() {
		return listPlayer;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listPlayer.
	 */
	public void setListPlayer(ArrayList<Archer> listPlayer) {
		this.listPlayer = listPlayer;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad teamMostWinnerWind
	 */
	public String getTeamMostWinnerWind() {
		return teamMostWinnerWind;
	}

	/**
	 * @param Método que asigna el valor de la propiedad teamMostWinnerWind.
	 */
	public void setTeamMostWinnerWind(String teamMostWinnerWind) {
		this.teamMostWinnerWind = teamMostWinnerWind;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad teamMostWinnerRain
	 */
	public String getTeamMostWinnerRain() {
		return teamMostWinnerRain;
	}

	/**
	 * @param Método que asigna el valor de la propiedad teamMostWinnerRain.
	 */
	public void setTeamMostWinnerRain(String teamMostWinnerRain) {
		this.teamMostWinnerRain = teamMostWinnerRain;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad teamMostWinnerNormal
	 */
	public String getTeamMostWinnerNormal() {
		return teamMostWinnerNormal;
	}

	/**
	 * @param Método que asigna el valor de la propiedad teamMostWinnerNormal.
	 */
	public void setTeamMostWinnerNormal(String teamMostWinnerNormal) {
		this.teamMostWinnerNormal = teamMostWinnerNormal;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad teamMostvictoryT
	 */
	public String getTeamMostvictoryT() {
		return teamMostvictoryT;
	}

	/**
	 * @param Método que asigna el valor de la propiedad teamMostvictoryT.
	 */
	public void setTeamMostvictoryT(String teamMostvictoryT) {
		this.teamMostvictoryT = teamMostvictoryT;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad genreMostWinnerWind
	 */
	public String getGenreMostWinnerWind() {
		return genreMostWinnerWind;
	}

	/**
	 * @param Método que asigna el valor de la propiedad genreMostWinnerWind.
	 */
	public void setGenreMostWinnerWind(String genreMostWinnerWind) {
		this.genreMostWinnerWind = genreMostWinnerWind;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad genreMostWinnerRain
	 */
	public String getGenreMostWinnerRain() {
		return genreMostWinnerRain;
	}

	/**
	 * @param Método que asigna el valor de la propiedad genreMostWinnerRain.
	 */
	public void setGenreMostWinnerRain(String genreMostWinnerRain) {
		this.genreMostWinnerRain = genreMostWinnerRain;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad genreMostWinnerNormal
	 */
	public String getGenreMostWinnerNormal() {
		return genreMostWinnerNormal;
	}

	/**
	 * @param Método que asigna el valor de la propiedad genreMostWinnerNormal.
	 */
	public void setGenreMostWinnerNormal(String genreMostWinnerNormal) {
		this.genreMostWinnerNormal = genreMostWinnerNormal;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad genreMostvictoryT
	 */
	public String getGenreMostvictoryT() {
		return genreMostvictoryT;
	}

	/**
	 * @param Método que asigna el valor de la propiedad genreMostvictoryT.
	 */
	public void setGenreMostvictoryT(String genreMostvictoryT) {
		this.genreMostvictoryT = genreMostvictoryT;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad personMostLuckWinnerWind
	 */
	public String getPersonMostLuckWinnerWind() {
		return personMostLuckWinnerWind;
	}

	/**
	 * @param Método que asigna el valor de la propiedad personMostLuckWinnerWind.
	 */
	public void setPersonMostLuckWinnerWind(String personMostLuckWinnerWind) {
		this.personMostLuckWinnerWind = personMostLuckWinnerWind;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad personMostluckWinnerRain
	 */
	public String getPersonMostluckWinnerRain() {
		return personMostluckWinnerRain;
	}

	/**
	 * @param Método que asigna el valor de la propiedad personMostluckWinnerRain.
	 */
	public void setPersonMostluckWinnerRain(String personMostluckWinnerRain) {
		this.personMostluckWinnerRain = personMostluckWinnerRain;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad personMostluckWinnerNormal
	 */
	public String getPersonMostluckWinnerNormal() {
		return personMostluckWinnerNormal;
	}

	/**
	 * @param Método que asigna el valor de la propiedad personMostluckWinnerNormal.
	 */
	public void setPersonMostluckWinnerNormal(String personMostluckWinnerNormal) {
		this.personMostluckWinnerNormal = personMostluckWinnerNormal;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad personMostExperienceWinnerWind
	 */
	public String getPersonMostExperienceWinnerWind() {
		return personMostExperienceWinnerWind;
	}

	/**
	 * @param Método que asigna el valor de la propiedad personMostExperienceWinnerWind.
	 */
	public void setPersonMostExperienceWinnerWind(String personMostExperienceWinnerWind) {
		this.personMostExperienceWinnerWind = personMostExperienceWinnerWind;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad personMostExperienceWinnerRain
	 */
	public String getPersonMostExperienceWinnerRain() {
		return personMostExperienceWinnerRain;
	}

	/**
	 * @param Método que asigna el valor de la propiedad personMostExperienceWinnerRain.
	 */
	public void setPersonMostExperienceWinnerRain(String personMostExperienceWinnerRain) {
		this.personMostExperienceWinnerRain = personMostExperienceWinnerRain;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad personMostExperienceWinnerNormal
	 */
	public String getPersonMostExperienceWinnerNormal() {
		return personMostExperienceWinnerNormal;
	}

	/**
	 * @param Método que asigna el valor de la propiedad personMostExperienceWinnerNormal.
	 */
	public void setPersonMostExperienceWinnerNormal(String personMostExperienceWinnerNormal) {
		this.personMostExperienceWinnerNormal = personMostExperienceWinnerNormal;
	}
}
