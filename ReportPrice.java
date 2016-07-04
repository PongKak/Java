package hw;

public class ReportPrice extends Car{

	int priceResult =0;

	public int getPrice(){
		for(Car car : carList){
			priceResult += car.getPrice();
		}
		
		
		System.out.println("Total = " + priceResult);
		return priceResult;
	}
}
