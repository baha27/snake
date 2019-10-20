package snake;
import java.util.Random;

public class Pomme {
	 public int ligne;
	 public int colonne;
	
	public Pomme(int NbLignes , int NbColonnes) {
		ligne = (int)(Math.random() * NbLignes);
		colonne = (int)(Math.random() * NbColonnes);
	}
	
	
	public Pomme(int ligne ,int colonne ,String str) {
		if (str=="defaut")
		{	this.ligne=ligne;
			this.colonne=colonne;
		}
	}
}
