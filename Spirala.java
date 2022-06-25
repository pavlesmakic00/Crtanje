package zad2;

public class Spirala implements Kriva 
{
	private double a,b,c;
	
	public Spirala(double aa, double bb, double cc)
	{
		a=aa;
		b=bb;
		c=cc;
	}
	
	@Override
	public Tacka f(double t) 
	{
		double x = a*t*Math.cos(b*t+c);
		double y = a*t*Math.sin(b*t+c);
		return new Tacka(x,y);
	}
	
	public String opis()
	{
		return "Spirala";
	}
}
