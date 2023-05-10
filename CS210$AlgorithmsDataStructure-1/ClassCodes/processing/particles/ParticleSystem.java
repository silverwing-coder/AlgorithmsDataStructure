package processing.particles;

import java.util.ArrayList;

import processing.core.PImage;
import processing.core.PVector;

//A class to describe a group of Particles
//An ArrayList is used to manage the list of Particles 

class ParticleSystem {

	ArrayList<Particle> particles; // An arraylist for all the particles
	PVector origin; // An origin point for where particles are birthed

	ParticleSystem(int num, PVector v) {
		particles = new ArrayList<Particle>(); // Initialize the arraylist
		origin = v.copy();
		for (int i = 0; i < num; i++) {
			particles.add(new Particle(origin)); // Add "num" amount of particles to the arraylist

		}
	}

	ParticleSystem(int num, PVector v, PImage img_) {
		particles = new ArrayList<Particle>(); // Initialize the arraylist
		origin = v.copy(); // Store the origin point
		for (int i = 0; i < num; i++) {
			particles.add(new Particle(origin)); // Add "num" amount of particles to the arraylist
		}
	}

//	void run() {
//		for (int i = particles.size() - 1; i >= 0; i--) {
//			Particle p = particles.get(i);
//			if (p.isDead()) {
//				particles.remove(i);
//			}
//		}
//	}

// Method to add a force vector to all particles currently in the system
	void applyForce(PVector dir) {
		// Enhanced loop!!!
		for (Particle p : particles) {
			p.applyForce(dir);
		}
	}

	void addParticle() {
		particles.add(new Particle(origin));
	}
}