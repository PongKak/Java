package hw;


public class Company {
	
	
	private static Company company = new Company();
	
	private Company(){
		System.out.println("Company »ý¼º");
	}
	public static Company getCompany(){
		if(company == null)
			company = new Company();
		
		return company;
	}
	
	
	public void addCar(Car car,String name){
		Car.addCar(car,name);
	}

}