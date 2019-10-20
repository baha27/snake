package snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class FenetreSerpent extends JFrame {
	/** */
	private static final long serialVersionUID = 1L;

	public FenetreSerpent() {
		
		setTitle("Serpent Baha");
		setSize(800, 800);
		PanelSerpent panelSerpent = new PanelSerpent();
		add(panelSerpent);
		
		System.out.println(panelSerpent.serpent.direction.valeur);
		KeyListener changeDirection = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP && panelSerpent.serpent.direction.valeur != Direction.S)
					panelSerpent.serpent.setDirection(new Direction(Direction.N));	
				else if (e.getKeyCode() == KeyEvent.VK_DOWN && panelSerpent.serpent.direction.valeur != Direction.N)
					panelSerpent.serpent.setDirection(new Direction(Direction.S));
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT && panelSerpent.serpent.direction.valeur != Direction.O)
					panelSerpent.serpent.setDirection(new Direction(Direction.E));
				else if (e.getKeyCode() == KeyEvent.VK_LEFT && panelSerpent.serpent.direction.valeur != Direction.E)
					panelSerpent.serpent.setDirection(new Direction(Direction.O));
				
			}
		};
		this.addKeyListener(changeDirection);
	}
}
