package crc;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class Polinom {
	
	private int grad;
	Vector<Integer> coeficienti;
	public Polinom(short grad, Vector<Integer> coeficienti) {
		this.grad = grad;
		this.coeficienti = coeficienti;
	}
	
	public Polinom()
	{
		this.grad=-1;
		this.coeficienti=new Vector<>();
	}
	
	public int getGrad() {
		return grad;
	}
	public void setGrad(int grad) {
		this.grad = grad;
	}
	public Vector<Integer> getCoeficienti() {
		return coeficienti;
	}
	public void setCoeficienti(Vector<Integer> coeficienti) {
		this.coeficienti = coeficienti;
	}
	
	public String toString() {
		return (" Gradul: "+ grad + " coeficientii: "+ coeficienti);
	}

	public void citire()
	{
		File myFile=new File("src/crc/polinom.txt");
		
		try {
			Scanner scanner=new Scanner(myFile);
			System.out.println(" Gradul este: ");
			grad=scanner.nextInt();
			System.out.println(grad);
			System.out.println(" Iar coeficientii: ");
			for(int i=0;i<grad+1;i++)
			{
				
				int x=scanner.nextInt();
				coeficienti.add(x);
			}
			
		}catch (Exception e) {
			System.out.println("Something wrong, pleas try again");
			grad=-1;
		}
	}
}
