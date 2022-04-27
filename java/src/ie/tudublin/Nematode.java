package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;
import ddf.minim.AudioPlayer;

import ddf.minim.Minim;


public class Nematode
{
		//Constructor Vars
		String name;
		int length;
		char gender;
		boolean eyes, limbs;

		
		//newStuff
		boolean LikesDancing;

		public Nematode(TableRow data)
		{
			
		
			this.name =	data.getString("name");
			this.length = data.getInt("length");
			this.gender = data.getString("gender").charAt(0);
			this.eyes = data.getInt("eyes") == 1; //Will return true if eyes is 1 by evaluating the expression.
			this.limbs = data.getInt("limbs") ==1;
			this.LikesDancing = data.getInt("likes dancing") == 1; 
		
		}


		


		//Where the magic happens
		public void render(PApplet pa, AudioPlayer ap)
		{		
			
			//General use variables
		
			float startX = pa.width/2;
			float startY = pa.height/2;
			float rad = 30;

			for(int i = 0; i < length; i++)
			{
				pa.noFill();
				pa.stroke(pa.map(i,0,length,0,255),255,255);
				pa.ellipse(startX,startY+(rad *i), rad,rad);	
			}


			if(limbs)
			{

			}

			if(eyes)
			{

			}
			
			if(LikesDancing)
			{
				ap.unmute();
			}
			else
			{
				ap.mute();
			}




		}		
		
		//Accessor methods: getters and setters :>
		public String getName(){return name;}
		public void setName(String name){this.name = name;}

		public boolean getEyes(){return eyes;}
		public void setEyes(boolean eyes){this.eyes = eyes;}

		public boolean getLimbs(){return limbs;}
		public void setLimbs(boolean limbs){this.limbs = limbs;}

		public boolean  getDance(){return LikesDancing;}
		public void setDance(boolean dancing){this.LikesDancing = dancing;}

		public int GetLength(){return length;}
		public void setLength(int length){this.length = length;}
	

}
