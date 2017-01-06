package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the INSURANCE_COMPANY database table.
 * 
 */
@Entity
@Table(name="INSURANCE_COMPANY")
public class InsuranceCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CP_ID")
	private int cpId;

	@Column(name="CP_NAME")
	private String cpName;

	@Column(name="PIB")
	private int pib;

	//bi-directional many-to-one association to BankAccount
	@OneToMany(mappedBy="insuranceCompany")
	private List<BankAccount> bankAccounts;

	//bi-directional many-to-one association to BusinessYear
	@OneToMany(mappedBy="insuranceCompany")
	private List<BusinessYear> businessYears;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="insuranceCompany")
	private List<Employee> employees;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="CITY_ID")
	private City city;

	//bi-directional many-to-one association to Policy
	@OneToMany(mappedBy="insuranceCompany")
	private List<Policy> policies;

	//bi-directional many-to-one association to Pricelist
	@OneToMany(mappedBy="insuranceCompany")
	private List<Pricelist> pricelists;

	public InsuranceCompany() {
	}

	public int getCpId() {
		return this.cpId;
	}

	public void setCpId(int cpId) {
		this.cpId = cpId;
	}

	public String getCpName() {
		return this.cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public int getPib() {
		return this.pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

	public List<BankAccount> getBankAccounts() {
		return this.bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public BankAccount addBankAccount(BankAccount bankAccount) {
		getBankAccounts().add(bankAccount);
		bankAccount.setInsuranceCompany(this);

		return bankAccount;
	}

	public BankAccount removeBankAccount(BankAccount bankAccount) {
		getBankAccounts().remove(bankAccount);
		bankAccount.setInsuranceCompany(null);

		return bankAccount;
	}

	public List<BusinessYear> getBusinessYears() {
		return this.businessYears;
	}

	public void setBusinessYears(List<BusinessYear> businessYears) {
		this.businessYears = businessYears;
	}

	public BusinessYear addBusinessYear(BusinessYear businessYear) {
		getBusinessYears().add(businessYear);
		businessYear.setInsuranceCompany(this);

		return businessYear;
	}

	public BusinessYear removeBusinessYear(BusinessYear businessYear) {
		getBusinessYears().remove(businessYear);
		businessYear.setInsuranceCompany(null);

		return businessYear;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setInsuranceCompany(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setInsuranceCompany(null);

		return employee;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Policy> getPolicies() {
		return this.policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public Policy addPolicy(Policy policy) {
		getPolicies().add(policy);
		policy.setInsuranceCompany(this);

		return policy;
	}

	public Policy removePolicy(Policy policy) {
		getPolicies().remove(policy);
		policy.setInsuranceCompany(null);

		return policy;
	}

	public List<Pricelist> getPricelists() {
		return this.pricelists;
	}

	public void setPricelists(List<Pricelist> pricelists) {
		this.pricelists = pricelists;
	}

	public Pricelist addPricelist(Pricelist pricelist) {
		getPricelists().add(pricelist);
		pricelist.setInsuranceCompany(this);

		return pricelist;
	}

	public Pricelist removePricelist(Pricelist pricelist) {
		getPricelists().remove(pricelist);
		pricelist.setInsuranceCompany(null);

		return pricelist;
	}

}