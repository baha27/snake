package snake;

public class StrategieFactory {
	Serpent serpent;

	public StrategieFactory(Serpent serpent) {
		this.serpent = serpent;
	}

	Strategie makeStrategie(StrategieType type) {

		switch (type) {
		case MURS:
			return new StrategieAvecMurs(serpent);
		case LIBRE:
			return new StrategieLibre(serpent);
		default:
			return new StrategieAvecMurs(serpent);
		}
	}

}
