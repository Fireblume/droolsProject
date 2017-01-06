package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RISK database table.
 * 
 */
@Entity
@Table(name="RISK")
public class Risk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="R_ID")
	private int rId;

	@Column(name="R_NAME")
	private String rName;

	//bi-directional many-to-one association to Policy
	@OneToMany(mappedBy="risk")
	private List<Policy> policies;

	//bi-directional many-to-one association to Coefficient
	@ManyToOne
	@JoinColumn(name="COEFF_ID")
	private Coefficient coefficient;

	//bi-directional many-to-one association to TypeOfRisk
	@ManyToOne
	@JoinColumn(name="TOR_ID")
	private TypeOfRisk typeOfRisk;

	//bi-directional many-to-many association to TypeOfInsurance
	@ManyToMany
	@JoinTable(
		name="RISK_TYPE_OF_INSURANCE"
		, joinColumns={
			@JoinColumn(name="R_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IT_ID")
			}
		)
	private List<TypeOfInsurance> typeOfInsurances;

	public Risk() {
	}

	public int getRId() {
		return this.rId;
	}

	public void setRId(int rId) {
		this.rId = rId;
	}

	public String getRName() {
		return this.rName;
	}

	public void setRName(String rName) {
		this.rName = rName;
	}

	public List<Policy> getPolicies() {
		return this.policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public Policy addPolicy(Policy policy) {
		getPolicies().add(policy);
		policy.setRisk(this);

		return policy;
	}

	public Policy removePolicy(Policy policy) {
		getPolicies().remove(policy);
		policy.setRisk(null);

		return policy;
	}

	public Coefficient getCoefficient() {
		return this.coefficient;
	}

	public void setCoefficient(Coefficient coefficient) {
		this.coefficient = coefficient;
	}

	public TypeOfRisk getTypeOfRisk() {
		return this.typeOfRisk;
	}

	public void setTypeOfRisk(TypeOfRisk typeOfRisk) {
		this.typeOfRisk = typeOfRisk;
	}

	public List<TypeOfInsurance> getTypeOfInsurances() {
		return this.typeOfInsurances;
	}

	public void setTypeOfInsurances(List<TypeOfInsurance> typeOfInsurances) {
		this.typeOfInsurances = typeOfInsurances;
	}

}