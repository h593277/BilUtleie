package no.hvl.dat109.bilutleie;

public class Adresse {
	
	private String postNummer;
	private String postSted;
	private String gateAdresse;
	
	public Adresse(String postNummer, String postSted, String gateAdresse) {
		this.postNummer = postNummer;
		this.postSted = postSted;
		this.gateAdresse = gateAdresse;
	}

	public String getPostNummer() {
		return postNummer;
	}

	public void setPostNummer(String postNummer) {
		this.postNummer = postNummer;
	}

	public String getPostSted() {
		return postSted;
	}

	public void setPostSted(String postSted) {
		this.postSted = postSted;
	}

	public String getGateAdresse() {
		return gateAdresse;
	}

	public void setGateAdresse(String gateAdresse) {
		this.gateAdresse = gateAdresse;
	}
	

}
