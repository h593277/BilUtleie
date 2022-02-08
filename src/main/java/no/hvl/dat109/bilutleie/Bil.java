package no.hvl.dat109.bilutleie;

public class Bil {
	
	private String registreringsNummer;
	private String merke;
	private String model;
	private String farge;
	private UtleieSted leieSted;
	private Boolean ledig; 
	
	
	public Bil(String registreringsNummer, String merke, String model, String farge, UtleieSted leieSted,
			Boolean ledig) {
		this.registreringsNummer = registreringsNummer;
		this.merke = merke;
		this.model = model;
		this.farge = farge;
		this.leieSted = leieSted;
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


	public UtleieSted getLeieSted() {
		return leieSted;
	}


	public void setLeieSted(UtleieSted leieSted) {
		this.leieSted = leieSted;
	}


	public Boolean getLedig() {
		return ledig;
	}


	public void setLedig(Boolean ledig) {
		this.ledig = ledig;
	}
	
	
	

}
