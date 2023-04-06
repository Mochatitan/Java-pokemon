package pokemon;

public class Bulbasaur extends GrassPokemon {
	public Bulbasaur(String name){
		super.name = name;
		angriffspunkte = 20;
		kampfpunkte = 120;
		attacke[0][0] = "Tackle";
		attacke[0][1] = "Neutral";
		attacke[1][0] = "Rankenhieb";
		attacke[1][1] = "Pflanze";	
		erfahrungspunkte = 10;
		entwicklungsstufe = 1;
		pokedexID = "3";
	}
	
	public Bulbasaur() {	
	}
	
	public Bulbasaur entwickeltSich() {
		return new Ivysaur(this);
	}
}
