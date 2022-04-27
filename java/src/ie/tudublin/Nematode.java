package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;



public class Nematode
{

		String name;
		int length;
		boolean eyes, limbs;

		//newStuff
		boolean LikesDancing;

		public Nematode(TableRow data)
		{
			
		
			this.name =	data.getString("name");
			this.length = data.getInt("length");
			this.eyes = data.getInt("eyes") == 1; //Will return true if eyes is 1 by evaluating the expression.
			this.limbs = data.getInt("limbs") ==1;
			this.LikesDancing = data.getInt("likes dancing") == 1; 
		
		}

		public void render()
		{		
			
		}		


}
