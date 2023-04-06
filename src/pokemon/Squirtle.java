package pokemon;

public class Squirtle extends WaterPokemon {

	public Squirtle(String name){
		super.name = name;
		angriffspunkte = 20;
		kampfpunkte = 120;
		attacke[0][0] = "Tackle";
		attacke[0][1] = "Neutral";
		attacke[1][0] = "Aquaknarre";
		attacke[1][1] = "Wasser";
		erfahrungspunkte = 10;
		entwicklungsstufe = 1;
		pokedexID = "6";
	}
	
	public Squirtle(){
	}
	
	public Wartortle evolve() {
		return new Wartortle(this);
	}
}
