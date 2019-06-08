package logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase controlador del juego de Arqueria
 * 
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public class HandlerGame {
	private ArrayList<Round> listRound;
	private ArrayList<TeamArcher> listTeam;
	private ArrayList<TeamArcher> listRoundWinnerTeam;
	private ArrayList<Game> listGameWinner;
	private ArrayList<Game> listGameWinnerArcher;

	private ManagerArcher managerArcher;
	private ManagerShot managerShot;
	private Game game;

	// Parámetros dados para la simulación
	public static final int NUMBER_TEAMS = 2;
	public static final double FACTOR_LUCK = 0.05;
	public static final int NUMBER_ROUNDS = 500;

	private ArrayList<Integer> listLuckPoint;
	private ArrayList<Integer> listExperiencePoint;
	private Random randomWeather;
	private ArrayList<Archer> listArcher;

	// Variables auxiliares para guardar el equipo con más victorias en cada uno de
	// los escenarios.
	private String teamMostWinnerWind = "";
	private String teamMostWinnerRain = "";
	private String teamMostWinnerNormal = "";
	private String teamMostvictoryTotal = "";

	// Variables auxiliares para guardar el géndero con más victorias en cada uno de
	// los escenarios.
	private String genderMostWinnerWind = "";
	private String genderMostWinnerRain = "";
	private String genderMostWinnerNormal = "";
	private String genderMostvictoryTotal = "";

	// Variables auxiliares para guardar el arquero con más suerte en cada uno de
	// los escenarios
	private String archerMostLuckWinnerWind;
	private String archerMostluckWinnerRain;
	private String archerMostluckWinnerNormal;

	// Variables auxiliares para guardar el arquero con más experiencia en cada uno
	// de los escenarios
	private String archerMostExperienceWinnerWind;
	private String archerMostExperienceWinnerRain;
	private String archerMostExperienceWinnerNormal;

	/**
	 * Método constructor de la clase controladora del juego de arqueria.
	 */
	public HandlerGame() {
		randomWeather = new Random();
		this.listGameWinnerArcher = new ArrayList<>();
		this.listArcher = new ArrayList<>();
		this.listRound = new ArrayList<>();
		this.listTeam = new ArrayList<>();
		this.listRoundWinnerTeam = new ArrayList<>();
		this.listGameWinner = new ArrayList<>();
		this.listExperiencePoint = new ArrayList<>();
		this.listLuckPoint = new ArrayList<>();
		managerArcher = new ManagerArcher();
		managerShot = new ManagerShot();
		addTeam();
		addRounds();
		teamWinGame();
		teamMostVictory();
		teamMostVictoryTotal();
		genderWithMoreTotalVicories();
		genderMostVictory();
		archerMostLuck();
		archerMostExperience();
	}

	/**
	 * Método que asigna los valores de los arqueros con más experiencia en cada uno
	 * de los escenarios
	 */
	public void archerMostExperience() {
		this.archerMostExperienceWinnerNormal = personMostExperiencePerStage(StageWeatherEnum.NORMAL);
		this.archerMostExperienceWinnerRain = personMostExperiencePerStage(StageWeatherEnum.RAIN);
		this.archerMostExperienceWinnerWind = personMostExperiencePerStage(StageWeatherEnum.WIND);
	}

	/**
	 * Método que permite obtener el arquero con más experiencia en un escenario.
	 * 
	 * @param weather Escenario en el cual se desea evaluar el arquero con mas
	 *                experiencia.
	 * @return
	 */
	public String personMostExperiencePerStage(StageWeatherEnum weather) {
		double auxExperience = 0.0;
		String archerStatistics = "";
		for (int i = 0; i < listGameWinner.size(); i++) {
			if (listGameWinner.get(i).getTypeClimate() == weather) {
				for (int j = 0; j < listGameWinnerArcher.get(i).getListPerson().size(); j++) {
					if (listGameWinnerArcher.get(i).getListPerson().get(j).getExperience() >= auxExperience) {
						archerStatistics = listGameWinnerArcher.get(i).getListPerson().get(j).getNameArcher()
								+ " --> Experiencia: " + listGameWinnerArcher.get(i).getListPerson().get(j).getExperience()
								+ "  --> Equipo: " + listGameWinner.get(i).getTeamArcher().getNameTeam();
						auxExperience = listGameWinnerArcher.get(i).getListPerson().get(j).getExperience();
					}
				}
			}
		}
		return archerStatistics;
	}

	/**
	 * Método que asigna los valores de los arqueros con más Suerte en cada uno de
	 * los escenarios
	 */
	public void archerMostLuck() {
		this.archerMostluckWinnerNormal = archerMostLuckPerStage(StageWeatherEnum.NORMAL);
		this.archerMostluckWinnerRain = archerMostLuckPerStage(StageWeatherEnum.RAIN);
		this.archerMostLuckWinnerWind = archerMostLuckPerStage(StageWeatherEnum.WIND);
	}

	/**
	 * Método que permite obtener el arquero con más Suerte en un escenario.
	 * 
	 * @param weather Escenario en el cual se desea evaluar el arquero con mas
	 *                Suerte.
	 * @return
	 */
	public String archerMostLuckPerStage(StageWeatherEnum weather) {
		double auxLuck = 0.0;
		String archerStatistics = "";
		for (int i = 0; i < listGameWinnerArcher.size(); i++) {
			if (listGameWinner.get(i).getTypeClimate() == weather) {
				for (int j = 0; j < listGameWinnerArcher.get(i).getListPerson().size(); j++) {
					if (listGameWinnerArcher.get(i).getListPerson().get(j).getLuck() >= auxLuck) {
						archerStatistics = listGameWinnerArcher.get(i).getListPerson().get(j).getNameArcher()
								+ " --> Suerte: " + listGameWinnerArcher.get(i).getListPerson().get(j).getLuck()
								+ "  --> Equipo: " + listGameWinner.get(i).getTeamArcher().getNameTeam();
						auxLuck = listGameWinnerArcher.get(i).getListPerson().get(j).getLuck();
					}
				}
			}
		}
		return archerStatistics;
	}

	/**
	 * Método que asigna los valores de los arqueros con más Victorias en cada uno
	 * de los escenarios
	 */
	public void genderMostVictory() {
		genderMostVictoryPerStage(StageWeatherEnum.NORMAL);
		genderMostVictoryPerStage(StageWeatherEnum.RAIN);
		genderMostVictoryPerStage(StageWeatherEnum.WIND);
	}

	/**
	 * Método que permite obtener el genero con más victorias en un escenario.
	 * 
	 * @param weather Escenario en el cual se desea evaluar el género con más
	 *                victorias.
	 * @return
	 */
	public void genderMostVictoryPerStage(StageWeatherEnum weather) {
		int victoryGenderMale = 0;
		int victoryGenderFemale = 0;

		for (int i = 0; i < listGameWinnerArcher.size(); i++) {
			victoryGenderMale = 0;
			victoryGenderFemale = 0;
			if (listGameWinner.get(i).getTypeClimate() == weather) {
				for (int j = 0; j < listGameWinnerArcher.get(i).getListPerson().size(); j++) {
					if (listGameWinnerArcher.get(i).getListPerson().get(j).getGender() == GenderEnum.MALE) {
						victoryGenderMale++;
					} else if (listGameWinnerArcher.get(i).getListPerson().get(j).getGender() == GenderEnum.FEMALE) {
						victoryGenderFemale++;
					}
				}
				if (victoryGenderMale > victoryGenderFemale) {
					if (weather == StageWeatherEnum.NORMAL) {
						this.genderMostWinnerNormal = GenderEnum.MALE.gender;
					} else if (weather == StageWeatherEnum.RAIN) {
						this.genderMostWinnerRain = GenderEnum.MALE.gender;
					} else if (weather == StageWeatherEnum.WIND) {
						this.genderMostWinnerWind = GenderEnum.MALE.gender;
					}
				} else if (victoryGenderMale < victoryGenderFemale) {
					if (weather == StageWeatherEnum.NORMAL) {
						this.genderMostWinnerNormal = GenderEnum.FEMALE.gender;
					} else if (weather == StageWeatherEnum.RAIN) {
						this.genderMostWinnerRain = GenderEnum.FEMALE.gender;
					} else if (weather == StageWeatherEnum.WIND) {
						this.genderMostWinnerWind = GenderEnum.FEMALE.gender;
					}
				} else if (victoryGenderMale == victoryGenderFemale) {
					if (weather == StageWeatherEnum.NORMAL) {
						this.genderMostWinnerNormal = "Empate";
					} else if (weather == StageWeatherEnum.RAIN) {
						this.genderMostWinnerRain = "Empate";
					} else if (weather == StageWeatherEnum.WIND) {
						this.genderMostWinnerWind = "Empate";
					}
				}
			}
		}
	}

	/**
	 * Método que permite obtener el género con más victorias totales.
	 */
	public void genderWithMoreTotalVicories() {
		int auxGenderMale = 0;
		int auxGenderFemale = 0;
		for (Round round : listRound) {
			if (round.getRoundWinnerA().getGender() == GenderEnum.MALE) {
				auxGenderMale++;
			} else if (round.getRoundWinnerA().getGender() == GenderEnum.FEMALE) {
				auxGenderFemale++;
			}
			if (round.getRoundWinnerB().getGender() == GenderEnum.MALE) {
				auxGenderMale++;
			} else if (round.getRoundWinnerB().getGender() == GenderEnum.FEMALE) {
				auxGenderFemale++;
			}
		}
		if (auxGenderMale > auxGenderFemale) {
			this.genderMostvictoryTotal = GenderEnum.MALE.gender;
		} else if (auxGenderMale < auxGenderFemale) {
			this.genderMostvictoryTotal = GenderEnum.FEMALE.gender;
		} else if (auxGenderMale == auxGenderFemale) {
			this.genderMostvictoryTotal = "Empate";
		}
	}

	/**
	 * Método que permite obtener el equipo con más victorias en total
	 */
	public void teamMostVictoryTotal() {
		int auxTeamA = 0;
		int auxTeamB = 0;
		for (Game game : listGameWinner) {
			if (game.getTeamArcher().getNameTeam().equalsIgnoreCase("Equipo 1")) {
				auxTeamA++;
			} else {
				auxTeamB++;
			}
		}
		if (auxTeamA > auxTeamB) {
			this.teamMostvictoryTotal = "Equipo 1";
		} else if (auxTeamA < auxTeamB) {
			this.teamMostvictoryTotal = "Equipo 2";
		} else if (auxTeamA == auxTeamB) {
			this.teamMostvictoryTotal = "Empate";
		}
	}

	/**
	 * Método que permite obtener el equipo con más victorias en cada uno de los
	 * escenarios
	 */
	public void teamMostVictory() {
		teamMostVictoryPerStage(StageWeatherEnum.WIND);
		teamMostVictoryPerStage(StageWeatherEnum.RAIN);
		teamMostVictoryPerStage(StageWeatherEnum.NORMAL);
	}

	/**
	 * Método que permite obtener el equipo con más victorias en un escenario.
	 * 
	 * @param weather Escenario en el cual se desea evaluar el equipo con más
	 *                victorias.
	 * @return
	 */
	public void teamMostVictoryPerStage(StageWeatherEnum weather) {
		int auxTeamA = 0;
		int auxTeamB = 0;
		for (Game game : this.listGameWinner) {
			if (game.getTypeClimate() == weather) {
				if (game.getTeamArcher().getNameTeam().equalsIgnoreCase("Equipo 1")) {
					auxTeamA++;
				} else {
					auxTeamB++;
				}
			}
		}
		if (auxTeamA > auxTeamB) {
			if (weather == StageWeatherEnum.NORMAL) {
				this.teamMostWinnerNormal = "Equipo 1";
			} else if (weather == StageWeatherEnum.RAIN) {
				this.teamMostWinnerRain = "Equipo 1";
			} else if (weather == StageWeatherEnum.WIND) {
				this.teamMostWinnerWind = "Equipo 1";
			}
		} else if (auxTeamA < auxTeamB) {
			if (weather == StageWeatherEnum.NORMAL) {
				this.teamMostWinnerNormal = "Equipo 2";
			} else if (weather == StageWeatherEnum.RAIN) {
				this.teamMostWinnerRain = "Equipo 2";
			} else if (weather == StageWeatherEnum.WIND) {
				this.teamMostWinnerWind = "Equipo 2";
			}
		} else if (auxTeamA == auxTeamB) {
			if (weather == StageWeatherEnum.NORMAL) {
				this.teamMostWinnerNormal = "Empate";
			} else if (weather == StageWeatherEnum.RAIN) {
				this.teamMostWinnerRain = "Empate";
			} else if (weather == StageWeatherEnum.WIND) {
				this.teamMostWinnerWind = "Empate";
			}
		}
	}

	/**
	 * Método que incluye el factor de afectación por las variables exógenas.
	 * 
	 * @param shot
	 * @param climate
	 * @return
	 */
	public double climateFactor(double shot, StageWeatherEnum climate) {
		if (climate == StageWeatherEnum.WIND) {
			// Cuando hay viento en contra los lanzamientos son 0.04% más cortos
			return shot * 0.96;
		} else if (climate == StageWeatherEnum.RAIN) {
			// Cuando hay lluvia los lanzamientos son 0,08% más cortos
			return shot * 0.92;
		} else {
			return shot;
		}
	}

	/**
	 * Método que genera una variable climatica de forma aleatoria.
	 * 
	 * @return
	 */
	public StageWeatherEnum climate() {
		int gender = randomWeather.nextInt(3);
		if (gender == 1) {
			return StageWeatherEnum.WIND;
		} else if (gender == 2) {
			return StageWeatherEnum.RAIN;
		} else
			return StageWeatherEnum.NORMAL;
	}

	/**
	 * Método que permite obtener el equipo con mas victorias totales.
	 */
	public void teamWinGame() {
		int auxWinnerRoundTeamA = 0;
		int auxWinnerRoundTeamB = 0;
		StageWeatherEnum weather;

		for (TeamArcher teamArcher : this.listRoundWinnerTeam) {
			weather = climate();
			for (Archer archer : teamArcher.getListPlayer()) {
				for (Shot shot : archer.getListShot()) {
					shot.setDistance(climateFactor(shot.getDistance(), weather));
				}
			}
			if (teamArcher.getNameTeam().equalsIgnoreCase("Equipo 1")) {
				auxWinnerRoundTeamA++;
			} else if (teamArcher.getNameTeam().equalsIgnoreCase("Equipo 2")) {
				auxWinnerRoundTeamB++;
			}

			// Gana una partida el equipo que gane 10 rondas.
			if (auxWinnerRoundTeamA == 10 || auxWinnerRoundTeamB == 10) {
				listGameWinner.add(new Game(teamArcher, weather, (auxWinnerRoundTeamA + auxWinnerRoundTeamB) * 2,
						(auxWinnerRoundTeamA + auxWinnerRoundTeamB)));
				listGameWinnerArcher.add(new Game(teamArcher.getListPlayer()));
				auxWinnerRoundTeamA = 0;
				auxWinnerRoundTeamB = 0;
			}
		}
	}

	/**
	 * Método que permite agregar un equipo a la lista de equipos ganadores por
	 * ronda.
	 * 
	 * @param teamArcher
	 */
	public void addListWinnerRound(TeamArcher teamArcher) {
		this.listRoundWinnerTeam.add(teamArcher);
	}

	/**
	 * Método que permite determinar el equipo ganador en una ronda.
	 * 
	 * @return
	 */
	public TeamArcher teamWinnerRound(ArrayList<TeamArcher> teamArcher) {
		if (teamArcher.get(0).getTeamShotDistance() > teamArcher.get(1).getTeamShotDistance()) {
			return teamArcher.get(0);
		} else {
			return teamArcher.get(1);
		}
	}

	/**
	 * Método que permite obtener la distancia total obtenido por equipo.
	 * 
	 * @param listArcher Lista de arqueros del equipo.
	 * @return
	 */
	public double distanceTotalForTeam(ArrayList<Archer> listArcher) {
		double auxDistanceTotal = 0.0;
		for (int i = 0; i < listArcher.size(); i++) {
			auxDistanceTotal += listArcher.get(i).getTotalDistance();
		}
		return auxDistanceTotal;
	}

	/**
	 * Método que permite añadir a la lista de rounds una lista de equipos.
	 */
	public void addRounds() {
		for (int i = 0; i < NUMBER_ROUNDS; i++) {
			ArrayList<TeamArcher> auxListTeamArcher = new ArrayList<>();
			copyArray(listTeam, auxListTeamArcher);
			distanceTotalSum(auxListTeamArcher.get(0).getListPlayer());
			distanceTotalSum(auxListTeamArcher.get(1).getListPlayer());

			// En cada ronda se sortea un lanzamiento por equipo, el cual será otorgado al
			// jugador con más suerte en cada uno de ellos.
			addShotDraw(auxListTeamArcher, shotDraw(auxListTeamArcher.get(0).getListPlayer()),
					shotDraw(auxListTeamArcher.get(1).getListPlayer()));

			// Añade un nuevo round a la lista de rounds
			listRound.add(new Round(i, auxListTeamArcher));

			// Asigna el ganador individual del equpipoA al round
			listRound.get(i).setRoundWinnerA(personRoundWinner(auxListTeamArcher.get(0).getListPlayer()));

			// Asigna el ganador individual del equpipoB al round
			listRound.get(i).setRoundWinnerB(personRoundWinner(auxListTeamArcher.get(1).getListPlayer()));

			listRound.get(i).getListTeam().get(0)
					.setTeamShotDistance(distanceTotalForTeam(auxListTeamArcher.get(0).getListPlayer()));
			listRound.get(i).getListTeam().get(1)
					.setTeamShotDistance(distanceTotalForTeam(auxListTeamArcher.get(1).getListPlayer()));

			// Gana una ronda grupal el equipo que obtenga más distancia en sus
			// lanzamientos.
			listRound.get(i).setTeamWinner(teamWinnerRound(auxListTeamArcher));

			addListWinnerRound(listRound.get(i).getTeamWinner());

			// Cuando un arquero gana una ronda suma 2 puntos de experiencia
			addExperienceArcher(listRound.get(i).getRoundWinnerA(),
					listRound.get(i).getListTeam().get(0).getListPlayer());// aumenta experiencia 1 equipo
			addExperienceArcher(listRound.get(i).getRoundWinnerB(),
					listRound.get(i).getListTeam().get(1).getListPlayer());// aumenta experiencia 2 equipo
			listTeam = listRound.get(i).getListTeam();
		}

	}

	/**
	 * Método que permite validar si un arquero a adquirido 8 puntos de experiencia
	 * 
	 * @param archer Arquero del cual se desean validar los puntos de experiencia
	 *               ganada.
	 * @return
	 */
	public boolean isExperienceWin(Archer archer) {
		// Se valida con el numero 18 debido a que el arquero incia con 10 puntos de
		// experiencia.
		return archer.getExperience() >= 18;
	}

	/**
	 * Método que añade dos puntos de experiencia al arquero ganador de una ronda.
	 * 
	 * @param archer     Arquero al cual se le desea añadir experiencia
	 * @param listArcher Lista de arqueros a la que pertyenece el jugadro al que se
	 *                   le desea agregar experiencia.
	 */
	public void addExperienceArcher(Archer archer, ArrayList<Archer> listArcher) {
		for (int i = 0; i < listArcher.size(); i++) {
			if (archer.equals(listArcher.get(i))) {
				listArcher.get(i).setExperience(listArcher.get(i).getExperience() + 2);
			}
		}
	}

	/**
	 * Método que permite obtener el judador con el lanzamiento mas largo de una
	 * lista de arqueros
	 * 
	 * @param listArcher Lista de arqueros de la cual se quiere saber quien realizó
	 *                   el lanzamiento más largo.
	 * @return
	 */
	public Archer personRoundWinner(ArrayList<Archer> listArcher) {
		Archer person = listArcher.get(0);
		for (int i = 1; i < listArcher.size(); i++) {
			if (listArcher.get(i).getTotalDistance() > person.getTotalDistance()) {
				person = listArcher.get(i);
			}
		}
		return person;
	}

	/**
	 * Método que permite obtener la suma de la distancia total de todos los tiros
	 * de una lista de arqueros
	 * 
	 * @param listArcher Lista de arqueros de los cuales se desea sumar la distancia
	 *                   de sus lanazamientos.
	 * @return
	 */
	public void distanceTotalSum(ArrayList<Archer> listArcher) {
		double auxDistance = 0.0;
		int auxQuantityShots = 0;
		for (int i = 0; i < listArcher.size(); i++) {
			for (int j = 0; j < listArcher.get(i).getListShot().size(); j++) {
				auxDistance += listArcher.get(i).getListShot().get(j).getDistance();
			}
			auxQuantityShots = listArcher.get(i).getListShot().size();
			listArcher.get(i).setTotalDistance(auxDistance / auxQuantityShots);
			auxDistance = 0.0;
			auxQuantityShots = 0;
		}
	}

	/**
	 * Método que incrementa la suerte de un arquero cuando tiene 3 lanzamientos
	 * extra
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
	 * Método que agrega un tiro adicional a la persona con más suerte de cada
	 * equipo.
	 * 
	 * @param listTeamArcher              Lista de lo equipos de arqueros
	 * @param positionArcherMostLuckTeamA Posición del arquero con más suerte del
	 *                                    equipo A
	 * @param positionArcherMostLuckTeamB Posición del arquero con más suerte del
	 *                                    equipo B
	 */
	public void addShotDraw(ArrayList<TeamArcher> listTeamArcher, int positionArcherMostLuckTeamA,
			int positionArcherMostLuckTeamB) {
		// Agrega un tiro adicional a la persona con más suerte de cada equipo A.
		listTeamArcher.get(0).getListPlayer().get(positionArcherMostLuckTeamA).getListShot()
				.add(new Shot(managerShot.calculateVelocity(), managerShot.calculateAngle()));

		// Agrega el valor de la distancia del tiro adicional
		listTeamArcher.get(0).getListPlayer().get(positionArcherMostLuckTeamA).getListShot()
				.get(listTeamArcher.get(0).getListPlayer().get(positionArcherMostLuckTeamA).getListShot().size() - 1)
				.setDistance(
						managerShot.calculateDistance(managerShot.calculateVelocity(), managerShot.calculateAngle()));
		// Agrega un tiro a las estaditica del arquero
		listTeamArcher.get(0).getListPlayer().get(positionArcherMostLuckTeamA).setExtraShot(
				listTeamArcher.get(0).getListPlayer().get(positionArcherMostLuckTeamA).getExtraShot() + 1);

		// Si un jugador gana tres lanzamientos extra de forma consecutiva, su suerte
		// aumentaen 0.05
		validateExtraShot(listTeamArcher.get(0).getListPlayer(), positionArcherMostLuckTeamA);
		luckIncrease(listTeamArcher.get(0).getListPlayer());

		// Agrega un tiro adicional a la persona con más suerte de cada equipo B.
		listTeamArcher.get(1).getListPlayer().get(positionArcherMostLuckTeamB).getListShot()
				.add(new Shot(managerShot.calculateVelocity(), managerShot.calculateAngle()));

		// Agrega el valor de la distancia del tiro adicional
		listTeamArcher.get(1).getListPlayer().get(positionArcherMostLuckTeamB).getListShot()
				.get(listTeamArcher.get(1).getListPlayer().get(positionArcherMostLuckTeamB).getListShot().size() - 1)
				.setDistance(
						managerShot.calculateDistance(managerShot.calculateVelocity(), managerShot.calculateAngle()));

		// Agrega un tiro a las estaditica del arquero
		listTeamArcher.get(1).getListPlayer().get(positionArcherMostLuckTeamB).setExtraShot(
				listTeamArcher.get(1).getListPlayer().get(positionArcherMostLuckTeamB).getExtraShot() + 1);

		// Si un jugador gana tres lanzamientos extra de forma consecutiva, su suerte
		// aumentaen 0.05
		validateExtraShot(listTeamArcher.get(1).getListPlayer(), positionArcherMostLuckTeamB);
		luckIncrease(listTeamArcher.get(1).getListPlayer());
	}

	/**
	 * Método para validar que los tiros extra son realizados de forma consecutiva.
	 * 
	 * @param listArcher                    Lista de arqueros
	 * @param currentPositionArcherMostLuck Posición actual del arquero con más
	 *                                      suerte.
	 */
	public void validateExtraShot(ArrayList<Archer> listArcher, int currentPositionArcherMostLuck) {
		for (int i = 0; i < listArcher.size(); i++) {
			// Si la posicion actual es diferente a la de la posicion del actual ganador, se
			// reestablece el contador del tiro extra
			if (i != currentPositionArcherMostLuck) {
				listArcher.get(i).setExtraShot(0);
			}
		}
	}

	/**
	 * Método que permite obtener la posición del arquero con más suerte del equipo
	 * 
	 * @param listArqueros Lista de arqueros de la cual se desea obtener la posición
	 *                     del arquero con más suerte.
	 * @return
	 */
	public int shotDraw(ArrayList<Archer> listArqueros) {
		double aux = 0.0;
		int a = 0;
		for (int i = 0; i < listArqueros.size(); i++) {
			if (aux < listArqueros.get(i).getLuck()) {
				aux = listArqueros.get(i).getLuck();
			}
		}
		for (int i = 0; i < listArqueros.size(); i++) {
			a = i;
			if (aux == listArqueros.get(i).getLuck()) {
				break;
			}
		}
		return a;
	}

	/**
	 * Método que permite agregar una cantidad de equipos de un juego.
	 */
	public void addTeam() {
		for (int i = 0; i < NUMBER_TEAMS; i++) {
			this.listTeam.add(new TeamArcher("Equipo " + (i + 1)));
		}
	}

	/**
	 * Método que permite copiar los valores de un arreglo quitando la dependecia de
	 * las referencias de memoria. Esto es para recalcular la distancia y la suerte
	 * 
	 * @param listTeamArcher     Arreglo que se desea copiar
	 * @param listCopyTeamArcher Arreglo con los valores del arreglo original con
	 *                           apuntadores diferentes.
	 */
	public void copyArray(ArrayList<TeamArcher> listTeamArcher, ArrayList<TeamArcher> listCopyTeamArcher) {
		double auxDistance = 0.0;
		// Ciclo que recorre la lista de equipos
		for (int i = 0; i < listTeamArcher.size(); i++) {
			listCopyTeamArcher.add(new TeamArcher());
			// Ciclo que recorre la lista de jugadores de un equipo
			for (int j = 0; j < listTeamArcher.get(i).getListPlayer().size(); j++) {
				Archer person = listTeamArcher.get(i).getListPlayer().get(j);

				// Copia de los valores de los atributos de la lista original a la lista de
				// copia.
				listCopyTeamArcher.get(i).getListPlayer()
						.add(new Archer(person.getGender(), person.getNameArcher(), person.getDateOfBirth()));
				listCopyTeamArcher.get(i).getListPlayer().get(j).setPrecision(new Integer(person.getPrecision()));
				listCopyTeamArcher.get(i).getListPlayer().get(j).setResistance(new Integer(person.getResistance()));
				listCopyTeamArcher.get(i).getListPlayer().get(j).setExperience(new Integer(person.getExperience()));
				listCopyTeamArcher.get(i).getListPlayer().get(j).setExtraShot(new Integer(person.getExtraShot()));
				listCopyTeamArcher.get(i).getListPlayer().get(j).setGender(person.getGender());

				// Permite volver a calcular la suerte
				listCopyTeamArcher.get(i).getListPlayer().get(j).setLuck(new Double(managerArcher.archerLuck()));

				listCopyTeamArcher.get(i).setNameTeam(listTeamArcher.get(i).getNameTeam());
				// Ciclo que recorre la listade tiros realizada por cada jugador de cada equipo.
				for (int k = 0; k < listTeamArcher.get(i).getListPlayer().get(j).getListShot().size(); k++) {
					int velocity = managerShot.calculateVelocity();
					int angle = managerShot.calculateAngle();
					listCopyTeamArcher.get(i).getListPlayer().get(j).getListShot().add(new Shot(velocity, angle));
					auxDistance = managerShot.calculateDistance(velocity, angle);

					// Si un arquero suma 8 puntos de experiencia, cada uno de sus lanzamientos es
					// 0.025% más extenso
					if (isExperienceWin(listCopyTeamArcher.get(i).getListPlayer().get(j))) {
						listCopyTeamArcher.get(i).getListPlayer().get(j).getListShot().get(k)
								.setDistance(auxDistance * 1.025);
					} else {
						listCopyTeamArcher.get(i).getListPlayer().get(j).getListShot().get(k).setDistance(auxDistance);
					}
				}
			}
		}
	}

	// Creación de los métodos setters y getters
	/**
	 * @return Método que obtiene el valor de la propiedad listRound.
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
	 * @return Método que obtiene el valor de la propiedad listTeam.
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
	 * @return Método que obtiene el valor de la propiedad gestorPerson.
	 */
	public ManagerArcher getGestorPerson() {
		return managerArcher;
	}

	/**
	 * @param Método que asigna el valor de la propiedad gestorPerson.
	 */
	public void setGestorPerson(ManagerArcher gestorPerson) {
		this.managerArcher = gestorPerson;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad gestorShot.
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
	 * @return Método que obtiene el valor de la propiedad listRoundWinnerTeam.
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
	 * @return Método que obtiene el valor de la propiedad game.
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
	 * @return Método que obtiene el valor de la propiedad listGameWinner.
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
	 * @return Método que obtiene el valor de la propiedad listGameWinnerPErson.
	 */
	public ArrayList<Game> getListGameWinnerPerson() {
		return listGameWinnerArcher;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listGameWinnerPErson.
	 */
	public void setListGameWinnerPErson(ArrayList<Game> listGameWinnerPErson) {
		this.listGameWinnerArcher = listGameWinnerPErson;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad listLuckPoint.
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
	 * @return Método que obtiene el valor de la propiedad listExperiencePoint.
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
	 * @return Método que obtiene el valor de la propiedad randomClimate.
	 */
	public Random getRandomClimate() {
		return randomWeather;
	}

	/**
	 * @param Método que asigna el valor de la propiedad randomClimate.
	 */
	public void setRandomClimate(Random randomClimate) {
		this.randomWeather = randomClimate;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad listPlayer.
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
	 * @return Método que obtiene el valor de la propiedad teamMostWinnerWind.
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
	 * @return Método que obtiene el valor de la propiedad teamMostWinnerRain.
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
	 * @return Método que obtiene el valor de la propiedad teamMostWinnerNormal.
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
	 * @return Método que obtiene el valor de la propiedad teamMostvictoryT.
	 */
	public String getTeamMostvictoryT() {
		return teamMostvictoryTotal;
	}

	/**
	 * @param Método que asigna el valor de la propiedad teamMostvictoryT.
	 */
	public void setTeamMostvictoryT(String teamMostvictoryT) {
		this.teamMostvictoryTotal = teamMostvictoryT;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad genreMostWinnerWind.
	 */
	public String getGenderMostWinnerWind() {
		return genderMostWinnerWind;
	}

	/**
	 * @param Método que asigna el valor de la propiedad genreMostWinnerWind.
	 */
	public void setGenreMostWinnerWind(String genreMostWinnerWind) {
		this.genderMostWinnerWind = genreMostWinnerWind;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad genreMostWinnerRain.
	 */
	public String getGenderMostWinnerRain() {
		return genderMostWinnerRain;
	}

	/**
	 * @param Método que asigna el valor de la propiedad genreMostWinnerRain.
	 */
	public void setGenreMostWinnerRain(String genreMostWinnerRain) {
		this.genderMostWinnerRain = genreMostWinnerRain;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad genreMostWinnerNormal.
	 */
	public String getGenderMostWinnerNormal() {
		return genderMostWinnerNormal;
	}

	/**
	 * @param Método que asigna el valor de la propiedad genreMostWinnerNormal.
	 */
	public void setGenreMostWinnerNormal(String genreMostWinnerNormal) {
		this.genderMostWinnerNormal = genreMostWinnerNormal;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad genreMostvictoryT.
	 */
	public String getGenreMostvictoryT() {
		return genderMostvictoryTotal;
	}

	/**
	 * @param Método que asigna el valor de la propiedad genreMostvictoryT.
	 */
	public void setGenreMostvictoryT(String genreMostvictoryT) {
		this.genderMostvictoryTotal = genreMostvictoryT;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad personMostLuckWinnerWind.
	 */
	public String getPersonMostLuckWinnerWind() {
		return archerMostLuckWinnerWind;
	}

	/**
	 * @param Método que asigna el valor de la propiedad personMostLuckWinnerWind.
	 */
	public void setPersonMostLuckWinnerWind(String personMostLuckWinnerWind) {
		this.archerMostLuckWinnerWind = personMostLuckWinnerWind;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad personMostluckWinnerRain.
	 */
	public String getPersonMostluckWinnerRain() {
		return archerMostluckWinnerRain;
	}

	/**
	 * @param Método que asigna el valor de la propiedad personMostluckWinnerRain.
	 */
	public void setPersonMostluckWinnerRain(String personMostluckWinnerRain) {
		this.archerMostluckWinnerRain = personMostluckWinnerRain;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad
	 *         personMostluckWinnerNormal.
	 */
	public String getPersonMostluckWinnerNormal() {
		return archerMostluckWinnerNormal;
	}

	/**
	 * @param Método que asigna el valor de la propiedad personMostluckWinnerNormal.
	 */
	public void setPersonMostluckWinnerNormal(String personMostluckWinnerNormal) {
		this.archerMostluckWinnerNormal = personMostluckWinnerNormal;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad
	 *         personMostExperienceWinnerWind.
	 */
	public String getPersonMostExperienceWinnerWind() {
		return archerMostExperienceWinnerWind;
	}

	/**
	 * @param Método que asigna el valor de la propiedad
	 *               personMostExperienceWinnerWind.
	 */
	public void setPersonMostExperienceWinnerWind(String personMostExperienceWinnerWind) {
		this.archerMostExperienceWinnerWind = personMostExperienceWinnerWind;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad
	 *         personMostExperienceWinnerRain.
	 */
	public String getPersonMostExperienceWinnerRain() {
		return archerMostExperienceWinnerRain;
	}

	/**
	 * @param Método que asigna el valor de la propiedad
	 *               personMostExperienceWinnerRain.
	 */
	public void setPersonMostExperienceWinnerRain(String personMostExperienceWinnerRain) {
		this.archerMostExperienceWinnerRain = personMostExperienceWinnerRain;
	}

	/**
	 * @return Método que obtiene el valor de la propiedad
	 *         personMostExperienceWinnerNormal.
	 */
	public String getPersonMostExperienceWinnerNormal() {
		return archerMostExperienceWinnerNormal;
	}

	/**
	 * @param Método que asigna el valor de la propiedad
	 *               personMostExperienceWinnerNormal.
	 */
	public void setPersonMostExperienceWinnerNormal(String personMostExperienceWinnerNormal) {
		this.archerMostExperienceWinnerNormal = personMostExperienceWinnerNormal;
	}
}
