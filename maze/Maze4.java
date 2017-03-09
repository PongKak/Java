package maze;

import java.io.IOException;
import java.util.ArrayList;

public class Maze4 extends Maze {
	
	int sizeX;
	int sizeY;
	int goalX;
	int goalY;
	
	
	int mazeArray[][];
	//creates the a maze of size x,y
	public Maze4(int x,int y){
		//adds 2 to the size to account for the border
		this.sizeX = x+2;
		this.sizeY = y+2;
		mazeArray = new int[this.sizeX][this.sizeY];
		//adds a border around the edge of the maze
		this.mazeFrame();
	}
	
	public void setGoal(int goalX,int goalY){
		this.goalX = goalX+1;
		this.goalY = goalY+1;
	}
	
	public void mazeFrame(){
		for(int i=0;i<sizeX;i++){
			for(int j=0;j<sizeY;j++){
				if(sizeX==0 || sizeY==0 || sizeX==11 || sizeY==11){
					// if along any edge of the maze place a wall there
					mazeArray[i][j] = 0;
				}
			}
		}
		mazeArray[1][0] = 1;
	}
	
	public void drawMaze(){
		//loops through all positions in the maze and draws the correct symbol
		for(int i=1;i<sizeX-1;i++){
			for(int j=1;j<sizeY-1;j++){
				if(mazeArray[i][j] ==1)
					System.out.print(" □ ");//print out passage ways
				else if(mazeArray[i][j] == 0)
					System.out.print(" ■ ");//print out walls
				else if(mazeArray[i][j] == 3)
					System.out.print(" * ");//print out path
				else
					System.out.print(" ▒ ");//print out dead ends
			}
			System.out.println();
		}
		System.out.println();

	}
	public void drawMaze(int x, int y){
		//loops through all positions in the maze and draws the correct symbol
		// position x,y will be drawn as a path
		for(int i=1;i<sizeX-1;i++){
			for(int j=1;j<sizeY-1;j++){
				if(i==x&&j==y)
					System.out.print(" * ");//print out path
				else if(mazeArray[i][j] ==1)
					System.out.print(" □ ");//print out passage ways
				else if(mazeArray[i][j] == 0)
					System.out.print(" ■ ");//prints out walls
				else if(mazeArray[i][j] == 3)
					System.out.print(" * ");//print out path
				else
					System.out.print(" ▒ ");//print out dead ends
			}
			System.out.println();
		}
		System.out.println();
	}


