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
		this.goalX = goalX+1;
		this.goalY = goalY+1;
	}
	
	public void mazeFrame(){
		for(int i=0;i<sizeX;i++){
			for(int j=0;j<sizeY;j++){
				if(sizeX==0 || sizeY==0 || sizeX==11 || sizeY==11){
					mazeArray[i][j] = 0;
				}
			}
		}
		mazeArray[1][0] = 1;
	}

	public void drawMaze(){
		for(int i=1;i<sizeX-1;i++){
			for(int j=1;j<sizeY-1;j++){
				if(mazeArray[i][j] ==1)//|| mazeArray[i][j] == 2) 갔다 왔던 자리를 표시 안할때
					System.out.print(" □ ");
				else if(mazeArray[i][j] == 0)
					System.out.print(" ■ ");
				else if(mazeArray[i][j] == 3)
					System.out.print(" * ");
				else
					System.out.print(" ▒ ");
			}
			System.out.println();
		}
		System.out.println();

	}
	public void drawMaze(int x, int y){
		for(int i=1;i<sizeX-1;i++){
			for(int j=1;j<sizeY-1;j++){
				if(i==x&&j==y)
					System.out.print(" * ");
				else if(mazeArray[i][j] ==1)//|| mazeArray[i][j] == 2) 갔다 왔던 자리를 표시 안할때
					System.out.print(" □ ");
				else if(mazeArray[i][j] == 0)
					System.out.print(" ■ ");
				else if(mazeArray[i][j] == 3)
					System.out.print(" * ");
				else
					System.out.print(" ▒ ");
			}
			System.out.println();
		}
		System.out.println();
	}


	public void setMaze(int x,int y,int value){
		this.mazeArray[x+1][y+1]=value;
	}
	
	public boolean checkBefore(int x,int y,ArrayList<Integer> stackX,ArrayList<Integer> stackY){
		for(int i=0;i<stackX.size();i++){
			if(x==stackX.get(i) && y==stackY.get(i))
				return false;
		}
		return true;
	}
	
	
	abstract public void playMaze() throws IOException;
	abstract public void playMazeStepbyStep() throws IOException;

}
