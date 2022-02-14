package no.hvl.dat109.bilutleie;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

/**
@author Markus Løtveit
*/

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
	
	/**
	@author Markus Løtveit
	*Leie metoden, tar inn et utleiested og viser til brukeren hvilke biler som kan leies fra det stedet.
	*/
	public void Leie(UtleieSted stedet, int autoGen)
	{
		List<String> biler = stedet.getBiler().stream().filter(x -> x.getLedig().booleanValue() == true).map(x -> x.getMerke()).collect(Collectors.toList());  
		String s = (String) JOptionPane.showInputDialog(null, "Velg bil", "Merker", JOptionPane.QUESTION_MESSAGE, null, biler.toArray(), biler.get(0));
		
		System.out.println("Bilmerke: " + s);
		
		List<String> bilerModel = stedet.getBiler().stream().filter(x -> x.getLedig().booleanValue() == true && x.getMerke().equals(s)).map(x -> x.getModel()).collect(Collectors.toList());  
		String sModel = (String) JOptionPane.showInputDialog(null, "Velg bil", "Modeller", JOptionPane.QUESTION_MESSAGE, null, bilerModel.toArray(), bilerModel.get(0));
		
		Bil bilen = stedet.getBiler().stream().filter(x -> x.getMerke().equals(s) && x.getModel().equals(sModel) && x.getLedig().booleanValue() == true).findFirst().orElseGet(null);
		
		System.out.println("Bilmodel: " + sModel);
	
	    int yearFra = Integer.parseInt((String) JOptionPane.showInputDialog("Leie fra årstall"));
	    int monthFra = Integer.parseInt((String) JOptionPane.showInputDialog("Leie fra måned"));
	    int dayFra = Integer.parseInt((String) JOptionPane.showInputDialog("Leie fra dag"));
		LocalDateTime leieFra = LocalDateTime.of(yearFra, monthFra, dayFra, 12, 0);
		System.out.println("Leies fra: " + leieFra.toString());
	
	    int year = Integer.parseInt((String) JOptionPane.showInputDialog("Leie til årstall"));
	    int month = Integer.parseInt((String) JOptionPane.showInputDialog("Leie til måned"));
	    int day = Integer.parseInt((String) JOptionPane.showInputDialog("Leie til dag"));
		LocalDateTime leieTil = LocalDateTime.of(year, month, day, 12, 0);
		
		System.out.println("Leies fra: " + leieTil.toString());
		String kreditNummer = (String) JOptionPane.showInputDialog("Oppgi Kreditnummer");
		LeieAvtale avtalen = new LeieAvtale(autoGen, this, bilen, leieFra, leieTil, stedet, kreditNummer);
		System.out.println("Avtalen: " + avtalen.getAvtaleNummer()  + " Pris: " + avtalen.getPris() + " kr");
		stedet.nyAvtale(avtalen);
		avtaler.add(avtalen);
		
		System.out.println("Bilen: Merke: " + avtalen.getLeieBil().getMerke() + " Model: " + avtalen.getLeieBil().getModel() + " Farge: " + avtalen.getLeieBil().getFarge() + " Ledig: " + avtalen.getLeieBil().getLedig());
		
		stedet.getAvtaler().forEach(x -> System.out.println(stedet.getNavn() +  " avtalenr: " + x.getAvtaleNummer()));
		this.avtaler.forEach(x -> System.out.println(this.fornavn + " avtalenr: " + x.getAvtaleNummer()));
	}
	
	public void Leverinn(LeieAvtale avtalen)
	{
	  avtalen.getLeieBil().setLedig(true);
	  avtalen.setLeieTil(LocalDateTime.now());
	  System.out.println("Bilen er levert inn: "+ avtalen.getLeieTil() + " " + avtalen.getLeieBil().getMerke() + " " + avtalen.getLeieBil().getModel() + " " + avtalen.getLeieBil().getLedig());
	  System.out.println("Ved utleiested: " + avtalen.getStedet().getNavn());
	}
	
	

}
