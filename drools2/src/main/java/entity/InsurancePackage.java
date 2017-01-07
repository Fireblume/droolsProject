package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the INSURANCE_PACKAGE database table.
 * 
 */
@Entity
@Table(name="INSURANCE_PACKAGE")
@NamedQuery(name="InsurancePackage.findAll", query="SELECT i FROM InsurancePackage i")
public class InsurancePackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PACKAGE_ID")
	private int packageId;

	@Column(name="TOR_NAME")
	private String torName;

	//bi-directional many-to-one association to PricelistItem
	@ManyToOne
	@JoinColumn(name="PL_ITEM_ID")
	private PricelistItem pricelistItem;

	//bi-directional many-to-one association to ItemsOfPackage
	@OneToMany(mappedBy="insurancePackage")
	private List<ItemsOfPackage> itemsOfPackages;

	//bi-directional many-to-one association to Policy
	@OneToMany(mappedBy="insurancePackage")
	private List<Policy> policies;

	//bi-directional many-to-one association to TypeOfInsurance
	@OneToMany(mappedBy="insurancePackage")
	private List<TypeOfInsurance> typeOfInsurances;

	public InsurancePackage() {
	}

	public int getPackageId() {
		return this.packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getTorName() {
		return this.torName;
	}

	public void setTorName(String torName) {
		this.torName = torName;
	}

	public PricelistItem getPricelistItem() {
		return this.pricelistItem;
	}

	public void setPricelistItem(PricelistItem pricelistItem) {
		this.pricelistItem = pricelistItem;
	}

	public List<ItemsOfPackage> getItemsOfPackages() {
		return this.itemsOfPackages;
	}

	public void setItemsOfPackages(List<ItemsOfPackage> itemsOfPackages) {
		this.itemsOfPackages = itemsOfPackages;
	}

	public ItemsOfPackage addItemsOfPackage(ItemsOfPackage itemsOfPackage) {
		getItemsOfPackages().add(itemsOfPackage);
		itemsOfPackage.setInsurancePackage(this);

		return itemsOfPackage;
	}

	public ItemsOfPackage removeItemsOfPackage(ItemsOfPackage itemsOfPackage) {
		getItemsOfPackages().remove(itemsOfPackage);
		itemsOfPackage.setInsurancePackage(null);

		return itemsOfPackage;
	}

	public List<Policy> getPolicies() {
		return this.policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public Policy addPolicy(Policy policy) {
		getPolicies().add(policy);
		policy.setInsurancePackage(this);

		return policy;
	}

	public Policy removePolicy(Policy policy) {
		getPolicies().remove(policy);
		policy.setInsurancePackage(null);

		return policy;
	}

	public List<TypeOfInsurance> getTypeOfInsurances() {
		return this.typeOfInsurances;
	}

	public void setTypeOfInsurances(List<TypeOfInsurance> typeOfInsurances) {
		this.typeOfInsurances = typeOfInsurances;
	}

	public TypeOfInsurance addTypeOfInsurance(TypeOfInsurance typeOfInsurance) {
		getTypeOfInsurances().add(typeOfInsurance);
		typeOfInsurance.setInsurancePackage(this);

		return typeOfInsurance;
	}

	public TypeOfInsurance removeTypeOfInsurance(TypeOfInsurance typeOfInsurance) {
		getTypeOfInsurances().remove(typeOfInsurance);
		typeOfInsurance.setInsurancePackage(null);

		return typeOfInsurance;
	}

}