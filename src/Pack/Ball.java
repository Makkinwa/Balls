package Pack;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	private int x;
	private int y;
	private int xSpeed;
	private int ySpeed;
	Ball(){
		x = new Random().nextInt(500);
		y = new Random().nextInt(500);
		xSpeed = new Random().nextInt(2) + 1;
		ySpeed = new Random().nextInt(2) + 1;
		
	}
	
	public void drawBall(Graphics g) {
		update();
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 10, 10);
	}
	
	private void update() {
		x = x + xSpeed;
		y = y + ySpeed;
		if (y > 500 - 30) {
			ySpeed = - ySpeed;
		}
		if (x > 500 - 20) {
			xSpeed = - xSpeed;
		}
		if(y < 0) {
			ySpeed = - ySpeed;
		}
		if(x < 0) {
			xSpeed = - xSpeed;
		}
	}
}
