package maze;

import java.io.IOException;
import java.util.ArrayList;

public class MakeMaze {
	
	int sizeX;
	int sizeY;
	int goalX;
	int goalY;
	
	
	int mazeArray[][];
	
	public MakeMaze(int x,int y){
		this.sizeX = x+2;
		this.sizeY = y+2;
		mazeArray = new int[this.sizeX][this.sizeY];
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
	
	public void playMaze() throws IOException{
		int x=1;
		int y=0;
		
		int n,e,w,s;
		
		ArrayList<Integer> stackX = new ArrayList<Integer>();
		stackX.add(x);
		ArrayList<Integer> stackY = new ArrayList<Integer>();
		stackY.add(y);
		y++;
		int a=1;  //a = 시행 횟수
		
		while(true){
			System.out.println("play"+a);
			a++;
			drawMaze(x,y);  // 매번 시행 횟수와 현재 위치를 표시
			
			if(stackX.isEmpty()){
				System.out.println("can not clear Maze");
				drawMaze();
				break;
			}
			
			if(x==goalX && y == goalY){
				System.out.println("Maze clear");
				for(int i=0;i<stackX.size();i++){
					mazeArray[stackX.get(i)][stackY.get(i)] = 3;
				}
				mazeArray[goalX][goalY] = 3;
				drawMaze();
				break;
			}
			
			n=mazeArray[x-1][y];
			e=mazeArray[x][y+1];
			w=mazeArray[x][y-1];
			s=mazeArray[x+1][y];
			
			int beforeX = stackX.get(stackX.size()-1) ;
			int beforeY = stackY.get(stackY.size()-1) ;
			
			if(n == 1 && (x-1 != beforeX || y != beforeY)){
				stackX.add(x);
				stackY.add(y);
				x=x-1;
				System.out.println("go n");
				continue;
			}
			if(e == 1 && (x != beforeX || y+1 != beforeY)){
				stackX.add(x);
				stackY.add(y);
				y=y+1;
				System.out.println("go e");
				continue;
			}
			if(w == 1 && (x != beforeX || y-1 != beforeY)){
				stackX.add(x);
				stackY.add(y);
				y=y-1;
				System.out.println("go w");
				continue;
			}
			if(s == 1 && (x+1 != beforeX || y != beforeY)){
				stackX.add(x);
				stackY.add(y);
				x=x+1;
				System.out.println("go s");
				continue;
			}
			
			System.out.println("go back");
			mazeArray[x][y] = 2;

			x=stackX.get(stackX.size()-1);
			y=stackY.get(stackY.size()-1);


			stackX.remove(stackX.size()-1);
			stackY.remove(stackY.size()-1);
			
			

		}
		
	}

}
