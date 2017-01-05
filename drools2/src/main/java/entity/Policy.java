package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the POLICY database table.
 * 
 */
@Entity
@Table(name="POLICY")
@NamedQuery(name="Policy.findAll", query="SELECT p FROM Policy p")
public class Policy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="POLICY_ID")
	private int policyId;

	@Column(name="POLICY_DST_END_OF_INSURANCE")
	private Timestamp policyDstEndOfInsurance;

	@Column(name="POLICY_START_OF_INSURANCE")
	private Timestamp policyStartOfInsurance;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="policy")
	private List<Client> clients;

	//bi-directional many-to-one association to BusinessYear
	@ManyToOne
	@JoinColumn(name="YEAR_ID")
	private BusinessYear businessYear;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private Client client;

	//bi-directional many-to-one association to Currency
	@ManyToOne
	@JoinColumn(name="CURRENCY_ID")
	private Currency currency;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EN_ID")
	private Employee employee;

	//bi-directional many-to-one association to InsuranceCompany
	@ManyToOne
	@JoinColumn(name="CP_ID")
	private InsuranceCompany insuranceCompany;

	//bi-directional many-to-one association to Package
	@ManyToOne
	@JoinColumn(name="PACKAGE_ID")
	private PackageP packagep;

	//bi-directional many-to-one association to Pdv
	@ManyToOne
	@JoinColumn(name="PDV_ID")
	private Pdv pdv;

	//bi-directional many-to-one association to Risk
	@ManyToOne
	@JoinColumn(name="R_ID")
	private Risk risk;

	//bi-directional many-to-one association to SubjectOfInsurance
	@ManyToOne
	@JoinColumn(name="II_ID")
	private SubjectOfInsurance subjectOfInsurance;

	public Policy() {
	}

	public int getPolicyId() {
		return this.policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public Timestamp getPolicyDstEndOfInsurance() {
		return this.policyDstEndOfInsurance;
	}

	public void setPolicyDstEndOfInsurance(Timestamp policyDstEndOfInsurance) {
		this.policyDstEndOfInsurance = policyDstEndOfInsurance;
	}

	public Timestamp getPolicyStartOfInsurance() {
		return this.policyStartOfInsurance;
	}

	public void setPolicyStartOfInsurance(Timestamp policyStartOfInsurance) {
		this.policyStartOfInsurance = policyStartOfInsurance;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setPolicy(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setPolicy(null);

		return client;
	}

	public BusinessYear getBusinessYear() {
		return this.businessYear;
	}

	public void setBusinessYear(BusinessYear businessYear) {
		this.businessYear = businessYear;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public InsuranceCompany getInsuranceCompany() {
		return this.insuranceCompany;
	}

	public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public PackageP getPackage() {
		return this.packagep;
	}

	public void setPackage(PackageP packagep) {
		this.packagep = packagep;
	}

	public Pdv getPdv() {
		return this.pdv;
	}

	public void setPdv(Pdv pdv) {
		this.pdv = pdv;
	}

	public Risk getRisk() {
		return this.risk;
	}

	public void setRisk(Risk risk) {
		this.risk = risk;
	}

	public SubjectOfInsurance getSubjectOfInsurance() {
		return this.subjectOfInsurance;
	}

	public void setSubjectOfInsurance(SubjectOfInsurance subjectOfInsurance) {
		this.subjectOfInsurance = subjectOfInsurance;
	}

}