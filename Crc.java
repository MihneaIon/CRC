package crc;

import java.util.Scanner;
import java.util.Vector;

public class Crc {

	private String sir;
	private Polinom polinom;

	public Crc() {
		sir = "default";
		polinom = new Polinom();
		polinom.citire();
	}

	public void start() {
		sir=read();
		if (validare(sir)) {
			String var = extend(sir);
			String aux="";
			aux=transform(var);
			System.out.println(aux);
		} else {
			System.out.println(" o greseala ");
		}

	}

	public String getSir() {
		return sir;
	}

	public void setSir(String sir) {
		this.sir = sir;
	}

	public Polinom getPolinom() {
		return polinom;
	}

	public void setPolinom(Polinom polinom) {
		this.polinom = polinom;
	}

	public String read() {
		 System.out.println(" Citeste sirul: ");
		 Scanner scanner=new Scanner(System.in);
		 sir=scanner.nextLine();
		 System.out.println(sir);
		return sir;
	}

	public boolean validare(String message) {
		if (message.matches("[01]*"))
			return true;
		else {
			return false;
		}
	}

	public String extend(String message) {
		StringBuilder stringBuilder = new StringBuilder(message);
		for (int i = 0; i < polinom.getGrad(); i++) {
			stringBuilder.append(0);
		}
		return stringBuilder.toString();
	}

	public String transform(String message) {

		Vector<Integer> vector = new Vector<>();
		for (char carcatter : message.toCharArray()) {
			vector.add(Integer.parseInt(carcatter + ""));
		}

		Vector<Integer> vectorPolinom = polinom.getCoeficienti();

		int length = vectorPolinom.size();
		int n = 0;
		for (int i = 0; i < vector.size() - length; i++) {
			vectorPolinom.add(0);
		}

		Vector<Integer> vectorAdunare;
		boolean ok = true;
		do {
			vectorAdunare = new Vector<>();
			for (int i = 0; i < vector.size(); i++) {
				n = vector.elementAt(i) ^ vectorPolinom.elementAt(i);
				vectorAdunare.add(n);
			}
			n = 0;
			while (vectorAdunare.elementAt(0) != 1) {
				vectorAdunare.remove(0);
				n++;
			}
			vector = vectorAdunare;
			if (vector.size() < polinom.getGrad() + 1)
				ok = false;
			while (n > 0) {
				vectorPolinom.remove(vectorPolinom.size() - 1);
				n--;
			}

		} while (ok == true);

		
		Vector<Integer> vectorFinal=new Vector<>();
		for (char carcatter : message.toCharArray()) {
			vectorFinal.add(Integer.parseInt(carcatter + ""));
		}
		
		n=vector.size();
		System.out.println(n);
		for(int i=0;i<(vectorFinal.size()-n);i++)
		{
			vector.add(0,0);
			System.out.println(vector);
		}
		
		for(int i=0;i<vectorFinal.size();i++)
		{
			n=vectorFinal.elementAt(i)^vector.elementAt(i);
			vectorFinal.set(i, n);
		}
		
		StringBuilder sBuilder=new StringBuilder();
		for(Integer i:vectorFinal)
		{
			sBuilder.append(i);
		}
		
		return sBuilder.toString();
		
		

	}
}