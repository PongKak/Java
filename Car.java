package hw;

import java.util.ArrayList;

public class Car{

	int price;
	String name;
	
	static ArrayList<Car> carList= new ArrayList<Car>(); 

	
	public Car(){};
	public Car(int price){

		this.price = price;
	}
	
	public void setPrice(int price){
		this.price = price;
	}
	public int getPrice(){
		return this.price;
	}
	
	public static void addCar(Car car,String name){
		
		carList.add(car);
	};
}
