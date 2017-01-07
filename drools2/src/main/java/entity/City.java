package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CITY database table.
 * 
 */
@Entity
@Table(name="CITY")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CITY_ID")
	private int cityId;

	@Column(name="CITY_NAME")
	private String cityName;

	//bi-directional many-to-one association to StateOfOrigin
	@ManyToOne
	@JoinColumn(name="ST_ID")
	private StateOfOrigin stateOfOrigin;

	//bi-directional many-to-one association to InsuranceCompany
	@OneToMany(mappedBy="city")
	private List<InsuranceCompany> insuranceCompanies;

	public City() {
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public StateOfOrigin getStateOfOrigin() {
		return this.stateOfOrigin;
	}

	public void setStateOfOrigin(StateOfOrigin stateOfOrigin) {
		this.stateOfOrigin = stateOfOrigin;
	}

	public List<InsuranceCompany> getInsuranceCompanies() {
		return this.insuranceCompanies;
	}

	public void setInsuranceCompanies(List<InsuranceCompany> insuranceCompanies) {
		this.insuranceCompanies = insuranceCompanies;
	}

	public InsuranceCompany addInsuranceCompany(InsuranceCompany insuranceCompany) {
		getInsuranceCompanies().add(insuranceCompany);
		insuranceCompany.setCity(this);

		return insuranceCompany;
	}

	public InsuranceCompany removeInsuranceCompany(InsuranceCompany insuranceCompany) {
		getInsuranceCompanies().remove(insuranceCompany);
		insuranceCompany.setCity(null);

		return insuranceCompany;
	}

}