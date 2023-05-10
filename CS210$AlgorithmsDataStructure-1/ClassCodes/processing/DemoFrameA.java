package processing;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class DemoFrameA extends PApplet {
	private static int CANVAS_WIDTH = 900;
	private static int CANVAS_HEIGHT = 600;
	private static int FRAME_WIDTH = CANVAS_WIDTH + 100;
	private static int FRAME_HEIGHT = CANVAS_HEIGHT + 200;

	int gap = 20;
	int thickness = 2;
	String location;

	@Override
	public void settings() {
		size(CANVAS_WIDTH, CANVAS_HEIGHT);
	}

	@Override
	public void setup() {
		noFill();
		strokeWeight(thickness);
		stroke(0);
		background(0);

	}

	@Override
	public void draw() {

		background(255);


		/** Coordinate Demo */
//		background(0);
//		location = "( " + ((Integer) mouseX).toString() + ", " + ((Integer) mouseY).toString() + " )";
//		textSize(15);
//		text(location, mouseX - 20, mouseY);
		
		/** Stroke Demo */
//		stroke(0, random(255), 0);
//		strokeWeight(5);
//		line(300, 300, 300 + random(100), 300 + random(100));
		
		/** Arc Demo */
		float arcLength = (float) (mouseX / 95.0);
		for (int i = gap; i < (width - gap); i += gap) {
			float angle = radians(i);
			arc(width / 2, height / 2, i, i, angle, angle + arcLength);
		}
	}

	@Override
	public void keyPressed() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// *** Processing Operation ***
		DemoFrameA app = new DemoFrameA();
		PApplet.runSketch(new String[] { "" }, app);

		/*** Graphic Container: */
		PSurfaceAWT sfc = (PSurfaceAWT) app.getSurface();
		sfc.setTitle("Processing on JFrame");

		// Java Canvas: draw() graphics on canvas
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) app.getSurface().getNative();
		canvas.setLocation(40, 40);

		// Java Frame: Container of components
		JFrame frame = (JFrame) canvas.getFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Processing on JFrame");
		frame.setLocation(50, 50);
//		frame.setResizable(false);
//		frame.setResizable(true);
//		frame.setVisible(true);

	}

}
