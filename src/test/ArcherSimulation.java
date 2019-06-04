package test;

import logic.HandlerGame;
import logic.Archer;

/**
 * Clase principal de la aplicación.
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public class ArcherSimulation {
	private HandlerGame handlerGame = new HandlerGame();

	public void printStatistics() {
		
		Archer archer = new Archer();
		for (int i = 0; i < handlerGame.getListRound().size(); i++) {
			System.out.println("Número de Round: " + (i + 1) + " ······································");
			for (int j = 0; j < handlerGame.getListRound().get(i).getListTeam().size(); j++) {
				if (j!= 0) {
					System.out.println("\n");
				}
				System.out.println("	Equipo: " + (j + 1) + " ·······································");
				for (int k = 0; k < handlerGame.getListRound().get(i).getListTeam().get(j).getListPlayer().size(); k++) {
					for (int l = 0; l < handlerGame.getListRound().get(i).getListTeam().get(j).getListPlayer().get(k)
							.getListShot().size(); l++) {
						archer = handlerGame.getListRound().get(i).getListTeam().get(j).getListPlayer().get(k);
						if (l == 0) {
							if (k != 0) {
								System.out.println();
							}
							System.out.println("		Jugador: " + archer.getNameArcher() + " || Género: " + archer.getGender().toString().substring(0, 1)
									+ " || Resistencia: " + archer.getResistance() + " || Precisión: "
									+ archer.getPrecision() + " || Distancia Total: " +  archer.getTotalDistance()
									+ " || Suerte: " + archer.getLuck());
						}
							System.out.println( "			Disparo " + (l+1) + " --> Distancia: " +  archer.getListShot().get(l).getDistance()
								+ " || Experiencia: " + archer.getExperience() + " || Tiros extra: "
								+ archer.getExtraShot());
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ArcherSimulation controller = new ArcherSimulation();
		controller.printStatistics();
		System.out.println("\n\nMétricas  ·······································");
		System.out.println("	Equipo ganador en cada ronda:");
		for (int i = 0; i < HandlerGame.NUMBER_ROUNDS; i++) {
			System.out.println("		Ronda " + (i + 1) + " -->  Ganador "
					+ controller.handlerGame.getListRound().get(i).getTeamWinner().getNameTeam());
		}

		System.out.println("\n	Promedio de puntos de suerte y experiencia ganados por partida:"); 	
		for (int i = 0; i < controller.handlerGame.getListGameWinner().size(); i++) {
			System.out.println("		Partida " + (i + 1) + ": --> Puntos de suerte "
					+ controller.handlerGame.getListGameWinner().get(i).getAverageLuckPoint()/10 + " || Puntos experiencia: "
					+ controller.handlerGame.getListGameWinner().get(i).getAverageExperiencePoint()/10);
		}
		
		System.out.println("\n	Victoria por equipo en cada escenario:");
		for (int i = 0; i < controller.handlerGame.getListGameWinner().size(); i++) {
			System.out.println("		Escenario "+controller.handlerGame.getListGameWinner().get(i).getTypeClimate() + " --> Ganador: "
					+ controller.handlerGame.getListGameWinner().get(i).getTeamArcher().getNameTeam());
		}

		System.out.println("\n	Jugador con más suerte por escenario");
		System.out.println("		Condición normal: " + controller.handlerGame.getPersonMostluckWinnerNormal());
		System.out.println("		Condición lluvia: " + controller.handlerGame.getPersonMostluckWinnerRain());
		System.out.println("		Condición viento: " + controller.handlerGame.getPersonMostLuckWinnerWind());

		System.out.println("\n	Jugador con más experiencia por escenario");
		System.out.println("		Condición normal: " + controller.handlerGame.getPersonMostExperienceWinnerNormal());
		System.out.println("		Condición lluvia: " + controller.handlerGame.getPersonMostExperienceWinnerRain());
		System.out.println("		Condición viento: " + controller.handlerGame.getPersonMostExperienceWinnerWind());

		System.out.println("\n	Equipo con más victorias por escenario");
		System.out.println("		Condición normal: " + controller.handlerGame.getTeamMostWinnerNormal());
		System.out.println("		Condición lluvia: " + controller.handlerGame.getTeamMostWinnerRain());
		System.out.println("		Condición viento: " + controller.handlerGame.getTeamMostWinnerWind());
		System.out.println("		Equipo mas ganador en todos los escenarios: " + controller.handlerGame.getTeamMostvictoryT());

		System.out.println("\n	Género con más victorias por escenario");
		System.out.println("		Condición normal: " + controller.handlerGame.getGenderMostWinnerNormal());
		System.out.println("		Condición lluvia: " + controller.handlerGame.getGenderMostWinnerRain());
		System.out.println("		Condición viento: " + controller.handlerGame.getGenderMostWinnerWind());
		System.out.println("		Género más ganador todos los escenarios: " + controller.handlerGame.getGenreMostvictoryT());

//		System.out.println("Cantidad de rondas disputadas");
//		System.out.println(controller.handlerGame.getListGameWinner().size());
//		System.out.println(controller.handlerGame.getListGameWinnerPerson().size());
	}
}
