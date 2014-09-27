package de.malikatalla.kilobolt;

public class Background {
	private int bgX;
	private int bgY;
	private int speedX;

	public Background(int x, int y) {
		bgX = x;
		bgY = y;
		speedX = 0;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void update() {
		bgX += speedX;

		if (bgX <= -2160) {
			bgX += 4320;
		}
	}

	public int getBgX() {
		return bgX;
	}

	public int getBgY() {
		return bgY;
	}
}
