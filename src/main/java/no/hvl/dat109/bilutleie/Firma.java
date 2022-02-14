package no.hvl.dat109.bilutleie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

/**
@author Markus Løtveit
*/

public class Firma {
	
	private List<Bruker> brukere = new ArrayList<Bruker>();
	private List<UtleieSted> steder = new ArrayList<UtleieSted>();
	
	public void nySted(UtleieSted sted)
	{
		steder.add(sted);
	}
	
	public void nyBruker(Bruker brukeren)
	{
		brukere.add(brukeren);
	}
	
	
	public List<Bruker> getBrukere() {
		return brukere;
	}

	public List<UtleieSted> getSteder() {
		return steder;
	}

	/**
	@author Markus Løtveit
	*Starter en utleie sesjon for en gitt bruker.
	*/
	public void initialiser(Bruker bruker, int AutoGen)
	{
		List<String> stederNavn = steder.stream().map(x -> x.getNavn()).collect(Collectors.toList());
		String s = (String) JOptionPane.showInputDialog(null, "Velg utleisted", "Steder", JOptionPane.QUESTION_MESSAGE, null, stederNavn.toArray(), stederNavn.get(0));
		System.out.println("Utleiested: " + s);
		UtleieSted stedet = steder.stream().filter(x -> x.getNavn().equals(s)).findFirst().orElse(null);
		bruker.Leie(stedet, AutoGen);
	}

}
