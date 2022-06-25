package zad2;

public class Polinom implements Kriva 
{
	private double[] p;
	
	public Polinom(double[] niz)
	{
		p=niz.clone();
	}
	
	@Override
	public Tacka f(double t) 
	{
		double x = t;
		double y=p[0];
		for(int i = 1; i<p.length; y=y*t+p[i++]);
		return new Tacka(x,y);
	}
	public String opis()
	{
		return "Polinom";
	}

}
