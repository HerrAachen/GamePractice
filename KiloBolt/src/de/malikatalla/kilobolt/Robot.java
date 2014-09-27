package de.malikatalla.kilobolt;

import java.awt.Graphics;

public class Robot {
	final int JUMPSPEED = -15;
	final int MOVESPEED = 5;
	final int GROUND = 382;
	
	private int centerX = 100;
	private int centerY = 382;
	private boolean jumped = false;
	private Background bg1;
	private Background bg2;
	
	
	public Robot(Background b1, Background b2){
		this.bg1 =b1;
		this.bg2 = b2;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	private int speedX = 0;
	private int speedY = 1;

	public void update() {
		if (speedX < 0) {
			centerX += speedX;
		}
		if (speedX == 0 || speedX < 0) {
			bg1.setSpeedX(0);
			bg2.setSpeedX(0);

		}
		if (centerX <= 200 && speedX > 0) {
			centerX += speedX;
		}
		if (speedX > 0 && centerX > 200){
			bg1.setSpeedX(-MOVESPEED);
			bg2.setSpeedX(-MOVESPEED);
		}

		// Updates Y Position
		centerY += speedY;
		if (centerY + speedY >= GROUND) {
			centerY = GROUND;
		}

		// Handles Jumping
		if (jumped == true) {
			speedY += 1;

			if (centerY + speedY >= GROUND) {
				centerY = GROUND;
				speedY = 0;
				jumped = false;
			}

		}

		// Prevents going beyond X coordinate of 0
		if (centerX + speedX <= 60) {
			centerX = 61;
		}
	}

	public void moveRight() {
		speedX = 6;
	}

	public void moveLeft() {
		speedX = -6;
	}

	public void stop() {
		speedX = 0;
	}

	public void jump() {
		if (jumped == false) {
			speedY = -15;
			jumped = true;
		}

	}
}