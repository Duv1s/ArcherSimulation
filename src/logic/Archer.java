package logic;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Duvis Alejandro G√≥mez Neira
 * @version 1.0
 */
public class Archer {
	// Informaci√≥n personal
	private String nameArcher;
	private GenderEnum gender;
	private Date dateOfBirth;

	// Habilidades
	private int precision;
	private int resistance;
	private int experience;
	private double luck;

	// Informaci√≥n para estad√≠sticas
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
	 * @param genderArcher G√©nero del arquero
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

	//CreaciÛn de los mÈtodos setters y getters
	/**
	 * @return MÈtodo que obtiene el valor de la propiedad nameArcher
	 */
	public String getNameArcher() {
		return nameArcher;
	}

	/**
	 * @param MÈtodo que asigna el valor de la propiedad nameArcher.
	 */
	public void setNameArcher(String nameArcher) {
		this.nameArcher = nameArcher;
	}

	/**
	 * @return MÈtodo que obtiene el valor de la propiedad gender
	 */
	public GenderEnum getGender() {
		return gender;
	}

	/**
	 * @param MÈtodo que asigna el valor de la propiedad gender.
	 */
	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	/**
	 * @return MÈtodo que obtiene el valor de la propiedad dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param MÈtodo que asigna el valor de la propiedad dateOfBirth.
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return MÈtodo que obtiene el valor de la propiedad precision
	 */
	public int getPrecision() {
		return precision;
	}

	/**
	 * @param MÈtodo que asigna el valor de la propiedad precision.
	 */
	public void setPrecision(int precision) {
		this.precision = precision;
	}

	/**
	 * @return MÈtodo que obtiene el valor de la propiedad resistance
	 */
	public int getResistance() {
		return resistance;
	}

	/**
	 * @param MÈtodo que asigna el valor de la propiedad resistance.
	 */
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	/**
	 * @return MÈtodo que obtiene el valor de la propiedad experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * @param MÈtodo que asigna el valor de la propiedad experience.
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * @return MÈtodo que obtiene el valor de la propiedad luck
	 */
	public double getLuck() {
		return luck;
	}

	/**
	 * @param MÈtodo que asigna el valor de la propiedad luck.
	 */
	public void setLuck(double luck) {
		this.luck = luck;
	}

	/**
	 * @return MÈtodo que obtiene el valor de la propiedad team
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * @param MÈtodo que asigna el valor de la propiedad team.
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * @return MÈtodo que obtiene el valor de la propiedad listShot
	 */
	public ArrayList<Shot> getListShot() {
		return listShot;
	}

	/**
	 * @param MÈtodo que asigna el valor de la propiedad listShot.
	 */
	public void setListShot(ArrayList<Shot> listShot) {
		this.listShot = listShot;
	}

	/**
	 * @return MÈtodo que obtiene el valor de la propiedad resistenceOriginal
	 */
	public int getResistenceOriginal() {
		return resistenceOriginal;
	}

	/**
	 * @param MÈtodo que asigna el valor de la propiedad resistenceOriginal.
	 */
	public void setResistenceOriginal(int resistenceOriginal) {
		this.resistenceOriginal = resistenceOriginal;
	}

	/**
	 * @return MÈtodo que obtiene el valor de la propiedad precisionOriginal
	 */
	public int getPrecisionOriginal() {
		return precisionOriginal;
	}

	/**
	 * @param MÈtodo que asigna el valor de la propiedad precisionOriginal.
	 */
	public void setPrecisionOriginal(int precisionOriginal) {
		this.precisionOriginal = precisionOriginal;
	}

	/**
	 * @return MÈtodo que obtiene el valor de la propiedad totalDistance
	 */
	public double getTotalDistance() {
		return totalDistance;
	}

	/**
	 * @param MÈtodo que asigna el valor de la propiedad totalDistance.
	 */
	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}

	/**
	 * @return MÈtodo que obtiene el valor de la propiedad extraShot
	 */
	public int getExtraShot() {
		return extraShot;
	}

	/**
	 * @param MÈtodo que asigna el valor de la propiedad extraShot.
	 */
	public void setExtraShot(int extraShot) {
		this.extraShot = extraShot;
	}
}
