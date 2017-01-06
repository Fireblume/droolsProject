package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ITEMS_OF_PACKAGE database table.
 * 
 */
@Entity
@Table(name="ITEMS_OF_PACKAGE")
public class ItemsOfPackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ITEMS_OF_PACKAGE_ID")
	private int itemsOfPackageId;

	//bi-directional many-to-one association to Package
	@ManyToOne
	@JoinColumn(name="PACKAGE_ID")
	private PackageP packagep;

	public ItemsOfPackage() {
	}

	public int getItemsOfPackageId() {
		return this.itemsOfPackageId;
	}

	public void setItemsOfPackageId(int itemsOfPackageId) {
		this.itemsOfPackageId = itemsOfPackageId;
	}

	public PackageP getPackage() {
		return this.packagep;
	}

	public void setPackage(PackageP packagep) {
		this.packagep = packagep;
	}

}