package logic;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que permite definir los atributos de un arquero
 * @author Duvis Alejandro Gómez Neira
 * @version 1.0
 */
public class Archer {
	// Información personal
	private String nameArcher;
	private GenderEnum gender;
	private Date dateOfBirth;

	// Habilidades
	private int precision;
	private int resistance;
	private int experience;
	private double luck;

	// Información para estadísticas
	private String team;
	private ArrayList<Shot> listShot;

	// Variables auxiliares
	private int resistenceOriginal;
	private int precisionOriginal;
	private double totalDistance;
	private int extraShot;

	/**
	 * Constructor de la clase arquero
	 * 
	 * @param genderArcher Género del arquero
	 * @param nameArcher   Nombre del arquero
	 * @param dateOfBirth  Fecha de nacimiento del arquero
	 */
	public Archer(GenderEnum genderArcher, String nameArcher, Date dateOfBirth) {
		this.gender = genderArcher;
		this.nameArcher = nameArcher;
		this.dateOfBirth = dateOfBirth;
		this.experience = 10;
		this.listShot = new ArrayList<>();
	}

	public Archer() {
	}

	//Creación de los métodos setters y getters
	/**
	 * @return  Método que obtiene el valor de la propiedad nameArcher.
	 */
	public String getNameArcher() {
		return nameArcher;
	}

	/**
	 * @param Método que asigna el valor de la propiedad nameArcher.
	 */
	public void setNameArcher(String nameArcher) {
		this.nameArcher = nameArcher;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad gender.
	 */
	public GenderEnum getGender() {
		return gender;
	}

	/**
	 * @param Método que asigna el valor de la propiedad gender.
	 */
	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad dateOfBirth.
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param Método que asigna el valor de la propiedad dateOfBirth.
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad precision.
	 */
	public int getPrecision() {
		return precision;
	}

	/**
	 * @param Método que asigna el valor de la propiedad precision.
	 */
	public void setPrecision(int precision) {
		this.precision = precision;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad resistance.
	 */
	public int getResistance() {
		return resistance;
	}

	/**
	 * @param Método que asigna el valor de la propiedad resistance.
	 */
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad experience.
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * @param Método que asigna el valor de la propiedad experience.
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad luck.
	 */
	public double getLuck() {
		return luck;
	}

	/**
	 * @param Método que asigna el valor de la propiedad luck.
	 */
	public void setLuck(double luck) {
		this.luck = luck;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad team.
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * @param Método que asigna el valor de la propiedad team.
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad listShot.
	 */
	public ArrayList<Shot> getListShot() {
		return listShot;
	}

	/**
	 * @param Método que asigna el valor de la propiedad listShot.
	 */
	public void setListShot(ArrayList<Shot> listShot) {
		this.listShot = listShot;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad resistenceOriginal.
	 */
	public int getResistenceOriginal() {
		return resistenceOriginal;
	}

	/**
	 * @param Método que asigna el valor de la propiedad resistenceOriginal.
	 */
	public void setResistenceOriginal(int resistenceOriginal) {
		this.resistenceOriginal = resistenceOriginal;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad precisionOriginal.
	 */
	public int getPrecisionOriginal() {
		return precisionOriginal;
	}

	/**
	 * @param Método que asigna el valor de la propiedad precisionOriginal.
	 */
	public void setPrecisionOriginal(int precisionOriginal) {
		this.precisionOriginal = precisionOriginal;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad totalDistance.
	 */
	public double getTotalDistance() {
		return totalDistance;
	}

	/**
	 * @param Método que asigna el valor de la propiedad totalDistance.
	 */
	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}

	/**
	 * @return  Método que obtiene el valor de la propiedad extraShot.
	 */
	public int getExtraShot() {
		return extraShot;
	}

	/**
	 * @param Método que asigna el valor de la propiedad extraShot.
	 */
	public void setExtraShot(int extraShot) {
		this.extraShot = extraShot;
	}
}
