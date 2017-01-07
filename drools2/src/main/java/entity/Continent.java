package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CONTINENT database table.
 * 
 */
@Entity
@Table(name="CONTINENT")
@NamedQuery(name="Continent.findAll", query="SELECT c FROM Continent c")
public class Continent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CONTINENT_ID")
	private int continentId;

	@Column(name="CONTINENT_NAME")
	private String continentName;

	//bi-directional many-to-one association to StateOfOrigin
	@OneToMany(mappedBy="continent")
	private List<StateOfOrigin> stateOfOrigins;

	public Continent() {
	}

	public int getContinentId() {
		return this.continentId;
	}

	public void setContinentId(int continentId) {
		this.continentId = continentId;
	}

	public String getContinentName() {
		return this.continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public List<StateOfOrigin> getStateOfOrigins() {
		return this.stateOfOrigins;
	}

	public void setStateOfOrigins(List<StateOfOrigin> stateOfOrigins) {
		this.stateOfOrigins = stateOfOrigins;
	}

	public StateOfOrigin addStateOfOrigin(StateOfOrigin stateOfOrigin) {
		getStateOfOrigins().add(stateOfOrigin);
		stateOfOrigin.setContinent(this);

		return stateOfOrigin;
	}

	public StateOfOrigin removeStateOfOrigin(StateOfOrigin stateOfOrigin) {
		getStateOfOrigins().remove(stateOfOrigin);
		stateOfOrigin.setContinent(null);

		return stateOfOrigin;
	}

}