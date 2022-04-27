/*NAME : David Lynch
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

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

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
		loadNematodes();
		colorMode(HSB);
		background(0);
		smooth();				
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


	public void draw()
	{	
	}
}
