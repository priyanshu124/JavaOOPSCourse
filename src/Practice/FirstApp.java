package Practice;

import processing.core.*;

public class FirstApp extends PApplet {
	private static final long serialVersionUID = 1L;
	private String imageURL = "https://www.sandiegoasap.com/gfx/la-jolla-cove-beach.jpg";
	private PImage backgroundImage;

	public void setup() {
		  size(500, 500);
		  background(255);
		  stroke(0);
		  backgroundImage = loadImage(imageURL);
		}
	
	public void draw() {
		backgroundImage.resize(0, height);
		image(backgroundImage, 0, 0);
		int[] color = sunColorSec(second());
		fill(color[0], color[1], color[2]);
		ellipse(width - width/4, height/5, width/5, height/7);
	}


	public int[] sunColorSec(float seconds) {
		
		int [] rgb = new int[3];
		
		float ratio = Math.abs(30-seconds)/30;
		rgb[0] = (int)(255*ratio);
		rgb[1] = (int)(255*ratio);
		rgb[2] = 0;
		
		return rgb;
	}
}