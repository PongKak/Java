package maze;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		MakeMaze maze = new MakeMaze(10,10);
		
		{
			maze.setMaze(0, 0, 1);
			maze.setMaze(0, 1, 1);
			maze.setMaze(0, 2, 0);
			maze.setMaze(0, 3, 1);
			maze.setMaze(0, 4, 1);
			maze.setMaze(0, 5, 1);
			maze.setMaze(0, 6, 0);
			maze.setMaze(0, 7, 1);
			maze.setMaze(0, 8, 1);
			maze.setMaze(0, 9, 1);
			
			maze.setMaze(1, 0, 0);
			maze.setMaze(1, 1, 1);
			maze.setMaze(1, 2, 1);
			maze.setMaze(1, 3, 1);
			maze.setMaze(1, 4, 0);
			maze.setMaze(1, 5, 1);
			maze.setMaze(1, 6, 1);
			maze.setMaze(1, 7, 1);
			maze.setMaze(1, 8, 0);
			maze.setMaze(1, 9, 0);
			
			maze.setMaze(2, 0, 1);
			maze.setMaze(2, 1, 1);
			maze.setMaze(2, 2, 0);
			maze.setMaze(2, 3, 0);
			maze.setMaze(2, 4, 0);
			maze.setMaze(2, 5, 0);
			maze.setMaze(2, 6, 1);
			maze.setMaze(2, 7, 0);
			maze.setMaze(2, 8, 1);
			maze.setMaze(2, 9, 1);
			
			maze.setMaze(3, 0, 1);
			maze.setMaze(3, 1, 0);
			maze.setMaze(3, 2, 1);
			maze.setMaze(3, 3, 1);
			maze.setMaze(3, 4, 0);
			maze.setMaze(3, 5, 1);
			maze.setMaze(3, 6, 1);
			maze.setMaze(3, 7, 1);
			maze.setMaze(3, 8, 1);
			maze.setMaze(3, 9, 0);
			
			maze.setMaze(4, 0, 1);
			maze.setMaze(4, 1, 1);
			maze.setMaze(4, 2, 0);
			maze.setMaze(4, 3, 1);
			maze.setMaze(4, 4, 0);
			maze.setMaze(4, 5, 1);
			maze.setMaze(4, 6, 0);
			maze.setMaze(4, 7, 0);
			maze.setMaze(4, 8, 1);
			maze.setMaze(4, 9, 1);
			
			maze.setMaze(5, 0, 0);
			maze.setMaze(5, 1, 1);
			maze.setMaze(5, 2, 1);
			maze.setMaze(5, 3, 1);
			maze.setMaze(5, 4, 0);
			maze.setMaze(5, 5, 1);
			maze.setMaze(5, 6, 0);
			maze.setMaze(5, 7, 0);
			maze.setMaze(5, 8, 0);
			maze.setMaze(5, 9, 1);
			
			maze.setMaze(6, 0, 0);
			maze.setMaze(6, 1, 1);
			maze.setMaze(6, 2, 0);
			maze.setMaze(6, 3, 0);
			maze.setMaze(6, 4, 0);
			maze.setMaze(6, 5, 1);
			maze.setMaze(6, 6, 0);
			maze.setMaze(6, 7, 0);
			maze.setMaze(6, 8, 0);
			maze.setMaze(6, 9, 1);
			
			maze.setMaze(7, 0, 0);
			maze.setMaze(7, 1, 1);
			maze.setMaze(7, 2, 1);
			maze.setMaze(7, 3, 1);
			maze.setMaze(7, 4, 0);
			maze.setMaze(7, 5, 1);
			maze.setMaze(7, 6, 1);
			maze.setMaze(7, 7, 0);
			maze.setMaze(7, 8, 0);
			maze.setMaze(7, 9, 1);
			
			maze.setMaze(8, 0, 1);
			maze.setMaze(8, 1, 1);
			maze.setMaze(8, 2, 0);
			maze.setMaze(8, 3, 1);
			maze.setMaze(8, 4, 1);
			maze.setMaze(8, 5, 0);
			maze.setMaze(8, 6, 1);
			maze.setMaze(8, 7, 0);
			maze.setMaze(8, 8, 0);
			maze.setMaze(8, 9, 0);
			
			maze.setMaze(9, 0, 0);
			maze.setMaze(9, 1, 1);
			maze.setMaze(9, 2, 1);
			maze.setMaze(9, 3, 0);
			maze.setMaze(9, 4, 1);
			maze.setMaze(9, 5, 0);
			maze.setMaze(9, 6, 1);
			maze.setMaze(9, 7, 1);
			maze.setMaze(9, 8, 1);
			maze.setMaze(9, 9, 1); // clear
			//maze.setMaze(9, 9, 0); // can not clear
		}
		
		maze.setGoal(9, 9);
		maze.drawMaze();
		maze.playMaze();
	}

}
