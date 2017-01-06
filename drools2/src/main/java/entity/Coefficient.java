package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the COEFFICIENT database table.
 * 
 */
@Entity
@Table(name="COEFFICIENT")
public class Coefficient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COEFF_ID")
	private int coeffId;

	@Column(name="COEFF_DATE")
	private Timestamp coeffDate;

	@Column(name="COEFF_VALUE")
	private BigDecimal coeffValue;

	//bi-directional many-to-one association to Risk
	@OneToMany(mappedBy="coefficient")
	private List<Risk> risks;

	public Coefficient() {
	}

	public int getCoeffId() {
		return this.coeffId;
	}

	public void setCoeffId(int coeffId) {
		this.coeffId = coeffId;
	}

	public Timestamp getCoeffDate() {
		return this.coeffDate;
	}

	public void setCoeffDate(Timestamp coeffDate) {
		this.coeffDate = coeffDate;
	}

	public BigDecimal getCoeffValue() {
		return this.coeffValue;
	}

	public void setCoeffValue(BigDecimal coeffValue) {
		this.coeffValue = coeffValue;
	}

	public List<Risk> getRisks() {
		return this.risks;
	}

	public void setRisks(List<Risk> risks) {
		this.risks = risks;
	}

	public Risk addRisk(Risk risk) {
		getRisks().add(risk);
		risk.setCoefficient(this);

		return risk;
	}

	public Risk removeRisk(Risk risk) {
		getRisks().remove(risk);
		risk.setCoefficient(null);

		return risk;
	}

}