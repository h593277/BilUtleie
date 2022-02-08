package no.hvl.dat109.bilutleie;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Firma {
	
	private List<Bruker> brukere;
	private List<UtleieSted> steder;
	
	
	public void initialiser(Bruker bruker, int AutoGen)
	{
		List<String> stederNavn = steder.stream().map(x -> x.getNavn()).collect(Collectors.toList());
		String s = (String) JOptionPane.showInputDialog(null, "Velg utleisted", "Steder", JOptionPane.QUESTION_MESSAGE, null, stederNavn.toArray(), stederNavn.get(0));
		UtleieSted stedet = steder.stream().filter(x -> x.getNavn().equals(s)).findFirst().orElse(null);
		bruker.Leie(stedet, AutoGen);
	}

}
