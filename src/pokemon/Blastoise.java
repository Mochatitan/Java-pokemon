package pokemon;


public class Blastoise extends WaterPokemon{
	public Blastoise(String name){
		super.name = name;
		angriffspunkte = 30;
		kampfpunkte = 160;
		attacke[0][0] = "Tackle";
		attacke[0][1] = "Neutral";
		attacke[1][0] = "Flut";
		attacke[1][1] = "Wasser";
		erfahrungspunkte = 100;
		entwicklungsstufe=3;
		pokedexID = "8";
	}
	
	public Blastoise(Wartortle vorstufe) {
		this.name = vorstufe.name;
		this.kampfpunkte = vorstufe.kampfpunkte+20;
		angriffspunkte = 160;
		erfahrungspunkte = 100;
		entwicklungsstufe=3;
		pokedexID = "8";
	}
	
	@Override
	public Blastoise evolve() {
		return this;
	}
}
