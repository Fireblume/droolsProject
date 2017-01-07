package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PRICELIST_ITEM database table.
 * 
 */
@Entity
@Table(name="PRICELIST_ITEM")
@NamedQuery(name="PricelistItem.findAll", query="SELECT p FROM PricelistItem p")
public class PricelistItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PL_ITEM_ID")
	private int plItemId;

	@Column(name="PL_PRICE")
	private BigDecimal plPrice;

	//bi-directional many-to-one association to InsurancePackage
	@OneToMany(mappedBy="pricelistItem")
	private List<InsurancePackage> insurancePackages;

	//bi-directional many-to-one association to Pricelist
	@ManyToOne
	@JoinColumn(name="PRICELIST_ID")
	private Pricelist pricelist;

	public PricelistItem() {
	}

	public int getPlItemId() {
		return this.plItemId;
	}

	public void setPlItemId(int plItemId) {
		this.plItemId = plItemId;
	}

	public BigDecimal getPlPrice() {
		return this.plPrice;
	}

	public void setPlPrice(BigDecimal plPrice) {
		this.plPrice = plPrice;
	}

	public List<InsurancePackage> getInsurancePackages() {
		return this.insurancePackages;
	}

	public void setInsurancePackages(List<InsurancePackage> insurancePackages) {
		this.insurancePackages = insurancePackages;
	}

	public InsurancePackage addInsurancePackage(InsurancePackage insurancePackage) {
		getInsurancePackages().add(insurancePackage);
		insurancePackage.setPricelistItem(this);

		return insurancePackage;
	}

	public InsurancePackage removeInsurancePackage(InsurancePackage insurancePackage) {
		getInsurancePackages().remove(insurancePackage);
		insurancePackage.setPricelistItem(null);

		return insurancePackage;
	}

	public Pricelist getPricelist() {
		return this.pricelist;
	}

	public void setPricelist(Pricelist pricelist) {
		this.pricelist = pricelist;
	}

}