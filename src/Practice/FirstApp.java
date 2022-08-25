package Practice;

import processing.core.*;

public class FirstApp extends PApplet{
	private String imageURL = "https://www.sandiegoasap.com/gfx/la-jolla-cove-beach.jpg";
	private PImage backgroundImage;
	
	public void setup() {
		  size(500, 500);
		  backgroundImage = loadImage(imageURL);
		}
	
	public void draw() {
		backgroundImage.resize(0, height);
		image(backgroundImage, 0, 0);
		ellipse(width - width/4, height/5, width/5, height/7);
	}
}
