package sample;

import logic.GestorGame;
import logic.Archer;

/**
 * 
 * @author Duvis Alejandro G�mez Neira
 * @version 1.0
 */
public class Controller {
	private GestorGame gestorGame = new GestorGame();

	public void print() {
		Archer person = new Archer();
		for (int i = 0; i < gestorGame.getListRound().size(); i++) {
			System.out.println(
					"*********************************** ROUND " + (i + 1) + " ***********************************");
			for (int j = 0; j < gestorGame.getListRound().get(i).getListTeam().size(); j++) {
				System.out.println("--------------Equipo " + (j + 1) + "------------------------------");
				for (int k = 0; k < gestorGame.getListRound().get(i).getListTeam().get(j).getListPlayer().size(); k++) {
					for (int l = 0; l < gestorGame.getListRound().get(i).getListTeam().get(j).getListPlayer().get(k)
							.getListShot().size(); l++) {
						person = gestorGame.getListRound().get(i).getListTeam().get(j).getListPlayer().get(k);
						System.out.println("jugador: " + person.getNameArcher() + " | genero: " + person.getGender()
								+ " | Resistencia: " + person.getResistance() + " | Precisión: "
								+ person.getPrecision() + " | Distancia: " + person.getListShot().get(l).getDistance()
								+ " | suerte: " + person.getLuck() + " | distancia total: " + person.getTotalDistance()
								+ " | Experiencia: " + person.getExperience() + " | tiro extra: "
								+ person.getExtraShot());
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.print();
		System.out.println(
				"********************************** EQUIPO GANADOR EN CADA RONDA *********************************");
		for (int i = 0; i < GestorGame.NUMBER_ROUDS; i++) {
			System.out.println("Equipo ganador ronda: " + (i + 1) + " - "
					+ controller.gestorGame.getListRound().get(i).getTeamWinner().getNameTeam());
		}

		System.out.println(
				"********************************** PUNTOS DE SUERTE Y PUNTOS DE EXPERIENCIA POR PARTIDA *********************************");
		for (int i = 0; i < controller.gestorGame.getListGameWinner().size(); i++) {
			System.out.println("Partida: " + (i + 1) + " | puntos suerte: "
					+ controller.gestorGame.getListGameWinner().get(i).getAverageLuckPoint() + " | puntos experiencia: "
					+ controller.gestorGame.getListGameWinner().get(i).getAverageExperiencePoint());
		}
		System.out.println(
				"********************************** VICTORIA POR EQUIPO EN CADA ESCENARIO *********************************");
		for (int i = 0; i < controller.gestorGame.getListGameWinner().size(); i++) {
			System.out.println(controller.gestorGame.getListGameWinner().get(i).getTypeClimate() + " - Equipo: "
					+ controller.gestorGame.getListGameWinner().get(i).getTeamArcher().getNameTeam());
		}

		System.out.println(
				"****************************************** JUGADOR CON MAS SUERTE EN CADA ESCENARIO ******************************************************** ");
		System.out.println("Condicion LLUVIA: " + controller.gestorGame.getPersonMostluckWinnerRain());
		System.out.println("Condición VIENTO: " + controller.gestorGame.getPersonMostLuckWinnerWind());
		System.out.println("Condicion NORMAL: " + controller.gestorGame.getPersonMostluckWinnerNormal());

		System.out.println(
				"****************************************** JUGADOR CON MAS EXPERIENCIA EN CADA ESCENARIO ******************************************************** ");
		System.out.println("Condicion LLUVIA: " + controller.gestorGame.getPersonMostExperienceWinnerRain());
		System.out.println("Condición VIENTO: " + controller.gestorGame.getPersonMostExperienceWinnerWind());
		System.out.println("Condicion NORMAL: " + controller.gestorGame.getPersonMostExperienceWinnerNormal());

		System.out.println(
				"****************************************** EQUIPOS MAS GANADORES ******************************************************** ");
		System.out.println("Condicion LLUVIA: " + controller.gestorGame.getTeamMostWinnerRain());
		System.out.println("Condición VIENTO: " + controller.gestorGame.getTeamMostWinnerWind());
		System.out.println("Condicion NORMAL: " + controller.gestorGame.getTeamMostWinnerNormal());
		System.out.println("Equipo mas ganador todos los ESCENARIOS: " + controller.gestorGame.getTeamMostvictoryT());

		System.out.println(
				"****************************************** GENEROS MAS GANADORES ******************************************************** ");
		System.out.println("Condicion NORMAL: " + controller.gestorGame.getGenreMostWinnerNormal());
		System.out.println("Condicion LLUVIA: " + controller.gestorGame.getGenreMostWinnerRain());
		System.out.println("Condición VIENTO: " + controller.gestorGame.getGenreMostWinnerWind());
		System.out.println("Genero mas ganador todos los ESCENARIOS: " + controller.gestorGame.getGenreMostvictoryT());

		System.out.println(controller.gestorGame.getListGameWinner().size());
		System.out.println(controller.gestorGame.getListGameWinnerPErson().size());
	}
}
