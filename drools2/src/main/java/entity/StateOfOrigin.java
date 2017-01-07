package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STATE_OF_ORIGIN database table.
 * 
 */
@Entity
@Table(name="STATE_OF_ORIGIN")
public class StateOfOrigin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ST_ID")
	private int stId;

	@Column(name="ST_NAME")
	private String stName;

	//bi-directional many-to-one association to Continent
	@ManyToOne
	@JoinColumn(name="CONTINENT_ID")
	private Continent continent;

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

	public Continent getContinent() {
		return this.continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

}