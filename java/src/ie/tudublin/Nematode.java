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


		
		float theta = 0;


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

			if(LikesDancing)
			{
				float time = pa.frameCount%60;
				float cycle = 45;

				if(time < 45)	theta += pa.PI/cycle;
				else theta -= pa.PI/cycle;
				ap.unmute();
			}
			else
			{
				theta = 0;
				ap.mute();
			}

			if(eyes)
			{
				float rootAng = pa.PI/3;
				float StalkLen = 50;

				float stemX = startX - (rad * pa.cos(rootAng));
				float stemY = startY -(rad/2 * pa.sin(rootAng));
				float nubX = startX - (StalkLen * pa.cos(rootAng + theta));
				float nubY = startY - (StalkLen * pa.sin(rootAng));

				pa.line(stemX,stemY,nubX,nubY);
				pa.line(pa.width-stemX,stemY,pa.width-nubX,nubY);
				pa.fill(0);
				pa.ellipse(nubX,nubY,10,10);
				pa.ellipse(pa.width-nubX,nubY,10,10);
			}

			for(int i = 0; i < length; i++)
			{
				yPos = startY + (rad*i);

				if(limbs)
				{
					float limbX = pa.cos(theta) * LimbLen;
					float limbY = pa.sin(theta) * LimbLen;
					pa.line(startX-rad-limbX,yPos+limbY,startX - (rad/2), yPos); //left arm
					pa.line(startX+rad+limbX,yPos-limbY,startX + (rad/2), yPos); //right arm
				}
				
				pa.ellipse(startX,yPos,rad,rad);

			}

			
			switch(gender)
			{
				case 'h':
				{	
					pa.ellipse(startX,yPos,rad/2,rad/2);
				
					pa.line(startX,yPos + rad/2,startX,yPos + rad/2 + LimbLen);
					pa.ellipse(startX,yPos + rad/2 + LimbLen,rad/2,rad/2);
					break;
				}
				case 'm':
				{
					pa.line(startX,yPos + rad/2,startX,yPos + rad/2 + LimbLen);
					pa.ellipse(startX,yPos + rad/2 + LimbLen,rad/2,rad/2);
					break;
				}
				case 'f':
				{
					pa.ellipse(startX,yPos,rad/2,rad/2);
					break;
				}
				default:
				{
					break;
				}
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
