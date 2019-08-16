package Pack;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends Canvas {
    private Ball[] ball = new Ball[100];
	private BufferStrategy bs;
	private Graphics g;
	private static int width;
	private static int height;
	@SuppressWarnings("static-access")
	Window(int width, int height){
		for (int i = 0; i < ball.length; i++) {
			ball[i] = new Ball();
		}
		this.width = width;
		this.height = height;
		JFrame f = new JFrame("Program");
		f.setLocationRelativeTo(null);
		f.setPreferredSize(new Dimension(width, height));
		f.setDefaultCloseOperation(3);
		f.add(this);
		f.pack();
		f.setResizable(true);
		f.setVisible(true);
	}
	
	public static int getWindowWidth() {
		return width;
	}
	public static int getWindowHeight() {
		return height;
	}
	

	public void render() {
		if(bs == null)
			createBufferStrategy(3);
		bs = getBufferStrategy();
		g = bs.getDrawGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		onRender();
		g.dispose();
		bs.show();
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
		}
		EventQueue.invokeLater(() -> render());
	}
	
	private void onRender() {
		for (int i = 0; i < ball.length; i++) {
			ball[i].drawBall(g);
		}
	}
}
