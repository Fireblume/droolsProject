package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TYPE_OF_INSURANCE database table.
 * 
 */
@Entity
@Table(name="TYPE_OF_INSURANCE")
@NamedQuery(name="TypeOfInsurance.findAll", query="SELECT t FROM TypeOfInsurance t")
public class TypeOfInsurance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IT_ID")
	private int itId;

	@Column(name="IT_NAME")
	private String itName;

	//bi-directional many-to-many association to Risk
	@ManyToMany(mappedBy="typeOfInsurances")
	private List<Risk> risks;

	//bi-directional many-to-one association to SubjectOfInsurance
	@OneToMany(mappedBy="typeOfInsurance")
	private List<SubjectOfInsurance> subjectOfInsurances;

	//bi-directional many-to-one association to Package
	@ManyToOne
	@JoinColumn(name="PACKAGE_ID")
	private PackageP packagep;

	public TypeOfInsurance() {
	}

	public int getItId() {
		return this.itId;
	}

	public void setItId(int itId) {
		this.itId = itId;
	}

	public String getItName() {
		return this.itName;
	}

	public void setItName(String itName) {
		this.itName = itName;
	}

	public List<Risk> getRisks() {
		return this.risks;
	}

	public void setRisks(List<Risk> risks) {
		this.risks = risks;
	}

	public List<SubjectOfInsurance> getSubjectOfInsurances() {
		return this.subjectOfInsurances;
	}

	public void setSubjectOfInsurances(List<SubjectOfInsurance> subjectOfInsurances) {
		this.subjectOfInsurances = subjectOfInsurances;
	}

	public SubjectOfInsurance addSubjectOfInsurance(SubjectOfInsurance subjectOfInsurance) {
		getSubjectOfInsurances().add(subjectOfInsurance);
		subjectOfInsurance.setTypeOfInsurance(this);

		return subjectOfInsurance;
	}

	public SubjectOfInsurance removeSubjectOfInsurance(SubjectOfInsurance subjectOfInsurance) {
		getSubjectOfInsurances().remove(subjectOfInsurance);
		subjectOfInsurance.setTypeOfInsurance(null);

		return subjectOfInsurance;
	}

	public PackageP getPackage() {
		return this.packagep;
	}

	public void setPackage(PackageP packagep) {
		this.packagep = packagep;
	}

}