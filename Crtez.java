package zad2;

import java.awt.*;

@SuppressWarnings("serial")
public class Crtez extends Canvas
{
	private double xmin,xmax,ymin,ymax;
	private int sir, vis;
	
	Crtez(double xmin, double xmax, double ymin, double ymax)
	{
		this.xmin=xmin;
		this.xmax=xmax;
		this.ymin=ymin;
		this.ymax=ymax;
	}
	
	public void crtaj(Kriva kk, Color b, double tmin, double tmax, double dt)
	{
		Graphics g = getGraphics();
		sir = getWidth();
		vis = getHeight();
		g.clearRect(0, 0, sir, vis);
		if(kk==null || b==null || tmin==tmax)
			return;
		g.setColor(b);
		Tacka pred = null;
		Tacka sled;
		for(double i=tmin;i<=tmax;i+=dt)
		{
			sled = kk.f(i);
			if(i!=tmin)
				g.drawLine(a(pred.x()), b(pred.y()), a(sled.x()), b(sled.y()));
			pred=sled;
		}
	}
	
	private int a(double x)
	{
		return (int)((x-xmin)/(xmax-xmin)*(sir-1));
	}
	private int b(double y)
	{
		return (int)((ymax-y)/(ymax-ymin)*(vis-1));
	}

}
