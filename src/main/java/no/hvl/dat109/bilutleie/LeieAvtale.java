package no.hvl.dat109.bilutleie;

import java.time.LocalDateTime;

public class LeieAvtale {
	
	public final static int DAGSPRIS = 250;
	
	private int avtaleNummer;
	private Bruker leieTaker;
	private Bil leieBil;
	private LocalDateTime leieFra;
	private LocalDateTime leieTil;
	private int Pris;
	
	public LeieAvtale(int avtaleNummer, Bruker leieTaker, Bil leieBil, LocalDateTime leieFra, LocalDateTime leieTil) {
		this.avtaleNummer = avtaleNummer;
		this.leieTaker = leieTaker;
		this.leieBil = leieBil;
		this.leieFra = leieFra;
		this.leieTil = leieTil;
		this.Pris = (leieTil.getDayOfYear() - leieFra.getDayOfYear())*DAGSPRIS;
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

}
