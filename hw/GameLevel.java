package hw;

public abstract class GameLevel {
	
	public abstract void simpleAttack();
	public abstract void flyingAttack();
	public abstract void turnAttack();
	public abstract GameLevel upgradeLevel();
	
	
	public void play(){
		simpleAttack();
		flyingAttack();
		turnAttack();
	}
}
