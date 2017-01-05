package main.java.pojo;

public class UserInfo {

	public UserInfo(){}
	
	public enum TipRizika {SLAB, JACI, NAJJACI}
	public enum Destinacija {SRBIJA, GRCKA, BUGARSKA, HRVATSKA}
	
	private int brOdraslih;
	private int brDece;
	private int brDana;
	private double koefOdraslih;
	private double koefDece;
	private double koefRizika;
	private double koefDestinacije;
	private TipRizika tipRizika;
	private Destinacija destinacija;
	private double cenaPaketa1;
	private double cenaPaketa2;
	private double cenaPaketa3;
	
	
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
	public double getKoefRizika() {
		return koefRizika;
	}
	public void setKoefRizika(double koefRizika) {
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
	public double getCenaPaketa1() {
		return cenaPaketa1;
	}
	public void setCenaPaketa1(double cenaPaketa1) {
		this.cenaPaketa1 = cenaPaketa1;
	}
	public double getCenaPaketa2() {
		return cenaPaketa2;
	}
	public void setCenaPaketa2(double cenaPaketa2) {
		this.cenaPaketa2 = cenaPaketa2;
	}
	public double getCenaPaketa3() {
		return cenaPaketa3;
	}
	public void setCenaPaketa3(double cenaPaketa3) {
		this.cenaPaketa3 = cenaPaketa3;
	}
	
	
	
}
