import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsHelloWorld extends JPanel {
	
	float hue = 0;
	
	String helloWorld = "Hello World";

	public static void main(String[] args) {
		new GraphicsHelloWorld();
	}
	
	GraphicsHelloWorld() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(300, 200);
		frame.setResizable(false);
		frame.setContentPane(this);
		frame.setVisible(true);
		
		this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
		
		startUpdateLoop();
	}
	
	void startUpdateLoop() {
		long now = System.nanoTime(), lastLoop = now, loopTime = 1000000000 / 10;
		while (true) {
			if ((now = System.nanoTime()) - lastLoop >= loopTime) {
				hue += 0.01;
				if (hue == 1) 
					hue = 0;
				render();
				lastLoop = now;
			}
		}
	}
	
	void render() {
		Graphics g = this.getGraphics();
		g.setColor(Color.getHSBColor(hue, 1f, 0.5f));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.getHSBColor(hue, 1f, 1f));
		g.drawString(helloWorld, this.getWidth() / 2 - g.getFontMetrics().stringWidth(helloWorld) / 2, this.getHeight() / 2 - g.getFontMetrics().getHeight() / 2);
	}

}
