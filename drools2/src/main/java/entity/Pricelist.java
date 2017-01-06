package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the PRICELIST database table.
 * 
 */
@Entity
@Table(name="PRICELIST")
public class Pricelist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRICELIST_ID")
	private int pricelistId;

	@Column(name="END_DATE")
	private Timestamp endDate;

	@Column(name="START_DATE")
	private Timestamp startDate;

	//bi-directional many-to-one association to InsuranceCompany
	@ManyToOne
	@JoinColumn(name="CP_ID")
	private InsuranceCompany insuranceCompany;

	//bi-directional many-to-one association to PricelistItem
	@OneToMany(mappedBy="pricelist")
	private List<PricelistItem> pricelistItems;

	public Pricelist() {
	}

	public int getPricelistId() {
		return this.pricelistId;
	}

	public void setPricelistId(int pricelistId) {
		this.pricelistId = pricelistId;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public InsuranceCompany getInsuranceCompany() {
		return this.insuranceCompany;
	}

	public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public List<PricelistItem> getPricelistItems() {
		return this.pricelistItems;
	}

	public void setPricelistItems(List<PricelistItem> pricelistItems) {
		this.pricelistItems = pricelistItems;
	}

	public PricelistItem addPricelistItem(PricelistItem pricelistItem) {
		getPricelistItems().add(pricelistItem);
		pricelistItem.setPricelist(this);

		return pricelistItem;
	}

	public PricelistItem removePricelistItem(PricelistItem pricelistItem) {
		getPricelistItems().remove(pricelistItem);
		pricelistItem.setPricelist(null);

		return pricelistItem;
	}

}