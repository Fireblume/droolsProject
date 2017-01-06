package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TYPE_OF_RISK database table.
 * 
 */
@Entity
@Table(name="TYPE_OF_RISK")
public class TypeOfRisk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TOR_ID")
	private int torId;

	@Column(name="TOR_NAME")
	private String torName;

	//bi-directional many-to-one association to Risk
	@OneToMany(mappedBy="typeOfRisk")
	private List<Risk> risks;

	public TypeOfRisk() {
	}

	public int getTorId() {
		return this.torId;
	}

	public void setTorId(int torId) {
		this.torId = torId;
	}

	public String getTorName() {
		return this.torName;
	}

	public void setTorName(String torName) {
		this.torName = torName;
	}

	public List<Risk> getRisks() {
		return this.risks;
	}

	public void setRisks(List<Risk> risks) {
		this.risks = risks;
	}

	public Risk addRisk(Risk risk) {
		getRisks().add(risk);
		risk.setTypeOfRisk(this);

		return risk;
	}

	public Risk removeRisk(Risk risk) {
		getRisks().remove(risk);
		risk.setTypeOfRisk(null);

		return risk;
	}

}