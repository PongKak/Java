package maze;

import java.io.IOException;

public interface IMaze {
	//sets the location of the goal
	public void setGoal(int goalX,int goalY);
	//adds a border around the maze
	public void mazeFrame();
	//draws the all of the walls and passage ways of the maze
	public void drawMaze();
	//sets the value of a specific tile in the maze
	public void setMaze(int x,int y,int value);
	//solves the maze and prints the result
	public void playMaze()  throws IOException;
	//solves the maze and prints out the maze every step
	public void playMazeStepbyStep() throws IOException;
}
