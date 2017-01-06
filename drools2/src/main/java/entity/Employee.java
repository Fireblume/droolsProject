package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EN_ID")
	private int enId;

	@Column(name="EN_FIRSTNAME")
	private String enFirstname;

	@Column(name="EN_LASTNAME")
	private String enLastname;

	//bi-directional many-to-one association to EmployeeRole
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private EmployeeRole employeeRole;

	//bi-directional many-to-one association to InsuranceCompany
	@ManyToOne
	@JoinColumn(name="CP_ID")
	private InsuranceCompany insuranceCompany;

	//bi-directional many-to-one association to Policy
	@OneToMany(mappedBy="employee")
	private List<Policy> policies;

	public Employee() {
	}

	public int getEnId() {
		return this.enId;
	}

	public void setEnId(int enId) {
		this.enId = enId;
	}

	public String getEnFirstname() {
		return this.enFirstname;
	}

	public void setEnFirstname(String enFirstname) {
		this.enFirstname = enFirstname;
	}

	public String getEnLastname() {
		return this.enLastname;
	}

	public void setEnLastname(String enLastname) {
		this.enLastname = enLastname;
	}

	public EmployeeRole getEmployeeRole() {
		return this.employeeRole;
	}

	public void setEmployeeRole(EmployeeRole employeeRole) {
		this.employeeRole = employeeRole;
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
		policy.setEmployee(this);

		return policy;
	}

	public Policy removePolicy(Policy policy) {
		getPolicies().remove(policy);
		policy.setEmployee(null);

		return policy;
	}

}