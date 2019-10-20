package snake;

public class StrategieAvecMurs implements Strategie {



		public Serpent serpent;

		public StrategieAvecMurs(Serpent serpent) {
			this.serpent = serpent;
		}

		@Override
		public void corriger() {
			System.exit(0);
		}

}