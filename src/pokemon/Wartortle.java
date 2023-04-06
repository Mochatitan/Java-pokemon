package pokemon;

public class Wartortle extends WaterPokemon {
	public Wartortle(String name){
		super.name = name;
		angriffspunkte = 25;
		kampfpunkte = 140;
		attacke[0][0] = "Tackle";
		attacke[0][1] = "Neutral";
		attacke[1][0] = "Hydropumpe";
		attacke[1][1] = "Wasser";
		erfahrungspunkte = 50;
		entwicklungsstufe =2;
		pokedexID = "7";
	}
	
	public Wartortle(Squirtle vorstufe) {
		this.name = vorstufe.name;
		this.kampfpunkte = vorstufe.kampfpunkte+20;
		angriffspunkte = 25;
		erfahrungspunkte = 50;
		entwicklungsstufe =2;
		pokedexID = "7";
	}

	public Blastoise evolve() {
		return new Blastoise(this);
	}
}
