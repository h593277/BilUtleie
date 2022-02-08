package no.hvl.dat109.bilutleie;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Bruker {
	
	private String fornavn;
	private String etternavn;
	private String telefoNummer; 
	private Adresse adressen;
	private List<LeieAvtale> avtaler;
	
	
	public Bruker(String fornavn, String etternavn, String telefoNummer, Adresse adressen, List<LeieAvtale> avtaler) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.telefoNummer = telefoNummer;
		this.adressen = adressen;
		this.avtaler = avtaler;
	}
	
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	public String getTelefoNummer() {
		return telefoNummer;
	}
	public void setTelefoNummer(String telefoNummer) {
		this.telefoNummer = telefoNummer;
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
	
	public void Leie(UtleieSted stedet, int autoGen)
	{
		List<String> biler = stedet.getBiler().stream().filter(x -> x.getLedig().booleanValue() == true).map(x -> x.getModel()).collect(Collectors.toList());  
		String s = (String) JOptionPane.showInputDialog(null, "Velg bil", "Biler", JOptionPane.QUESTION_MESSAGE, null, biler.toArray(), biler.get(0));
		
		Bil bilen = stedet.getBiler().stream().filter(x -> x.getModel().equals(s) && x.getLedig().booleanValue() == true).findFirst().orElseGet(null);
		
		String leie = (String) JOptionPane.showInputDialog("Skriv inn dato til på format: yyyy-mm-dd");
		LocalDateTime leieFra = LocalDateTime.now();
		leieFra = LocalDateTime.parse(leie + "T" + leieFra.getHour() + ":" + leieFra.getMinute() + ":" + leieFra.getSecond());
		
		leie = (String) JOptionPane.showInputDialog("Skriv inn dato fra på format: yyyy-mm-dd");
		
		LocalDateTime leieTil = LocalDateTime.now();
	    leieTil = LocalDateTime.parse(leie + "T" + leieTil.getHour() + ":" + leieTil.getMinute() + ":" + leieTil.getSecond());
		
		LeieAvtale avtalen = new LeieAvtale(autoGen, this, bilen, leieTil, leieFra);
		stedet.nyAvtale(avtalen);
		avtaler.add(avtalen);
	}
	
	public void Leverinn(LeieAvtale avtalen)
	{
	  avtalen.getLeieBil().setLedig(true);
	  avtalen.setLeieTil(LocalDateTime.now());
	}
	
	

}
