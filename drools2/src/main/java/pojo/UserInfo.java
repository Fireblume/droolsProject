package main.java.pojo;

import java.math.BigDecimal;

public class UserInfo {

	public UserInfo(){}
	
	public enum TipRizika {SLAB, JACI, NAJJACI}
	public enum Destinacija {SRBIJA, GRCKA, BUGARSKA, HRVATSKA}
	
	private int brOdraslih;
	private int brDece;
	private int brDana;
	private double koefOdraslih;
	private double koefDece;
	private BigDecimal koefRizika;
	private double koefDestinacije;
	private TipRizika tipRizika;
	private Destinacija destinacija;
	private BigDecimal osnovica1;
	private BigDecimal osnovica2;
	private BigDecimal osnovica3;
	private BigDecimal cenaPaketa1;
	private BigDecimal cenaPaketa2;
	private BigDecimal cenaPaketa3;
	
	
	public int getBrOdraslih() {
		return brOdraslih;
	}
	public void setBrOdraslih(int brOdraslih) {
		this.brOdraslih = brOdraslih;
	}
	public int getBrDece() {
		return brDece;
	}
	public void setBrDece(int brDece) {
		this.brDece = brDece;
	}
	public int getBrDana() {
		return brDana;
	}
	public void setBrDana(int brDana) {
		this.brDana = brDana;
	}
	public double getKoefOdraslih() {
		return koefOdraslih;
	}
	public void setKoefOdraslih(double koefOdraslih) {
		this.koefOdraslih = koefOdraslih;
	}
	public double getKoefDece() {
		return koefDece;
	}
	public void setKoefDece(double koefDece) {
		this.koefDece = koefDece;
	}
	public BigDecimal getKoefRizika() {
		return koefRizika;
	}
	public void setKoefRizika(BigDecimal koefRizika) {
		this.koefRizika = koefRizika;
	}
	public double getKoefDestinacije() {
		return koefDestinacije;
	}
	public void setKoefDestinacije(double koefDestinacije) {
		this.koefDestinacije = koefDestinacije;
	}
	public TipRizika getTipRizika() {
		return tipRizika;
	}
	public void setTipRizika(TipRizika tipRizika) {
		this.tipRizika = tipRizika;
	}
	public Destinacija getDestinacija() {
		return destinacija;
	}
	public void setDestinacija(Destinacija destinacija) {
		this.destinacija = destinacija;
	}
	public BigDecimal getOsnovica1() {
		return osnovica1;
	}
	public void setOsnovica1(BigDecimal osnovica1) {
		this.osnovica1 = osnovica1;
	}
	public BigDecimal getOsnovica2() {
		return osnovica2;
	}
	public void setOsnovica2(BigDecimal osnovica2) {
		this.osnovica2 = osnovica2;
	}
	public BigDecimal getOsnovica3() {
		return osnovica3;
	}
	public void setOsnovica3(BigDecimal osnovica3) {
		this.osnovica3 = osnovica3;
	}
	public BigDecimal getCenaPaketa1() {
		return cenaPaketa1;
	}
	public void setCenaPaketa1(BigDecimal cenaPaketa1) {
		this.cenaPaketa1 = cenaPaketa1;
	}
	public BigDecimal getCenaPaketa2() {
		return cenaPaketa2;
	}
	public void setCenaPaketa2(BigDecimal cenaPaketa2) {
		this.cenaPaketa2 = cenaPaketa2;
	}
	public BigDecimal getCenaPaketa3() {
		return cenaPaketa3;
	}
	public void setCenaPaketa3(BigDecimal cenaPaketa3) {
		this.cenaPaketa3 = cenaPaketa3;
	}
	
}
