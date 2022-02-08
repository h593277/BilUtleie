package no.hvl.dat109.bilutleie;

public class BilUtleieMain {

	public static void main(String[] args) {
		int autoGen = 0;
		Firma firmaet = new Firma();
		while(true)
		{
			Bruker brukeren = new Bruker();
			firmaet.initialiser(brukeren, autoGen);
			autoGen++;
		}
		
		
		

	}

}
