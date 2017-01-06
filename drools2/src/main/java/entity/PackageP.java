package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the [PACKAGE] database table.
 * 
 */
@Entity
@Table(name="[PACKAGE]")
public class PackageP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PACKAGE_ID")
	private int packageId;

	@Column(name="TOR_NAME")
	private String torName;

	//bi-directional many-to-one association to ItemsOfPackage
	@OneToMany(mappedBy="packagep")
	private List<ItemsOfPackage> itemsOfPackages;

	//bi-directional many-to-one association to Policy
	@OneToMany(mappedBy="packagep")
	private List<Policy> policies;

	//bi-directional many-to-one association to PricelistItem
	@OneToMany(mappedBy="packagep")
	private List<PricelistItem> pricelistItems;

	//bi-directional many-to-one association to TypeOfInsurance
	@OneToMany(mappedBy="packagep")
	private List<TypeOfInsurance> typeOfInsurances;

	public PackageP() {
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

	public List<ItemsOfPackage> getItemsOfPackages() {
		return this.itemsOfPackages;
	}

	public void setItemsOfPackages(List<ItemsOfPackage> itemsOfPackages) {
		this.itemsOfPackages = itemsOfPackages;
	}

	public ItemsOfPackage addItemsOfPackage(ItemsOfPackage itemsOfPackage) {
		getItemsOfPackages().add(itemsOfPackage);
		itemsOfPackage.setPackage(this);

		return itemsOfPackage;
	}

	public ItemsOfPackage removeItemsOfPackage(ItemsOfPackage itemsOfPackage) {
		getItemsOfPackages().remove(itemsOfPackage);
		itemsOfPackage.setPackage(null);

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
		policy.setPackage(this);

		return policy;
	}

	public Policy removePolicy(Policy policy) {
		getPolicies().remove(policy);
		policy.setPackage(null);

		return policy;
	}

	public List<PricelistItem> getPricelistItems() {
		return this.pricelistItems;
	}

	public void setPricelistItems(List<PricelistItem> pricelistItems) {
		this.pricelistItems = pricelistItems;
	}

	public PricelistItem addPricelistItem(PricelistItem pricelistItem) {
		getPricelistItems().add(pricelistItem);
		pricelistItem.setPackage(this);

		return pricelistItem;
	}

	public PricelistItem removePricelistItem(PricelistItem pricelistItem) {
		getPricelistItems().remove(pricelistItem);
		pricelistItem.setPackage(null);

		return pricelistItem;
	}

	public List<TypeOfInsurance> getTypeOfInsurances() {
		return this.typeOfInsurances;
	}

	public void setTypeOfInsurances(List<TypeOfInsurance> typeOfInsurances) {
		this.typeOfInsurances = typeOfInsurances;
	}

	public TypeOfInsurance addTypeOfInsurance(TypeOfInsurance typeOfInsurance) {
		getTypeOfInsurances().add(typeOfInsurance);
		typeOfInsurance.setPackage(this);

		return typeOfInsurance;
	}

	public TypeOfInsurance removeTypeOfInsurance(TypeOfInsurance typeOfInsurance) {
		getTypeOfInsurances().remove(typeOfInsurance);
		typeOfInsurance.setPackage(null);

		return typeOfInsurance;
	}

}