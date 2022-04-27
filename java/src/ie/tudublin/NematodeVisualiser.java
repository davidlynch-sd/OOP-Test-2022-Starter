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

	int index = 0;

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
			index--;
		}		
		if (keyCode == RIGHT)
		{
			index++;
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
		textSize(100);
		textAlign(CENTER);
	}
	
	public void draw()
	{
		if(index > nemas.size() - 1)
		{
			index = 0;
		}
		if(index < 0)
		{
			index = nemas.size() -1;
		}
		background(0);
		Nematode n = nemas.get(index);

		n.render(this,tunage);
		fill(255);	
		text(n.name,width/2,height/5);
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
