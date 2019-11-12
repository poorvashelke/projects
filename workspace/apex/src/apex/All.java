package apex;

public class All {

	private static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	private static boolean isOddNumber(String str) {
		int num = Integer.parseInt(str);
		if (num % 2 != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	private static boolean isEvenNumber(String str) {
		int num = Integer.parseInt(str);
		if (num % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	private static boolean isPrimeNumber(String str) {
		int num = Integer.parseInt(str);
		for(int i = 2; i < num;i++) {
			if (num % i == 0) 
				return false;
		}
		return true;
	}
	private static int count(String str) {
		int count = 0;
		for(int i = 0; i<str.length();i++) {
			if (str.charAt(i) == 'a') {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Is integer : "+isInteger("12"));
		System.out.println("Is odd number: "+isEvenNumber("3"));
		System.out.println("Is even number: "+isOddNumber("3"));
		System.out.println("Is prime number: "+isPrimeNumber("5"));
		
		int[] array = {1,2,3,6,21,11,34,5,77,32};
		System.out.println("print all array element with its index:");
		for(int i = 0; i< array.length; i++) {
			System.out.println(i+" "+ array[i]);
		}
		System.out.println("Number of times 'a' appeared: "+count("helloa"));
		
		StringBuffer buffer = new StringBuffer();
		for(char ch='a';ch <= 'z';ch++) {
			buffer.append(ch);
		}
		System.out.println("String buffer:" + buffer.toString());
		
		StringBuilder builder = new StringBuilder();
		for(char ch='a';ch <= 'z';ch++) {
			builder.append(ch);
		}
		System.out.println("String builder:" + builder.toString());

	}

}
