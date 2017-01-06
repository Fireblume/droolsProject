package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the CLIENT database table.
 * 
 */
@Entity
@Table(name="CLIENT")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLIENT_ID")
	private int clientId;

	@Column(name="DATE_OF_BIRTH")
	private Timestamp dateOfBirth;

	@Column(name="FIRSTNAME")
	private String firstname;

	@Column(name="JMBG")
	private String jmbg;

	@Column(name="LASTNAME")
	private String lastname;

	@Column(name="PHONE")
	private String phone;

	//bi-directional many-to-one association to BankAccount
	@OneToMany(mappedBy="client")
	private List<BankAccount> bankAccounts;

	//bi-directional many-to-one association to Car
	@OneToMany(mappedBy="client")
	private List<Car> cars;

	//bi-directional many-to-one association to Policy
	@ManyToOne
	@JoinColumn(name="POLICY_ID")
	private Policy policy;

	//bi-directional many-to-one association to TypeOfClient
	@ManyToOne
	@JoinColumn(name="CT_ID")
	private TypeOfClient typeOfClient;

	//bi-directional many-to-one association to Policy
	@OneToMany(mappedBy="client")
	private List<Policy> policies;

	public Client() {
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public Timestamp getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getJmbg() {
		return this.jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<BankAccount> getBankAccounts() {
		return this.bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public BankAccount addBankAccount(BankAccount bankAccount) {
		getBankAccounts().add(bankAccount);
		bankAccount.setClient(this);

		return bankAccount;
	}

	public BankAccount removeBankAccount(BankAccount bankAccount) {
		getBankAccounts().remove(bankAccount);
		bankAccount.setClient(null);

		return bankAccount;
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Car addCar(Car car) {
		getCars().add(car);
		car.setClient(this);

		return car;
	}

	public Car removeCar(Car car) {
		getCars().remove(car);
		car.setClient(null);

		return car;
	}

	public Policy getPolicy() {
		return this.policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public TypeOfClient getTypeOfClient() {
		return this.typeOfClient;
	}

	public void setTypeOfClient(TypeOfClient typeOfClient) {
		this.typeOfClient = typeOfClient;
	}

	public List<Policy> getPolicies() {
		return this.policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public Policy addPolicy(Policy policy) {
		getPolicies().add(policy);
		policy.setClient(this);

		return policy;
	}

	public Policy removePolicy(Policy policy) {
		getPolicies().remove(policy);
		policy.setClient(null);

		return policy;
	}

}