	public void setMaze(int x,int y,int value){
		this.mazeArray[x+1][y+1]=value;//used to initialize the maze
	}
	//checks to see if x,y is in the list 
	public boolean checkBefore(int x,int y,ArrayList<Integer> stackX,ArrayList<Integer> stackY){
		for(int i=0;i<stackX.size();i++){
			if(x==stackX.get(i) && y==stackY.get(i))
				return false;//if x,y is in the list return false
		}
		return true;//return true since it was not found
	}
	
	
	public void playMaze() throws IOException{
		//initializes the starting location in the maze
		int x=1;
		int y=0;
		
		int n,e,w,s;
		ArrayList<Integer> stackX = new ArrayList<Integer>();//list will save the x-coords of the path
		//add starting location to the path
		stackX.add(x);
		ArrayList<Integer> stackY = new ArrayList<Integer>();//list will save the y-coords of the path
		//add starting location to the path
		stackY.add(y);
		y++;
		//saves how many iterations it takes to solve maze
		int a=1;
		
		while(true){			
			a++;	
			if(stackX.isEmpty()){
				//if the there are no moves in the path then there is no way to reach the goal
				System.out.println("can not clear Maze");
				drawMaze();
				break;
			}
			
			if(x==goalX && y == goalY){//if at goal
				System.out.println("4 directino Maze clear");
				for(int i=0;i<stackX.size();i++){
					mazeArray[stackX.get(i)][stackY.get(i)] = 3;//save the path taken to reach goal
				}
				mazeArray[goalX][goalY] = 3;//add goal to the path
				System.out.println("총 이동 횟수 = " + a + "회");
				drawMaze();//draws the new maze that will show the path
				break;//exits the while loop
			}
			//saves the state of the maze in each direction
			n=mazeArray[x-1][y];
			e=mazeArray[x][y+1];
			s=mazeArray[x+1][y];
			w=mazeArray[x][y-1];

			//if north is a passage way and has not already been explored
			if(n == 1 && (checkBefore(x-1,y,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move the current location north
				x=x-1;
				//go back to the beggining of the while loop
				continue;
			}
			//if east is a passage way and has not already been explored
			if(e == 1 && (checkBefore(x,y+1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move the current location east
				y=y+1;
				//go back to the beginning of the while loop
				continue;
			}
			//if south is a passage way and has not already been explored
			if(s == 1 && (checkBefore(x+1,y,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move the current location south
				x=x+1;
				//go back to the beginning of the while loop
				continue;
			}
			//if west is a passage way and has not already been explored
			if(w == 1 && (checkBefore(x,y-1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move the current location west
				y=y-1;
				//go back to the beginning of the wile loop
				continue;
			}
			//if no possible path is found mark the path as a dead end
			mazeArray[x][y] = 2;			
			//move back to the previous location
			x=stackX.get(stackX.size()-1);
			y=stackY.get(stackY.size()-1);

			//remove the previous location from the path
			stackX.remove(stackX.size()-1);
			stackY.remove(stackY.size()-1);
			
			

		}
		
	}
	//show how the maze is solved one step at a time
	public void playMazeStepbyStep() throws IOException{
		//Initialize the starting location in the maze
		int x=1;
		int y=0;
		
		int n,e,w,s;
		//list will save all of the x-coords of the path
		ArrayList<Integer> stackX = new ArrayList<Integer>();
		//add starting location to the path
		stackX.add(x);
		//list will hold all of the y-coords of the path
		ArrayList<Integer> stackY = new ArrayList<Integer>();
		//add the starting location to the path
		stackY.add(y);
		y++;
		int a=1;  
		
		while(true){
			System.out.println("play"+a);
			//draw maze with path drawn at current location
			drawMaze(x,y);  
			a++;			
			if(stackX.isEmpty()){
				//if there are no steps in the path the maze is not solvable
				System.out.println("can not clear Maze");
				drawMaze();
				break;
			}
			
			if(x==goalX && y == goalY){
				//if the current location is at the goal the maze is cleared
				System.out.println("Maze clear");
				for(int i=0;i<stackX.size();i++){
					//change all points along the path as being part of the final path
					mazeArray[stackX.get(i)][stackY.get(i)] = 3;
				}
				//add the final location to the path
				mazeArray[goalX][goalY] = 3;
				System.out.println("총 이동 횟수 = " + a + "회");
				//print out maze with path
				drawMaze();
				break;
			}
			//save the type of maze tile in each direction
			n=mazeArray[x-1][y];
			e=mazeArray[x][y+1];
			s=mazeArray[x+1][y];
			w=mazeArray[x][y-1];

			//if north is a passage way and has not already been explored
			if(n == 1 && (checkBefore(x-1,y,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move north
				x=x-1;
				System.out.println("go n");
				//go back to the beginning of the while loop
				continue;
			}
			//if east is a passage way and has not already been explored
			if(e == 1 && (checkBefore(x,y+1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				y=y+1;
				//move east
				System.out.println("go e");
				//go back to the beginning of the while loop
				continue;
			}
			//if south is a passage way and has not already been explored
			if(s == 1 && (checkBefore(x+1,y,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move south
				x=x+1;
				System.out.println("go s");
				//go back to the beginning of the while loop
				continue;
			}
			//if west is a passage way and has not already been explored
			if(w == 1 && (checkBefore(x,y-1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move west
				y=y-1;
				System.out.println("go w");
				//go back to the beginning of the while loop
				continue;
			}
			//if no direction is suitable go back to the prevouse location
			System.out.println("go back");
			//mark current location as a dead end
			mazeArray[x][y] = 2;
			//move to previous location
			x=stackX.get(stackX.size()-1);
			y=stackY.get(stackY.size()-1);

			//remove previous location from path
			stackX.remove(stackX.size()-1);
			stackY.remove(stackY.size()-1);
			
			

		}
		
	}

}
