package processing;

import processing.core.PApplet;

public class DemoA  extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("processing.DemoA");
		System.out.println("DemoA");
	}

	@Override
	public void settings() {
		size(800, 600);
	}

	@Override
	public void setup() {
		background(0);
//		fill(204);
	}

	@Override
	public void draw() {
		background(204);
		stroke(255);
		line(0, 0, mouseX, mouseY);
	}

}
