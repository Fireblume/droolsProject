package main.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the RATE_OF_PDV database table.
 * 
 */
@Entity
@Table(name="RATE_OF_PDV")
@NamedQuery(name="RateOfPdv.findAll", query="SELECT r FROM RateOfPdv r")
public class RateOfPdv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PDV_RATE_ID")
	private int pdvRateId;

	@Column(name="RATE")
	private BigDecimal rate;

	@Column(name="VALID_UNTIL")
	private Timestamp validUntil;

	//bi-directional many-to-one association to Pdv
	@ManyToOne
	@JoinColumn(name="PDV_ID")
	private Pdv pdv;

	public RateOfPdv() {
	}

	public int getPdvRateId() {
		return this.pdvRateId;
	}

	public void setPdvRateId(int pdvRateId) {
		this.pdvRateId = pdvRateId;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Timestamp getValidUntil() {
		return this.validUntil;
	}

	public void setValidUntil(Timestamp validUntil) {
		this.validUntil = validUntil;
	}

	public Pdv getPdv() {
		return this.pdv;
	}

	public void setPdv(Pdv pdv) {
		this.pdv = pdv;
	}

}