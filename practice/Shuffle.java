package practice;

public class Shuffle {
	
	public static void main(String[] args){
		int [] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		
		int [] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}

	private static int[] shuffle(int[] arr) {
		
		for(int i=0;i<100;i++){
			int val1 = (int)(Math.random()*100%9);
			int val2 = (int)(Math.random()*100%9);
			int temp = arr[val1];
			arr[val1] = arr[val2];
			arr[val2] = temp;
		}
		return arr;
	}

}
