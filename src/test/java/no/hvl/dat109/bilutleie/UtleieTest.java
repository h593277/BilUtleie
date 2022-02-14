package no.hvl.dat109.bilutleie;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UtleieTest {
	
	

	@Test
	void test() {
		
		int autoGen = 0;
		Firma firmaet = new Firma();
		
		//Test data
		Adresse adressen = new Adresse("5533", "Strand", "Furlivegen 10");
		Bil bilen = new Bil("EV223344", "BMW", "I3", "Svart", Klasse.B, true);
		Bil bilen2 = new Bil("EV463141", "Nissan", "Leaf", "Hvit", Klasse.C, true);
		Bil bilen3 = new Bil("EV265264", "Tesla", "Y", "Blå", Klasse.A, true);
		List<Bil> bilene = new ArrayList<Bil>();
		bilene.add(bilen);
		bilene.add(bilen2);
		bilene.add(bilen3);
		UtleieSted stedet = new UtleieSted(1, "Flesland", "55281212", adressen, bilene);
		UtleieSted stedet2 = new UtleieSted(2, "Voss", "55253211", adressen, bilene);
		UtleieSted stedet3 = new UtleieSted(3, "Bergen", "55135467", adressen, bilene);
		firmaet.nySted(stedet);
		firmaet.nySted(stedet2);
		firmaet.nySted(stedet3);
		
		
		//while(true) Loop
		//{
			Bruker brukeren = new Bruker("Per", "Persen", "99009900", adressen, new ArrayList<LeieAvtale>());
			System.out.println("Bruker: " + brukeren.getFornavn() +  " " + brukeren.getEtternavn());
			firmaet.initialiser(brukeren, autoGen);
			
			//Test om bil er lånt
			assertFalse(brukeren.getAvtaler().get(autoGen).getLeieBil().getLedig());
			
			
			autoGen++;
			System.out.println("Firma brukere:");
			firmaet.getBrukere().forEach(x -> System.out.println(x.getFornavn()));
			LeieAvtale avtalenLever = brukeren.getAvtaler().get(autoGen-1);
			brukeren.Leverinn(avtalenLever);
			
			//Test om bil er levert inn og ledig
			assertTrue(avtalenLever.getLeieBil().getLedig());
			
			System.out.println("Ferdig");
		//}
	}

}
