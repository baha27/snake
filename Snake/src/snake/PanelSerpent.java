package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelSerpent extends JPanel {

	private static final long serialVersionUID = 1L;

	public Serpent serpent;

	public PanelSerpent() {
		setBackground(Color.pink);
		serpent = new Serpent(25, 25, StrategieType.LIBRE);
		
		

		ActionListener tache = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				serpent.jouer();
				repaint();
			}
		};

		Timer timer = new Timer(100, tache);
		timer.start();
		// ------------------------------------------------------------
		
		/*
		ActionListener change = new ActionListener() {
		  
		  @Override public void actionPerformed(ActionEvent arg0) { int value = new
		  Random().nextInt(4); serpent.setDirection(new Direction(value)); repaint(); }
		  };
		 
		 Timer timer2 = new Timer(200,change); timer2.start();
		 */
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);

		for (int ligne = 0; ligne <= serpent.getNbLignes(); ligne++) {
			graphics.setColor(Color.WHITE);
			graphics.drawLine(tailleBord, tailleBord + ligne * tailleBout,
					tailleBord + serpent.getNbColonnes() * tailleBout,

					tailleBord + ligne * tailleBout);
		}

		for (int colonne = 0; colonne <= serpent.getNbColonnes(); colonne++) {
			graphics.setColor(Color.WHITE);
			graphics.drawLine(tailleBord + colonne * tailleBout, tailleBord,

					tailleBord + colonne * tailleBout, tailleBord + serpent.getNbLignes() * tailleBout);
		}

		for (BoutDeSerpent boutDeSerpent : serpent.getListeDesBouts())
			dessinDuBout(boutDeSerpent, graphics);
		dessinPomme(serpent.pomme, graphics);
		dessinTete(serpent.getTete(), graphics);
		int ep=5;
		graphics.drawRect(tailleBord-ep, tailleBord-ep, tailleBout*serpent.getNbLignes()+2*ep, tailleBout*serpent.getNbColonnes()+2*ep);
		
	}

	final int tailleBout = 20;
	final int tailleBord = 50;

	int getX(BoutDeSerpent boutDeSerpent) {
		return tailleBord + tailleBout * boutDeSerpent.colonne;
	}

	int getY(BoutDeSerpent boutDeSerpent) {
		return tailleBord + tailleBout * boutDeSerpent.ligne;
	}
	
	int getX(Pomme pomme) {
		return tailleBord + tailleBout * pomme.colonne;
	}

	int getY(Pomme pomme) {
		return tailleBord + tailleBout * pomme.ligne;
	}

	void dessinDuBout(BoutDeSerpent boutDeSerpent, Graphics graphics) {
		int x = getX(boutDeSerpent);
		int y = getY(boutDeSerpent);

		graphics.setColor(Color.YELLOW);
		graphics.fillRect(x, y, tailleBout, tailleBout);

		graphics.setColor(Color.GRAY);
		graphics.drawRect(x, y, tailleBout, tailleBout);
	}
	void dessinTete(BoutDeSerpent boutDeSerpent, Graphics graphics) {
		int x = getX(boutDeSerpent);
		int y = getY(boutDeSerpent);

		graphics.setColor(Color.GREEN);
		graphics.fillRect(x, y, tailleBout, tailleBout);

		graphics.setColor(Color.GRAY);
		graphics.drawRect(x, y, tailleBout, tailleBout);
	}
	
	void dessinPomme(Pomme pomme, Graphics graphics) {
		int x = getX(pomme);
		int y = getY(pomme);

		graphics.setColor(Color.RED);
		graphics.fillOval(x, y, tailleBout, tailleBout);

		graphics.setColor(Color.GRAY);
		graphics.drawOval(x, y, tailleBout, tailleBout);
	}
	
}
