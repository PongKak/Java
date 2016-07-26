package maze;

import java.io.IOException;

public interface IMaze {
	
	public void setGoal(int goalX,int goalY);
	
	public void mazeFrame();

	public void drawMaze();
	public void setMaze(int x,int y,int value);
	public void playMaze()  throws IOException;
	public void playMazeStepbyStep() throws IOException;
}
