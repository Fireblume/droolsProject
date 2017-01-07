package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PDV database table.
 * 
 */
@Entity
@Table(name="PDV")
@NamedQuery(name="Pdv.findAll", query="SELECT p FROM Pdv p")
public class Pdv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PDV_ID")
	private int pdvId;

	@Column(name="NAME_PDV")
	private String namePdv;

	//bi-directional many-to-one association to Policy
	@OneToMany(mappedBy="pdv")
	private List<Policy> policies;

	//bi-directional many-to-one association to RateOfPdv
	@OneToMany(mappedBy="pdv")
	private List<RateOfPdv> rateOfPdvs;

	public Pdv() {
	}

	public int getPdvId() {
		return this.pdvId;
	}

	public void setPdvId(int pdvId) {
		this.pdvId = pdvId;
	}

	public String getNamePdv() {
		return this.namePdv;
	}

	public void setNamePdv(String namePdv) {
		this.namePdv = namePdv;
	}

	public List<Policy> getPolicies() {
		return this.policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public Policy addPolicy(Policy policy) {
		getPolicies().add(policy);
		policy.setPdv(this);

		return policy;
	}

	public Policy removePolicy(Policy policy) {
		getPolicies().remove(policy);
		policy.setPdv(null);

		return policy;
	}

	public List<RateOfPdv> getRateOfPdvs() {
		return this.rateOfPdvs;
	}

	public void setRateOfPdvs(List<RateOfPdv> rateOfPdvs) {
		this.rateOfPdvs = rateOfPdvs;
	}

	public RateOfPdv addRateOfPdv(RateOfPdv rateOfPdv) {
		getRateOfPdvs().add(rateOfPdv);
		rateOfPdv.setPdv(this);

		return rateOfPdv;
	}

	public RateOfPdv removeRateOfPdv(RateOfPdv rateOfPdv) {
		getRateOfPdvs().remove(rateOfPdv);
		rateOfPdv.setPdv(null);

		return rateOfPdv;
	}

}