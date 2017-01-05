package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BANK_ACCOUNT database table.
 * 
 */
@Entity
@Table(name="BANK_ACCOUNT")
@NamedQuery(name="BankAccount.findAll", query="SELECT b FROM BankAccount b")
public class BankAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AC1_ID")
	private int ac1Id;

	//bi-directional many-to-one association to Bank
	@ManyToOne
	@JoinColumn(name="BANK_ID")
	private Bank bank;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private Client client;

	//bi-directional many-to-one association to InsuranceCompany
	@ManyToOne
	@JoinColumn(name="CP_ID")
	private InsuranceCompany insuranceCompany;

	public BankAccount() {
	}

	public int getAc1Id() {
		return this.ac1Id;
	}

	public void setAc1Id(int ac1Id) {
		this.ac1Id = ac1Id;
	}

	public Bank getBank() {
		return this.bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public InsuranceCompany getInsuranceCompany() {
		return this.insuranceCompany;
	}

	public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

}