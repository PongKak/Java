package hw;

public class GameLevel3 extends GameLevel {

	private static GameLevel3 gamelevel3 = new GameLevel3();
	
	public static GameLevel3 getGameLevel3(){
		if(gamelevel3 == null){
			gamelevel3 = new GameLevel3();
		}
		
		return gamelevel3;
	}
	@Override
	public void simpleAttack() {
		System.out.println("level3 simple Attack");
	}
	@Override
	public void flyingAttack() {
		System.out.println("level3 flying Attack");
		
	}
	@Override
	public void turnAttack() {
		System.out.println("level3 turn Attack");
		
	}
	@Override
	public GameLevel upgradeLevel() {
		
		return this;
	}

}
