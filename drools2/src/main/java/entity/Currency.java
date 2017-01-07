package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CURRENCY database table.
 * 
 */
@Entity
@Table(name="CURRENCY")
@NamedQuery(name="Currency.findAll", query="SELECT c FROM Currency c")
public class Currency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CURRENCY_ID")
	private int currencyId;

	@Column(name="CURRENCY_NAME")
	private String currencyName;

	//bi-directional many-to-one association to Policy
	@OneToMany(mappedBy="currency")
	private List<Policy> policies;

	public Currency() {
	}

	public int getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyName() {
		return this.currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public List<Policy> getPolicies() {
		return this.policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public Policy addPolicy(Policy policy) {
		getPolicies().add(policy);
		policy.setCurrency(this);

		return policy;
	}

	public Policy removePolicy(Policy policy) {
		getPolicies().remove(policy);
		policy.setCurrency(null);

		return policy;
	}

}