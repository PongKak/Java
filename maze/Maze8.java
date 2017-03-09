package maze;

import java.io.IOException;
import java.util.ArrayList;

public class Maze8 extends Maze {
	
	int sizeX;
	int sizeY;
	int goalX;
	int goalY;
	
	
	int mazeArray[][];
	//creates the maze of size x,y
	public Maze8(int x,int y){
		//adds 2 to account for the border around the maze
		this.sizeX = x+2;
		this.sizeY = y+2;
		mazeArray = new int[this.sizeX][this.sizeY];
		//adds a border around the maze
		this.mazeFrame();
	}
	//sets the location of the goal
	public void setGoal(int goalX,int goalY){
		//add one to account for the border
		this.goalX = goalX+1;
		this.goalY = goalY+1;
	}
	//adds a border around the maze
	public void mazeFrame(){
		for(int i=0;i<sizeX;i++){
			for(int j=0;j<sizeY;j++){
				if(sizeX==0 || sizeY==0 || sizeX==11 || sizeY==11){
					//if the location is along one of the edges add a wall
					mazeArray[i][j] = 0;
				}
			}
		}
		mazeArray[1][0] = 1;
	}
	//prints the maze
	public void drawMaze(){
		for(int i=1;i<sizeX-1;i++){
			for(int j=1;j<sizeY-1;j++){
				if(mazeArray[i][j] ==1)
					System.out.print(" □ ");//prints out passage ways
				else if(mazeArray[i][j] == 0)
					System.out.print(" ■ ");//prints out walls
				else if(mazeArray[i][j] == 3)
					System.out.print(" * ");//prints out the path
				else
					System.out.print(" ▒ ");//prints out dead ends
			}
			System.out.println();
		}
		System.out.println();

	}
	//prints the maze with a * at location x,y
	public void drawMaze(int x, int y){
		for(int i=1;i<sizeX-1;i++){
			for(int j=1;j<sizeY-1;j++){
				if(i==x&&j==y)
					System.out.print(" * ");//prints out a * at location x,y
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

	//specifies what is at each location in the maze
	public void setMaze(int x,int y,int value){
		//add 1 to account for border
		this.mazeArray[x+1][y+1]=value;
	}
	//checks to see if location x,y is part of the path
	public boolean checkBefore(int x,int y,ArrayList<Integer> stackX,ArrayList<Integer> stackY){
		for(int i=0;i<stackX.size();i++){
			if(x==stackX.get(i) && y==stackY.get(i))
				//if x,y is in the path return false
				return false;
		}
		//if it is not fount print true
		return true;
	}
	
	
	public void playMaze() throws IOException{
		int x=1;
		int y=0;
		
		int n,e,w,s;
		int ne,nw,se,sw;
		//list will x-coords of the current path
		ArrayList<Integer> stackX = new ArrayList<Integer>();
		//add starting location to path
		stackX.add(x);
		//list will store y-coords of current path
		ArrayList<Integer> stackY = new ArrayList<Integer>();
		//add starting location to path
		stackY.add(y);
		y++;
		//a will count how many iterations it takes to find solution
		int a=1;  //a = 시행 횟수
		
		while(true){
			a++;
			if(stackX.isEmpty()){
				//if there are no moves in the path then the maze is not solvable
				System.out.println("can not clear Maze");		
				drawMaze();
				//exit the while loop
				break;
			}
			//if the current location is at the goal
			if(x==goalX && y == goalY){
				System.out.println("8 direction Maze clear");
				for(int i=0;i<stackX.size();i++){
					//change all the locations in the current path to be part of the path
					mazeArray[stackX.get(i)][stackY.get(i)] = 3;
				}
				//change the goal location to part of the path
				mazeArray[goalX][goalY] = 3;
				System.out.println("총 이동 횟수 = " + a + "회");
				//draw the solved maze
				drawMaze();
				//exit the while loop
				break;
			}
			//save the state if the maze in every direction
			n=mazeArray[x-1][y];
			ne=mazeArray[x-1][y+1];
			e=mazeArray[x][y+1];
			se=mazeArray[x+1][y+1];
			s=mazeArray[x+1][y];
			sw=mazeArray[x+1][y-1];
			w=mazeArray[x][y-1];
			nw=mazeArray[x-1][y-1];

			//if north is a passage way and has not already been explored
			if(n == 1 && (checkBefore(x-1,y,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move north
				x=x-1;
				//go back to the beginning of the while loop
				continue;
			}
			//if north east is a passage way and has not already been explored
			if(ne == 1 && (checkBefore(x-1,y+1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move north east
				x=x-1;
				y=y+1;
				//go back to the beginning of the while loop
				continue;
			}
			//if east is a passage way and has not already been explored
			if(e == 1 && (checkBefore(x,y+1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move east
				y=y+1;
				//go back to the beginning of the while loop
				continue;
			}
			//if south east is a passage way and has not already been explored
			if(se == 1 && (checkBefore(x+1,y+1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move south east
				x=x+1;
				y=y+1;
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
				//go back to the beginning of the while loop
				continue;
			}
			//if south west is a passage way and has not already been explored
			if(sw == 1 && (checkBefore(x+1,y-1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move south west
				x=x+1;
				y=y-1;
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
				//go back to the beginning of the while loop
				continue;
			}
			//if north west is a passage way and has not already been explored
			if(nw == 1 && (checkBefore(x-1,y-1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move north west
				x=x-1;
				y=y-1;
				//go back to the beginning of the while loop
				continue;
			}
			//if no moves where suitable mark the current location as a dead end
			mazeArray[x][y] = 2;
			//move to the previous location
			x=stackX.get(stackX.size()-1);
			y=stackY.get(stackY.size()-1);

			//remove the previous location from the path
			stackX.remove(stackX.size()-1);
			stackY.remove(stackY.size()-1);
			
			

		}
		
	}
	
	public void playMazeStepbyStep() throws IOException{
		int x=1;
		int y=0;
		
		int n,e,w,s;
		int ne,nw,se,sw;
		//list will store the x-coords of the path
		ArrayList<Integer> stackX = new ArrayList<Integer>();
		//add the starting location to the path
		stackX.add(x);
		//list will store the y-coords of the path
		ArrayList<Integer> stackY = new ArrayList<Integer>();
		//add the starting location to the path
		stackY.add(y);
		y++;
		//a will hold how many iterations it takes to solve the maze
		int a=1;  //a = 시행 횟수
		
		while(true){
			//print out the iterations
			System.out.println("play"+a);
			//print out the maze with a * at the current location
			drawMaze(x,y);  // 매번 시행 횟수와 현재 위치를 표시
			a++;
			if(stackX.isEmpty()){
				//if the path is empty then the maze cannot be solved
				System.out.println("can not clear Maze");
				drawMaze();
				//exit the while loop
				break;
			}
			//if the current location is at the goal
			if(x==goalX && y == goalY){
				System.out.println("Maze clear");
				for(int i=0;i<stackX.size();i++){
					//save all the location in the current path
					mazeArray[stackX.get(i)][stackY.get(i)] = 3;
				}
				//add the goal location to the path
				mazeArray[goalX][goalY] = 3;
				System.out.println("총 이동 횟수 = " + a + "회");
				//print out the solved maze
				drawMaze();
				//exit the while loop
				break;
			}
			
			n=mazeArray[x-1][y];
			ne=mazeArray[x-1][y+1];
			e=mazeArray[x][y+1];
			se=mazeArray[x+1][y+1];
			s=mazeArray[x+1][y];
			sw=mazeArray[x+1][y-1];
			w=mazeArray[x][y-1];
			nw=mazeArray[x-1][y-1];

	
			//if north is a passage way and has not already been explored
			if(n == 1 && (checkBefore(x-1,y,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move north
				x=x-1;
				System.out.println("go n"); // 매번 출력하는 경우 이동 방향을 출력
				//go back to the beginning of the while loop
				continue;
			}
			//if north east is a passage way and has not already been explored
			if(ne == 1 && (checkBefore(x-1,y+1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move north east
				x=x-1;
				y=y+1;
				System.out.println("go ne");
				//move north east
				continue;
			}
			//if east is a passage way and has not already been explored
			if(e == 1 && (checkBefore(x,y+1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move east
				y=y+1;
				System.out.println("go e");
				//go back to the beginning of the while loop
				continue;
			}
			//if south east is a passage way and has not already been explored
			if(se == 1 && (checkBefore(x+1,y+1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move south east
				x=x+1;
				y=y+1;
				System.out.println("go se");
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
			//if south west is a passage way and has not already been explored
			if(sw == 1 && (checkBefore(x+1,y-1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move south west
				x=x+1;
				y=y-1;
				System.out.println("go sw");
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
			//if north west is a passage way and has not already been explored
			if(nw == 1 && (checkBefore(x-1,y-1,stackX,stackY))){
				//add the current location to the path
				stackX.add(x);
				stackY.add(y);
				//move north west
				x=x-1;
				y=y-1;
				System.out.println("go nw");
				//go back to the beginning of the while loop
				continue;
			}
			
			//if there is no suitable move the go back
			System.out.println("go back");
			//mark the current location as a dead end
			mazeArray[x][y] = 2;
			//move to the previous location
			x=stackX.get(stackX.size()-1);
			y=stackY.get(stackY.size()-1);

			//remove the previous location from the path
			stackX.remove(stackX.size()-1);
			stackY.remove(stackY.size()-1);
			
			

		}
		
	}


}
