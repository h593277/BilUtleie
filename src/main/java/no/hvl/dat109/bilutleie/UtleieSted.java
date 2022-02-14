package no.hvl.dat109.bilutleie;

import java.util.ArrayList;
import java.util.List;

/**
@author Markus Løtveit
*/

public class UtleieSted {
	
	private int nummer;
	private String navn;
	private String telefonNummer;
	private Adresse adressen;
	private List<LeieAvtale> avtaler;
	private List<Bil> biler;
	
	public UtleieSted(int nummer, String navn, String telefonNummer, Adresse adressen, List<Bil> biler) {
		this.nummer = nummer;
		this.navn = navn;
		this.telefonNummer = telefonNummer;
		this.adressen = adressen;
		this.biler = biler;
		avtaler = new ArrayList<LeieAvtale>();
	}
	

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public String getNavn() {
		return navn;
	}


	public void setNavn(String navn) {
		this.navn = navn;
	}


	public String getTelefonNummer() {
		return telefonNummer;
	}

	public void setTelefonNummer(String telefonNummer) {
		this.telefonNummer = telefonNummer;
	}

	public Adresse getAdressen() {
		return adressen;
	}

	public void setAdressen(Adresse adressen) {
		this.adressen = adressen;
	}

	public List<LeieAvtale> getAvtaler() {
		return avtaler;
	}

	public void setAvtaler(List<LeieAvtale> avtaler) {
		this.avtaler = avtaler;
	}

	public List<Bil> getBiler() {
		return biler;
	}

	public void setBiler(List<Bil> biler) {
		this.biler = biler;
	}
	
	/**
	@author Markus Løtveit
	*Legger til en nyopprettet avtale med brukeren til listen over avtaler.
	*/
	
	public void nyAvtale(LeieAvtale avtalen)
	{
		avtaler.add(avtalen);
		avtalen.getLeieBil().setLedig(false);
	}
	
}
