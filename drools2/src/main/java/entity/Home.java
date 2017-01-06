package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HOME database table.
 * 
 */
@Entity
@Table(name="HOME")
public class Home implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="HOME_ID")
	private int homeId;

	@Column(name="HOME_ADDRESS")
	private String homeAddress;

	@Column(name="HOME_BUILDING_YEAR")
	private String homeBuildingYear;

	@Column(name="HOME_SQUARES")
	private int homeSquares;

	//bi-directional many-to-one association to TypeOfHome
	@ManyToOne
	@JoinColumn(name="HT_ID")
	private TypeOfHome typeOfHome;

	//bi-directional many-to-one association to SubjectOfInsurance
	@OneToMany(mappedBy="home")
	private List<SubjectOfInsurance> subjectOfInsurances;

	public Home() {
	}

	public int getHomeId() {
		return this.homeId;
	}

	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}

	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHomeBuildingYear() {
		return this.homeBuildingYear;
	}

	public void setHomeBuildingYear(String homeBuildingYear) {
		this.homeBuildingYear = homeBuildingYear;
	}

	public int getHomeSquares() {
		return this.homeSquares;
	}

	public void setHomeSquares(int homeSquares) {
		this.homeSquares = homeSquares;
	}

	public TypeOfHome getTypeOfHome() {
		return this.typeOfHome;
	}

	public void setTypeOfHome(TypeOfHome typeOfHome) {
		this.typeOfHome = typeOfHome;
	}

	public List<SubjectOfInsurance> getSubjectOfInsurances() {
		return this.subjectOfInsurances;
	}

	public void setSubjectOfInsurances(List<SubjectOfInsurance> subjectOfInsurances) {
		this.subjectOfInsurances = subjectOfInsurances;
	}

	public SubjectOfInsurance addSubjectOfInsurance(SubjectOfInsurance subjectOfInsurance) {
		getSubjectOfInsurances().add(subjectOfInsurance);
		subjectOfInsurance.setHome(this);

		return subjectOfInsurance;
	}

	public SubjectOfInsurance removeSubjectOfInsurance(SubjectOfInsurance subjectOfInsurance) {
		getSubjectOfInsurances().remove(subjectOfInsurance);
		subjectOfInsurance.setHome(null);

		return subjectOfInsurance;
	}

}