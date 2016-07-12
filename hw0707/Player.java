package hw;

public class Player {
	
	GameLevel gamelevel;
	
	public Player(){
		getGameLevel();
	}
	
	public void getGameLevel(){
		gamelevel = new GameLevel1();
	}
	
	public void upgradeLevel(){
		gamelevel = gamelevel.upgradeLevel();
	}
	public void attack(){
		gamelevel.play();
	}

}
