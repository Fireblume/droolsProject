package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SUBJECT_OF_INSURANCE database table.
 * 
 */
@Entity
@Table(name="SUBJECT_OF_INSURANCE")
@NamedQuery(name="SubjectOfInsurance.findAll", query="SELECT s FROM SubjectOfInsurance s")
public class SubjectOfInsurance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="II_ID")
	private int iiId;

	//bi-directional many-to-one association to Policy
	@OneToMany(mappedBy="subjectOfInsurance")
	private List<Policy> policies;

	//bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumn(name="CARID")
	private Car car;

	//bi-directional many-to-one association to Destination
	@ManyToOne
	@JoinColumn(name="DST_ID")
	private Destination destination;

	//bi-directional many-to-one association to Home
	@ManyToOne
	@JoinColumn(name="HOME_ID")
	private Home home;

	//bi-directional many-to-one association to TypeOfInsurance
	@ManyToOne
	@JoinColumn(name="IT_ID")
	private TypeOfInsurance typeOfInsurance;

	public SubjectOfInsurance() {
	}

	public int getIiId() {
		return this.iiId;
	}

	public void setIiId(int iiId) {
		this.iiId = iiId;
	}

	public List<Policy> getPolicies() {
		return this.policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public Policy addPolicy(Policy policy) {
		getPolicies().add(policy);
		policy.setSubjectOfInsurance(this);

		return policy;
	}

	public Policy removePolicy(Policy policy) {
		getPolicies().remove(policy);
		policy.setSubjectOfInsurance(null);

		return policy;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Destination getDestination() {
		return this.destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Home getHome() {
		return this.home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public TypeOfInsurance getTypeOfInsurance() {
		return this.typeOfInsurance;
	}

	public void setTypeOfInsurance(TypeOfInsurance typeOfInsurance) {
		this.typeOfInsurance = typeOfInsurance;
	}

}