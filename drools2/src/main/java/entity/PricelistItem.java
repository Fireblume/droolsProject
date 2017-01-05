package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


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

	//bi-directional many-to-one association to Package
	@ManyToOne
	@JoinColumn(name="PACKAGE_ID")
	private PackageP packagep;

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

	public PackageP getPackage() {
		return this.packagep;
	}

	public void setPackage(PackageP packagep) {
		this.packagep = packagep;
	}

	public Pricelist getPricelist() {
		return this.pricelist;
	}

	public void setPricelist(Pricelist pricelist) {
		this.pricelist = pricelist;
	}

}