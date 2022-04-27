/*NAME : David Lynch
 *
 *STUDENT NO: C19500876
 *
 *Nematode Visualiser 
 *
 * Compiled using mcompile.sh
 *
 * OS: EndeavourOS
 * 
 */



package ie.tudublin;

import java.util.ArrayList;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	Minim minim;
	PApplet pa;
	AudioPlayer tunage;
	ArrayList<Nematode> nemas = new ArrayList<Nematode>(); 


	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{

		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{

		minim = new Minim(this);
		tunage = minim.loadFile("data/singItBack.mp3",1024);

		

		tunage.play();
		loadNematodes();
		colorMode(HSB);
		background(0);
		smooth();				
	}
	
	public void draw()
	{	
		background(0);
		Nematode n = nemas.get(0);
		n.render(this,tunage);
	}
	
	//Loads the todes :D
	public void loadNematodes()
	{
		Table table = loadTable("data/nematodes.csv","header");

		for(TableRow row:table.rows())
		{
			Nematode n = new Nematode(row);
			nemas.add(n);
		}
	}


}
