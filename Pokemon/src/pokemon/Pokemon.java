package pokemon;

import java.util.ArrayList;

import pokemon.attacks.Attack;

public abstract class Pokemon {

	private int maxHP;
	private int hp;
	protected ArrayList<Attack> attackList;


        public Pokemon(int maxHealth){
		this.maxHP = maxHealth;
		this.hp = maxHP;
		this.attackList = new ArrayList<Attack>();

		}

	public void attack(int attack, Pokemon pokemonAttacked){
		attackList.get(attack).use();
		pokemonAttacked.loseHP(attackList.get(attack).getDamage());
		
	}


	// getters and setters
	public int getHP(){
		return hp;
	}
	public int getMaxHP(){
		return maxHP;
	}

	public void loseHP(int damage){
		hp-=damage;
		if(hp < 0){
			hp = 0;
		}
	}
	public void addAttack(Attack newAttack){
		attackList.add(newAttack);
	}
	public ArrayList<Attack> getAttackList(){
		return attackList;
	}
	public int getAttacks(){
		return attackList.size();
	}



}
