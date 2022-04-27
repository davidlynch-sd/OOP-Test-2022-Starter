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
			pa.noFill();
			//General use variables
		
			float startX = pa.width/2;
			float startY = pa.height/2;
			float rad = 30;

			float LimbLen = 20;

			float yPos = 0;
			float theta = 0;

			if(LikesDancing)
			{
				float time = pa.frameCount%60;
				theta = pa.map(time,0,60,0,pa.PI);
				ap.unmute();
			}
			else
			{
				ap.mute();
			}
			for(int i = 0; i < length; i++)
			{
				pa.stroke(255);
				yPos = startY + (rad*i);
				if(limbs)
				{
					float limbX = pa.cos(theta) * LimbLen;
					float limbY = pa.sin(theta) * LimbLen;
					pa.line(startX-rad-limbX,yPos+limbY,startX - (rad/2), yPos); //left arm
					pa.line(startX+rad+limbX,yPos+limbY,startX + (rad/2), yPos); //right arm
				}


				pa.ellipse(startX,yPos, rad,rad);	
			}


			if(limbs)
			{

			}

			if(eyes)
			{

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
