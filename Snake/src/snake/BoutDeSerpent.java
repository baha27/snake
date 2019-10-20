package snake;



public  class BoutDeSerpent {
	int ligne;

	int colonne;

		
	public BoutDeSerpent(int ligne, int colonne) {
		setLigneColonne(ligne, colonne);	
	}
	// constructeur par copie
	public BoutDeSerpent(BoutDeSerpent autreBout) {
		ligne=autreBout.ligne;
		colonne=autreBout.colonne;
	}
	
	public BoutDeSerpent() {
		this(-1,-1);
	}
	
	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public void setLigneColonne(int ligne, int colonne) {
		setLigne(ligne);
		setColonne(colonne);
	}

	public String toString() {
		return "(" + getLigne() + "," + getColonne() + ")";
	}

	public BoutDeSerpent avance(Direction direction) {
		BoutDeSerpent res = new BoutDeSerpent(ligne,colonne);
		
		if (direction.valeur == Direction.N)
			res.ligne--;
		else if (direction.valeur == Direction.S)
			res.ligne++;
		else if (direction.valeur == Direction.E)
			res.colonne++;
		else
			res.colonne--;
		
		return res;
	}
	

	
	public void affiche () {
		System.out.println(toString());
	}
	
		public boolean equals(Object o) {
			if (o.getClass()== getClass())
				return (getLigne()==((BoutDeSerpent)o).getLigne() && getColonne()==((BoutDeSerpent)o).getColonne());
			if (o.getClass()== Pomme.class)
				return (getLigne()==((Pomme)o).ligne && getColonne()==((Pomme)o).colonne);
			return false;

	}
}
