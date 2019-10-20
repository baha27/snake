package snake;

public class StrategieLibre implements Strategie {

	public Serpent serpent;

	public StrategieLibre(Serpent serpent) {
		this.serpent = serpent;
	}

	@Override
	public void corriger () {
		BoutDeSerpent tete= serpent.getTete();
		if (tete.ligne<0) 
			tete.ligne=serpent.getNbLignes()-1;
		if (tete.ligne>=serpent.getNbLignes())
			tete.ligne=0;
		if (tete.colonne<0) 
			tete.colonne=serpent.getNbColonnes()-1;
		if (tete.colonne>=serpent.getNbColonnes())
			tete.colonne=0;
	}	
}
	
