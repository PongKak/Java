package hw;

public class GameLevel1 extends GameLevel{
	
	private static GameLevel1 gamelevel1 = new GameLevel1();
	
	public static GameLevel1 getGameLevel1(){
		if(gamelevel1 == null){
			gamelevel1 = new GameLevel1();
		}
		
		return gamelevel1;
	}


	@Override
	public void simpleAttack() {
		System.out.println("level1 simple Attack");
	}

	@Override
	public void flyingAttack() {
		System.out.println("사용 불가 (flyingAttack)");		
	}

	@Override
	public void turnAttack() {
		System.out.println("사용 불가 (turnAttack)");
		
	}


	@Override
	public GameLevel upgradeLevel() {
		GameLevel gameLevel2 = GameLevel2.getGameLevel2();
		
		return gameLevel2;
		
	}



}
