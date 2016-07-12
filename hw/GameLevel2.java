package hw;

public class GameLevel2 extends GameLevel {

	private static GameLevel2 gamelevel2 = new GameLevel2();
	
	public static GameLevel2 getGameLevel2(){
		if(gamelevel2 == null){
			gamelevel2 = new GameLevel2();
		}
		
		return gamelevel2;
	}
	
	@Override
	public void simpleAttack() {
		System.out.println("level2 simple Attack");
		
	}
	@Override
	public void flyingAttack() {
		System.out.println("level2 flying Attack");
		
	}
	@Override
	public void turnAttack() {
		System.out.println("사용 불가 (turnAttack)");		
	}

	@Override
	public GameLevel upgradeLevel() {
		GameLevel gameLevel3 = GameLevel3.getGameLevel3();
		
		return gameLevel3;
	}

}
