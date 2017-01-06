package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the CAR database table.
 * 
 */
@Entity
@Table(name="CAR")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CARID")
	private int carid;

	@Column(name="CAR_MODEL")
	private String carModel;

	@Column(name="CAR_TYPE")
	private String carType;

	@Column(name="CHASSIS_NUMBER")
	private int chassisNumber;

	@Column(name="LICENCE_PLATE")
	private String licencePlate;

	@Column(name="[YEAR]")
	private Timestamp year;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private Client client;

	//bi-directional many-to-one association to SubjectOfInsurance
	@OneToMany(mappedBy="car")
	private List<SubjectOfInsurance> subjectOfInsurances;

	public Car() {
	}

	public int getCarid() {
		return this.carid;
	}

	public void setCarid(int carid) {
		this.carid = carid;
	}

	public String getCarModel() {
		return this.carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarType() {
		return this.carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getChassisNumber() {
		return this.chassisNumber;
	}

	public void setChassisNumber(int chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getLicencePlate() {
		return this.licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public Timestamp getYear() {
		return this.year;
	}

	public void setYear(Timestamp year) {
		this.year = year;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<SubjectOfInsurance> getSubjectOfInsurances() {
		return this.subjectOfInsurances;
	}

	public void setSubjectOfInsurances(List<SubjectOfInsurance> subjectOfInsurances) {
		this.subjectOfInsurances = subjectOfInsurances;
	}

	public SubjectOfInsurance addSubjectOfInsurance(SubjectOfInsurance subjectOfInsurance) {
		getSubjectOfInsurances().add(subjectOfInsurance);
		subjectOfInsurance.setCar(this);

		return subjectOfInsurance;
	}

	public SubjectOfInsurance removeSubjectOfInsurance(SubjectOfInsurance subjectOfInsurance) {
		getSubjectOfInsurances().remove(subjectOfInsurance);
		subjectOfInsurance.setCar(null);

		return subjectOfInsurance;
	}

}