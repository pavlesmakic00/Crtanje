package zad2;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Program extends Frame implements ItemListener, ActionListener
{
	private Crtez c;
	private Kriva kr;
	private Color boja;
	private TextArea ta;
	private Checkbox radio1, radio2;
	private TextField t1,t2,t3;
	private double xmin=-10,xmax=10,ymin=-10,ymax=10;
	private static final String[] boje = {"crna", "siva", "crvena", "zuta", "zelena", "plava"};
	private static final Color[] cboje = { 
			Color.BLACK, Color.GRAY, Color.RED, 
			Color.YELLOW, Color.GREEN,Color.BLUE
			};
	
	
	public void itemStateChanged(ItemEvent e)
	{
		List l = (List)e.getSource();
		boja=cboje[l.getSelectedIndex()];
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		double tmin,tmax,dt;
		double[] parametri;
		String[] tparametri;
		try
		{
			tparametri=ta.getText().split("\n");
			parametri = new double[tparametri.length];
			for(int i=0;i<tparametri.length;i++)
				parametri[i]=Double.parseDouble(tparametri[i]);
			tmin=Double.parseDouble(t1.getText());
			tmax=Double.parseDouble(t2.getText());
			dt=Double.parseDouble(t3.getText());
			if(radio1.getState()==true)
			{
				if(parametri.length<3)
					return;
				kr=new Spirala(parametri[0],parametri[1],parametri[2]);
			}
			else
			{
				if(parametri.length==0)
					return;
				kr=new Polinom(parametri);
			}
			c.crtaj(kr, boja, tmin, tmax, dt);
		}
		catch(NumberFormatException gr) {}
	}
	
	
	private void popuniProzor()
	{
		setLayout(new BorderLayout());
		ta=new TextArea(10,4);
		add(ta,BorderLayout.WEST); //isto sto i add(ta,"West");
		
		List l=new List(6,false);
		for(int i=0;i<6;i++)
		{
			l.add(boje[i]);
		}
		l.addItemListener(this);
		add(l,BorderLayout.EAST);
		boja=Color.BLACK;
		
		Panel pl = new Panel();
		CheckboxGroup grupa = new CheckboxGroup();
		radio1 = new Checkbox("Spirala",grupa,true);
		pl.add(radio1);
		radio2 = new Checkbox("Polinom",grupa,false);
		pl.add(radio2);
		Button crtaj = new Button("Crtaj");
		crtaj.addActionListener(this);
		pl.add(crtaj);
		add(pl, "South");
		
		pl = new Panel();
		pl.add(new Label("tmin,tmax,dt:", Label.RIGHT));
		t1=new TextField(3);
		t2=new TextField(3);
		t3=new TextField(3);
		pl.add(t1);
		pl.add(t2);
		pl.add(t3);
		add(pl,"North");
		
		c=new Crtez(xmin,xmax,ymin,ymax);
		add(c,"Center");
	}
	
	Program()
	{
		super("Crtanje");
		setBounds(200,200,400,300);
		popuniProzor();
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent dog) { dispose(); }
		});
	}

	public static void main(String[] args) 
	{
		new Program();

	}

}
