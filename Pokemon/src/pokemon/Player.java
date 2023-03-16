package pokemon;

import java.util.ArrayList;

public class Player{

	private ArrayList<Pokemon> pokemonTeam;
	private int money;
	private String name;
	private int pokemonOwned;
	

	public Player(String username){
	this.pokemonTeam = new ArrayList<Pokemon>(6);
	this.money = 0;
	this.name = username;
	this.pokemonOwned = 0;

	}

	//getters and setters
	public int getMoney(){
		return money;
	}
	public void addPokemon(Pokemon pokemonAdded){
	pokemonTeam.add(pokemonOwned, pokemonAdded);
	pokemonOwned++;
	
	}
	public ArrayList<Pokemon> getPokemons(){
		return pokemonTeam;
	}
	public Pokemon getPokemon(){
		return pokemonTeam.get(0);
	}
	public String getName(){
		return name;
	}
	
	












}
