package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STATE_OF_ORIGIN database table.
 * 
 */
@Entity
@Table(name="STATE_OF_ORIGIN")
@NamedQuery(name="StateOfOrigin.findAll", query="SELECT s FROM StateOfOrigin s")
public class StateOfOrigin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ST_ID")
	private int stId;

	@Column(name="ST_NAME")
	private String stName;

	//bi-directional many-to-one association to City
	@OneToMany(mappedBy="stateOfOrigin")
	private List<City> cities;

	public StateOfOrigin() {
	}

	public int getStId() {
		return this.stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getStName() {
		return this.stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City addCity(City city) {
		getCities().add(city);
		city.setStateOfOrigin(this);

		return city;
	}

	public City removeCity(City city) {
		getCities().remove(city);
		city.setStateOfOrigin(null);

		return city;
	}

}