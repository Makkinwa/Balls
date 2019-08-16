package Pack;

import javax.swing.SwingUtilities;

public class Runner {
public static void main(String[] args) {
	System.out.println("Start");
	SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        	Window window = new Window(500, 500);
        	window.render();
        }
    });
	
}
}
