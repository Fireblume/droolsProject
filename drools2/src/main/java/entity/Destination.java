package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DESTINATION database table.
 * 
 */
@Entity
@Table(name="DESTINATION")
public class Destination implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DST_ID")
	private int dstId;

	@Column(name="DST_DAYS")
	private int dstDays;

	@Column(name="DST_NAME")
	private String dstName;

	//bi-directional many-to-one association to SubjectOfInsurance
	@OneToMany(mappedBy="destination")
	private List<SubjectOfInsurance> subjectOfInsurances;

	public Destination() {
	}

	public int getDstId() {
		return this.dstId;
	}

	public void setDstId(int dstId) {
		this.dstId = dstId;
	}

	public int getDstDays() {
		return this.dstDays;
	}

	public void setDstDays(int dstDays) {
		this.dstDays = dstDays;
	}

	public String getDstName() {
		return this.dstName;
	}

	public void setDstName(String dstName) {
		this.dstName = dstName;
	}

	public List<SubjectOfInsurance> getSubjectOfInsurances() {
		return this.subjectOfInsurances;
	}

	public void setSubjectOfInsurances(List<SubjectOfInsurance> subjectOfInsurances) {
		this.subjectOfInsurances = subjectOfInsurances;
	}

	public SubjectOfInsurance addSubjectOfInsurance(SubjectOfInsurance subjectOfInsurance) {
		getSubjectOfInsurances().add(subjectOfInsurance);
		subjectOfInsurance.setDestination(this);

		return subjectOfInsurance;
	}

	public SubjectOfInsurance removeSubjectOfInsurance(SubjectOfInsurance subjectOfInsurance) {
		getSubjectOfInsurances().remove(subjectOfInsurance);
		subjectOfInsurance.setDestination(null);

		return subjectOfInsurance;
	}

}