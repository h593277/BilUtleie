package no.hvl.dat109.bilutleie;

/**
@author Markus Løtveit
*/

public class Bil {
	
	private String registreringsNummer;
	private String merke;
	private String model;
	private String farge;
	private Klasse klasse;
	private Boolean ledig; 
	
	
	public Bil(String registreringsNummer, String merke, String model, String farge, Klasse klasse,
			Boolean ledig) {
		this.registreringsNummer = registreringsNummer;
		this.merke = merke;
		this.model = model;
		this.farge = farge;
		this.klasse = klasse;
		this.ledig = ledig;
	}


	public String getRegistreringsNummer() {
		return registreringsNummer;
	}


	public void setRegistreringsNummer(String registreringsNummer) {
		this.registreringsNummer = registreringsNummer;
	}


	public String getMerke() {
		return merke;
	}


	public void setMerke(String merke) {
		this.merke = merke;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getFarge() {
		return farge;
	}


	public void setFarge(String farge) {
		this.farge = farge;
	}

	

	public Klasse getKlasse() {
		return klasse;
	}


	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}


	public Boolean getLedig() {
		return ledig;
	}


	public void setLedig(Boolean ledig) {
		this.ledig = ledig;
	}
	
	
	

}
