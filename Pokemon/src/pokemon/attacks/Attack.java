package pokemon.attacks;

public abstract class Attack {

	private int dmg;
	private int maxUses;
	private int uses;

	public Attack(int dmg, int maxTimesUsed){
		this.dmg = dmg;
		this.uses = maxTimesUsed;
		this.maxUses = maxTimesUsed;

	}




	public void use(){
		uses--;
	}




	//getters and setters
	
	public int getDamage(){
		return dmg;
	}
	public void setDamage(int newDamage){
		dmg = newDamage;
	}

	public int getUses(){
		return uses;
	}
	public int getMaxUses(){
		return maxUses;
	}

	








}
