package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BUSINESS_YEAR database table.
 * 
 */
@Entity
@Table(name="BUSINESS_YEAR")
@NamedQuery(name="BusinessYear.findAll", query="SELECT b FROM BusinessYear b")
public class BusinessYear implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="YEAR_ID")
	private int yearId;

	//bi-directional many-to-one association to InsuranceCompany
	@ManyToOne
	@JoinColumn(name="CP_ID")
	private InsuranceCompany insuranceCompany;

	//bi-directional many-to-one association to Policy
	@OneToMany(mappedBy="businessYear")
	private List<Policy> policies;

	public BusinessYear() {
	}

	public int getYearId() {
		return this.yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public InsuranceCompany getInsuranceCompany() {
		return this.insuranceCompany;
	}

	public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public List<Policy> getPolicies() {
		return this.policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public Policy addPolicy(Policy policy) {
		getPolicies().add(policy);
		policy.setBusinessYear(this);

		return policy;
	}

	public Policy removePolicy(Policy policy) {
		getPolicies().remove(policy);
		policy.setBusinessYear(null);

		return policy;
	}

}