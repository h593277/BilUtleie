package no.hvl.dat109.bilutleie;

public class BilUtleieMain {

	public static void main(String[] args) {
		int autoGen = 0;
		Firma firmaet = new Firma();
		Adresse adressen = new Adresse("5533", "Strand", "Furlivegen 10");
		while(true)
		{
			Bruker brukeren = new Bruker("Per", "Persen", "99009900", adressen, null);
			firmaet.initialiser(brukeren, autoGen);
			autoGen++;
		}
		
		
		

	}

}
