package snake;

import java.util.Vector;

public class Serpent {
	private int nbLignes;
	private int nbColonnes;
	public Vector<BoutDeSerpent> bouts;
	public Direction direction;
	public Pomme pomme;
	public Strategie strategie;
	
	

	public Serpent(int nbLignes, int nbColonnes, StrategieType strategieType) {
		bouts = new Vector<BoutDeSerpent>();
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		this.direction = new Direction(Direction.E);
		this.strategie= new StrategieFactory(this).makeStrategie(strategieType);
		initialiser();
	}

	private void initialiser() {
		int ligneCentre = getNbLignes() / 2;
		int ColonneCentre = getNbColonnes() / 2;

		for (int b = 0; b < 3; b++) {
			BoutDeSerpent bout;
			bout = new BoutDeSerpent(ligneCentre, ColonneCentre - b);
			bouts.add(bout);
		}
		creationPomme();
	}

	public int getNbLignes() {
		return nbLignes;
	}

	public int getNbColonnes() {
		return nbColonnes;
	}

	@Override
	public String toString() {
		String res = "Serpent :\n";

		res += "Liste des bouts :\n";
		System.out.println("taille:"+bouts.size());
		for (BoutDeSerpent bout : bouts)
			res += bout.toString();
		res += "\n";

		for (int ligne = 0; ligne < getNbLignes(); ligne++) {
			for (int colonne = 0; colonne < getNbColonnes(); colonne++) {
				if ((pomme.ligne==ligne) && (pomme.colonne==colonne))
					res +="@";
				else if (boutDeSerpentEn(ligne, colonne))
					res += "*";
				else
					res += "+";
			}
			res += "\n";
		}
		return res;
	}

	private boolean boutDeSerpentEn(int ligne, int colonne) {
		for (int b = 0; b < bouts.size(); b++) {
			BoutDeSerpent boutEnPositionB = bouts.get(b);
			if (boutEnPositionB.getLigne() == ligne
					&& boutEnPositionB.getColonne() == colonne)
				return true;
		}

		return false;
	}
/*
	public void avance() {
		this.strategie.avance();
	}*/
	
	public void avance() {
		BoutDeSerpent nouvTete = getTete().avance(direction);

		if (!estValide(nouvTete))
			corriger();
		if (teteCollee())
			return;
		nouvTete = getTete().avance(direction);

		for (int b = bouts.size() - 2; b >= 0; b--) {
			BoutDeSerpent boutEnB = bouts.get(b);
				bouts.set(b + 1, boutEnB);
		}

		bouts.set(0, nouvTete);
		if (teteCollee())
			System.out.println("tete Collee!!");
	}

	protected boolean estValide(BoutDeSerpent boutDeSerpent) {
		return estValide(boutDeSerpent.ligne, boutDeSerpent.colonne);
	}

	public boolean estValide(int ligne, int colonne) {
		return ligne >= 0 && ligne < getNbLignes() && colonne >= 0
				&& colonne < getNbColonnes();
	}

	protected BoutDeSerpent getTete() {
		return bouts.get(0);
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	//	System.out.println("direction:"+direction.valeur);
	}
	public Vector<BoutDeSerpent> getListeDesBouts() {
		return bouts;
	}


// pour assurer que la pomme n'apparait pas sur le corps du serpent	
	public boolean estValide(Pomme pomme) {
		for (BoutDeSerpent bout: bouts)
			if (bout.equals(pomme))
				return false;
		return true;
				
	}
	
	public void creationPomme () {
		Pomme pommeCandidate;
		do {
			pommeCandidate = new Pomme(nbLignes-1, nbColonnes-1);
		} 
		while (!estValide(pommeCandidate));
		pomme=pommeCandidate;
	}
	// methode de test si la tete est collee avec le corps (game over) 
	public boolean teteCollee() {
		BoutDeSerpent tete= getTete();
		for (int b=2 ; b<bouts.size(); b++) // commencer à partir de b=2 (tricher :p)
			if (bouts.get(b).equals(tete))
				return true;
		return false;
	}
	public void affiche() {
		System.out.println(toString());
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void corriger () {
		strategie.corriger();
//		
//		BoutDeSerpent tete= getTete();
//		if (tete.ligne<0) tete.ligne=nbLignes-1;
//		if (tete.ligne>=nbLignes) tete.ligne=0;
//		if (tete.colonne<0) tete.colonne=nbColonnes-1;
//		if (tete.colonne>=nbColonnes) tete.colonne=0;
	}
	/*
	public void  corriger() {
		this.strategie.corriger();
	}*/
	public void jouer() {
		boolean jeu= true;
		//while (jeu) {
			avance();
			if (getTete().equals(pomme)) {
				manger();
				creationPomme();
			//	affiche();
			}
			//if (teteCollee())
				//System.exit(1);
		//	}
	}
	
	public void manger() {
		BoutDeSerpent tete = getTete();
		BoutDeSerpent nouvTete = new BoutDeSerpent(tete); // il faut instancier un
														// autre bout
		if (tete.equals(pomme)) {
			nouvTete.avance(direction);
			BoutDeSerpent queue = bouts.get(bouts.size() - 1);
			for (int b = bouts.size() - 1; b > 0; b--)
				bouts.set(b, bouts.get(b - 1));
			bouts.set(0, nouvTete);
			bouts.add(queue);
			
		}
	}
	public void setStrategie(Strategie strategie) {
		this.strategie=strategie;
	}
		
}
