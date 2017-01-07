package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ITEMS_OF_PACKAGE database table.
 * 
 */
@Entity
@Table(name="ITEMS_OF_PACKAGE")
@NamedQuery(name="ItemsOfPackage.findAll", query="SELECT i FROM ItemsOfPackage i")
public class ItemsOfPackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ITEMS_OF_PACKAGE_ID")
	private int itemsOfPackageId;

	//bi-directional many-to-one association to InsurancePackage
	@ManyToOne
	@JoinColumn(name="PACKAGE_ID")
	private InsurancePackage insurancePackage;

	public ItemsOfPackage() {
	}

	public int getItemsOfPackageId() {
		return this.itemsOfPackageId;
	}

	public void setItemsOfPackageId(int itemsOfPackageId) {
		this.itemsOfPackageId = itemsOfPackageId;
	}

	public InsurancePackage getInsurancePackage() {
		return this.insurancePackage;
	}

	public void setInsurancePackage(InsurancePackage insurancePackage) {
		this.insurancePackage = insurancePackage;
	}

}