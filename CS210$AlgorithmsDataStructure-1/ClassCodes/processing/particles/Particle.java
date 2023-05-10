package processing.particles;

import processing.core.PApplet;
import processing.core.PVector;

//A simple Particle class, renders the particle as an image

class Particle extends PApplet {
	PVector loc;
	PVector vel;
	PVector acc;
	float lifespan;

	Particle(PVector l) {
		acc = new PVector(0, 0);
		float vx = (float) (randomGaussian() * 0.3);
		float vy = (float) ((randomGaussian() * 0.3) - 2);
		vel = new PVector(vx, vy);
		loc = l.copy();
		lifespan = (float) 120.0;
	}

// Method to apply a force vector to the Particle object
// Note we are ignoring "mass" here
	void applyForce(PVector f) {
		acc.add(f);
	}

// Method to update position
	void update() {
		vel.add(acc);
		loc.add(vel);
		lifespan -= 2.5;
		acc.mult(0); // clear Acceleration
	}

// Is the particle still useful?
	boolean isDead() {
		if (lifespan <= 0.0) {
			return true;
		} else {
			return false;
		}
	}
}