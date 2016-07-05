package practice;

public class Numcheck {
	

	  public static boolean isNumber(String s) {
		    try {
		        Double.parseDouble(s);
		        return true;
		    } catch (NumberFormatException e) {
		        return false;
		    }
		  }
	
	public static void main(String[] args){
		String str = "123";
		System.out.println(str+"는 숫자입니까?" + isNumber(str));
		
		str = "1234o";
		System.out.println(str+"는 숫자입니까?" + isNumber(str));
		
	}

}
