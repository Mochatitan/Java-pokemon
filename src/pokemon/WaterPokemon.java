package pokemon;
public abstract class WaterPokemon extends Pokemon {

	public WaterPokemon(String name) {
		super.name = name;
	}
	
	public WaterPokemom() {
	}

	public boolean evolutionCheck(Pokemon[] team) {
		if((this.evolution == 1) && (this.exp >= 50)) {
				team[2]=((Squirtle)this).evolve();
				PokeGame.myPokemon = team[2];
				return true;
		}
	
		if((this.evolution == 2) && (this.exp >= 100)) {
				if(this.name.equals("Ulrich")) { //unknown what this does
					team[2] = ((Wartortle)this).evolve();
					PokeGame.myPokemon = team[2];
					return true;
				} else {
					team[4] = ((Wartortle)this).evolve();
					PokeGame.myPokemon = team[4];
					return true;
				}
		}
		return false;

	}
	public abstract WaterPokemon evolve();
}
