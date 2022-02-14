package no.hvl.dat109.bilutleie;

import java.time.LocalDateTime;

/**
@author Markus Løtveit
*/

public class LeieAvtale {
	
	public final static int DAGSPRIS = 250;
	
	private int avtaleNummer;
	private Bruker leieTaker;
	private Bil leieBil;
	private LocalDateTime leieFra;
	private LocalDateTime leieTil;
	private int pris;
	private int km;
	private UtleieSted stedet;
	private String kreditNummer;

	public LeieAvtale(int avtaleNummer, Bruker leieTaker, Bil leieBil, LocalDateTime leieFra, LocalDateTime leieTil, UtleieSted stedet, String KreditNummer) {
		this.avtaleNummer = avtaleNummer;
		this.leieTaker = leieTaker;
		this.leieBil = leieBil;
		this.leieFra = leieFra;
		this.leieTil = leieTil;
		this.pris = (leieTil.getDayOfYear() - leieFra.getDayOfYear())*DAGSPRIS;
		km = 0;
		this.stedet = stedet;
		this.kreditNummer = kreditNummer;
	}
	
	public UtleieSted getStedet() {
		return stedet;
	}

	public void setStedet(UtleieSted stedet) {
		this.stedet = stedet;
	}


	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	
	public int getAvtaleNummer() {
		return avtaleNummer;
	}

	public Bruker getLeieTaker() {
		return leieTaker;
	}

	public Bil getLeieBil() {
		return leieBil;
	}

	public LocalDateTime getLeieFra() {
		return leieFra;
	}

	public LocalDateTime getLeieTil() {
		return leieTil;
	}
	

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public void setAvtaleNummer(int avtaleNummer) {
		this.avtaleNummer = avtaleNummer;
	}

	public void setLeieTaker(Bruker leieTaker) {
		this.leieTaker = leieTaker;
	}

	public void setLeieBil(Bil leieBil) {
		this.leieBil = leieBil;
	}

	public void setLeieFra(LocalDateTime leieFra) {
		this.leieFra = leieFra;
	}

	public void setLeieTil(LocalDateTime leieTil) {
		this.leieTil = leieTil;
	}
	
	public void Utløpt()
	{
		if(leieTil.getDayOfYear() - leieFra.getDayOfYear() <= 0)
		{
			leieBil.setLedig(true);
			leieTil = LocalDateTime.now();
		}
	}

}
