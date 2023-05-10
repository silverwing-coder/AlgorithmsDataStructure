package processing.particles;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class SmokeMain{

	private static int CANVAS_WIDTH = 600;
	private static int CANVAS_HEIGHT = 400;
	private static int FRAME_WIDTH = CANVAS_WIDTH + 100;
	private static int FRAME_HEIGHT = CANVAS_HEIGHT + 200;

	public static void main(String[] args) {

		App app = new App(CANVAS_WIDTH, CANVAS_HEIGHT);

		PApplet.runSketch(new String[] { "" }, app);

		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) app.getSurface().getNative();
		canvas.setLocation(40, 40);

		JFrame frame = (JFrame) canvas.getFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);
		frame.setTitle("Color Smoke");
		frame.setIconImage((new ImageIcon("images/icon1.png")).getImage());
//		System.out.println(FRAME_WIDTH + ", " + FRAME_HEIGHT);
	}
}

class App extends PApplet {
//
	private int canvasWidth;// = 600;
	private int canvasHeight;// = 400;

	PImage img;

	ParticleSystem ps;
//	ParticleSystem[] ps = new ParticleSystem[3];

	App(int cWidth, int cHeight) {
		this.canvasWidth = cWidth;
		this.canvasHeight = cHeight;
	}

	@Override
	public void settings() {
//		size(600, 400);
		size(canvasWidth, canvasHeight);
//		System.out.println(width);

	}

	@Override
	public void setup() {
//		img = loadImage("images/chimney1.png");
		ps = new ParticleSystem(0, new PVector(450, 203));
//		ps[0] = new ParticleSystem(0, new PVector(width / 2, height - 60));
//		ps[1] = new ParticleSystem(0, new PVector(width / 4, height - 120));
//		ps[2] = new ParticleSystem(0, new PVector((width / 4) * 3, height - 200));
	}

	@Override
	public void draw() {
		background(255);
//		image(img, 0, 0);

		// Calculate a "wind" force based on mouse horizontal position
//		float dx = PApplet.map((float) mouseX, 0, (float) width, -0.2, 0.2);
		float dx = this.map(mouseX, 0, width, (float) -0.2, (float) 0.2);
		PVector wind = new PVector(dx, 0);
		ps.applyForce(wind);

		for (int i = 0; i < 2; i++) {
			ps.addParticle();
		}

//		for (int i = 0; i < ps.length; i++) {
//			ps[i].applyForce(wind);
//		}
//		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < ps.length; j++) {
//				ps[j].addParticle();
//			}
//		}

		// Draw an arrow representing the wind force
		drawWindArrow(wind, new PVector(width / 2, 50, 0), 500);
		drawParticles(ps);
//		for (int i = 0; i < ps.length; i++) {
//			drawParticles(ps[i]);
//		}

	}

	@Override
	public void keyPressed() {

	}

	// Renders a vector object 'v' as an arrow and a position 'loc'
	void drawWindArrow(PVector v, PVector loc, float scayl) {
		pushMatrix();
		float arrowsize = 4;
		// Translate to position to render vector
		translate(loc.x, loc.y);
		stroke(0, 0, 0);
		// Call vector heading function to get direction (note that pointing up is a
		// heading of 0) and rotate
		rotate(v.heading());
		// Calculate length of vector & scale it to be bigger or smaller if necessary
		float len = v.mag() * scayl;
		// Draw three lines to make an arrow (draw pointing up since we've rotate to the
		// proper direction)
		line(0, 0, len, 0);
		line(len, 0, len - arrowsize, +arrowsize / 2);
		line(len, 0, len - arrowsize, -arrowsize / 2);
		popMatrix();
	}

	// draw particles stored in ParticleSystem object
	void drawParticles(ParticleSystem ps) {

		for (int i = ps.particles.size() - 1; i >= 0; i--) {
			Particle p = ps.particles.get(i);
			p.update();
			fill(250, 100, 100, p.lifespan);
			noStroke();
			ellipse(p.loc.x, p.loc.y, 30, 35);
			if (p.isDead()) {
				ps.particles.remove(i);
			}
		}
	}
}