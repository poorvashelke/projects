package apex;

public class Generator {

	public static void main(String[] args) {
		// 1000 numbers
		int i;
		for(i = 0; i< 1000; i++) {
			System.out.print(i+" ");
		}
		System.out.println("");
		System.out.println("Numbers which are multiple of 5 and less than 10000");
		for(i = 5; i<1000; i++) {
			if (i % 5 == 0) System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("odd numbers up to 1000");
		for(i = 1; i<1000; i++) {
			if (i % 2 != 0) System.out.print(i + " ");
		}
		
	}

}
