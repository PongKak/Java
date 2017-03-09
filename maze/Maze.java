package maze;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Maze implements IMaze {

	int sizeX;
	int sizeY;
	int goalX;
	int goalY;
	
	
	int mazeArray[][];
	public Maze(){};
	
	public void setGoal(int goalX,int goalY){
		//adds one to account for the border
		this.goalX = goalX+1;
		this.goalY = goalY+1;
	}
	
	public void mazeFrame(){
		//adds a border around the maze
		for(int i=0;i<sizeX;i++){
			for(int j=0;j<sizeY;j++){
				if(sizeX==0 || sizeY==0 || sizeX==11 || sizeY==11){
					//if the location is at the edge of the maze set it to a wall
					mazeArray[i][j] = 0;
				}
			}
		}
		mazeArray[1][0] = 1;
	}

	public void drawMaze(){
		//prints out the maze
		for(int i=1;i<sizeX-1;i++){
			for(int j=1;j<sizeY-1;j++){
				if(mazeArray[i][j] ==1)//prints out the passage ways
					System.out.print(" □ ");
				else if(mazeArray[i][j] == 0)
					System.out.print(" ■ ");//prints out the walls
				else if(mazeArray[i][j] == 3)
					System.out.print(" * ");//prints out the path
				else
					System.out.print(" ▒ ");//prints out the dead ends
			}
			System.out.println();
		}
		System.out.println();

	}
	public void drawMaze(int x, int y){
		//prints out the maze with a * at position x,y
		for(int i=1;i<sizeX-1;i++){
			for(int j=1;j<sizeY-1;j++){
				if(i==x&&j==y)
					System.out.print(" * ");//prints out a * at x,y
				else if(mazeArray[i][j] ==1)
					System.out.print(" □ ");//prints out the passage ways
				else if(mazeArray[i][j] == 0)
					System.out.print(" ■ ");//prints out the walls
				else if(mazeArray[i][j] == 3)
					System.out.print(" * ");//prints out the path
				else
					System.out.print(" ▒ ");//prints out the dead ends
			}
			System.out.println();
		}
		System.out.println();
	}


	public void setMaze(int x,int y,int value){
		this.mazeArray[x+1][y+1]=value;
	}
	//checks if x,y is part of the path
	public boolean checkBefore(int x,int y,ArrayList<Integer> stackX,ArrayList<Integer> stackY){		
		for(int i=0;i<stackX.size();i++){
			if(x==stackX.get(i) && y==stackY.get(i))
				//return false is it is found
				return false;
		}
		//return true if it is not part of the path
		return true;
	}
	
	
	abstract public void playMaze() throws IOException;
	abstract public void playMazeStepbyStep() throws IOException;

}

}
