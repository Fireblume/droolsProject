package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TYPE_OF_HOME database table.
 * 
 */
@Entity
@Table(name="TYPE_OF_HOME")
public class TypeOfHome implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="HT_ID")
	private int htId;

	@Column(name="HT_NAME")
	private String htName;

	//bi-directional many-to-one association to Home
	@OneToMany(mappedBy="typeOfHome")
	private List<Home> homes;

	public TypeOfHome() {
	}

	public int getHtId() {
		return this.htId;
	}

	public void setHtId(int htId) {
		this.htId = htId;
	}

	public String getHtName() {
		return this.htName;
	}

	public void setHtName(String htName) {
		this.htName = htName;
	}

	public List<Home> getHomes() {
		return this.homes;
	}

	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}

	public Home addHome(Home home) {
		getHomes().add(home);
		home.setTypeOfHome(this);

		return home;
	}

	public Home removeHome(Home home) {
		getHomes().remove(home);
		home.setTypeOfHome(null);

		return home;
	}

}