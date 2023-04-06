package pokemon;

public abstract class Pokemon {
	public String name;
	public String pokedexID;
	public int entwicklungsstufe;
	public double kampfpunkte;
	public double angriffspunkte;
	public String[][] attacke = new String[2][2];
	public int erfahrungspunkte;
	public String status = "angriff";
	public String lebendig = "lebendig";
	
	public String name;
        public String pokedexID;
        public int evolution;
        public double battlePoints;
        public double attackPoints;
        public String[][] attack = new String[2][2];
        public int exp;
        public String status = "attack";
        public String alive = "alive";
	
	public Pokemon(String name){
		this.name = name;
	}
	
	public Pokemon() {	
	}
	
	public abstract Pokemon evolve();
	
	@Override
	public String toString() {
		String type = "";
		if(this instanceof FirePokemon) {
			type = "Fire";
		} else if(this instanceof WaterPokemon) {
			type = "Water";
		} else if (this instanceof GrassPokemon) {
			type = "Grass";
		}
		return(this.name + " (" + this.getClass().getSimpleName() + " | " + type + " | " + this.battlePoints + " KP; " +  this.attackPoints + " AP)");
	}

	/* This factor depends on the type of the chosen attack.
	 * It may be that you'll hit the wild Pokemon perfectly and get a "Volltreffer" (alias "impact") which causes more damage to its "kampfpunkte".
	 * */	
	public double getAttackFactor(Pokemon opponent, String attackType) {
		if(attackType.equals(this.attack[0][1])) {
			return this.attackPoints;
		}
		
		if((this instanceof FirePokemon) && (opponent instanceof WaterPokemon)) {
			if(attackType.equals("Fire")){
				System.out.println("Das war nicht sehr effektiv! ");
				return this.attackPoints/2;
			}
		}
		
		if((this instanceof FirePokemon) && (opponent instanceof GrassPokemon)) {
			if(attackType.equals("Fire")){
				System.out.println("Das war sehr effektiv! ");
				return this.attackPoints*2;
			}
		}
		
		if((this instanceof GrassPokemon) && (opponent instanceof WaterPokemon)) {
			if(attackType.equals("Grass")){
				System.out.println("Das war sehr effektiv! ");
				int impact = (int)(Math.random()*20);
					if(impact > 15) {
						System.out.print("Volltreffer! ");
						return this.attackPoints*2+impact;
					}
				return this.attackPoints*2;
			} 
		}
		
		if((this instanceof GrassPokemon) && (opponent instanceof FirePokemon)) {
			if(attackType.equals("Grass")){
				System.out.println("Das war nicht sehr effektiv! ");
				return this.attackPoints/2;
			} 
		}
		
		if((this instanceof WaterPokemon) && (opponent instanceof FirePokemon)) {
			if(attackType.equals("Water")){
				System.out.print("Das war sehr effektiv! ");
				int impact = (int)(Math.random()*20);
					if(impact > 15) {
						System.out.print("Volltreffer! ");
						return this.attackPoints*2 +impact;
					}
				return this.attackPoints*2;
			} 
		}
		if((this instanceof WaterPokemon) && (opponent instanceof GrassPokemom)) {
			if(attackType.equals("Water")){
				System.out.println("Das war nicht sehr effektiv! ");
				return this.attackPoints/2;
			} else {
				return this.attackPoints;
			}
		}
		if((this instanceof WaterPokemon) && (opponent instanceof WaterPokemon)) {
			int impact = (int)(Math.random()*20);
			if(impact > 15) {
				System.out.println("Volltreffer!");
				return this.attackPoints*2+impact;
			}
		}
		
		if((this instanceof FirePokemon) && (opponent instanceof FirePokemon)) {
			int impact = (int)(Math.random()*20);
			if(impact > 15) {
				System.out.print("Volltreffer! ");
				return this.attackPoints+impact;
			}
		}
		
		if((this instanceof  GrassPokemon) && (opponent instanceof GrassPokemon)) {
			int impact = (int)(Math.random()*20);
			if(impact > 15) {
				System.out.print("Volltreffer! ");
				return this.attackPoints+impact;
			}
		}
			return this.attackPoints;
	}
	
	public void attacks(Pokemon opponent, String attack) {
		opponent.battlePoints = opponent.battlePoints - this.getAttackFactor(opponent,attack);
	}	
	
	public void increaseExp () {
		this.exp = this.exp+30;
		System.out.println("Dein " + this.getClass().getSimpleName() + " hat 30 Erfahrungspunkte hinzugewonnen!");	
	}
	
}
