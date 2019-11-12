
public class Fibonacci {
	/*f(n) = f(n-1) + f(n-2)
	 * f(0) = 0
	 * f(1) = 1
	 * f(2) = f(1) + f(0)
	 * f(3) = f(2) + f(1)
	 * Series = 0, 1, 1, 2, 3, 5
	 */
	
	private void fiboSeries(int number) {
		int first = 0;
		int second = 1;
		if (number >= 1) {
			System.out.print(first+ ",");
		}
		if (number >= 2) {
			System.out.print(second+ ",");
		}
		
		for(int i = 2; i < number; i++) {
			int f2 = first + second;
			System.out.print(f2+ ",");
			first = second;
			second = f2;
		}
	}
	
	
	
	/* return nth term in fibo series */
	
	private int fiboTerm(int number) {
		int term1 = 0;
		int term2 = 1;
		int term3 = -1;
		if (number == 1) {
			return term1;
		}
		if (number == 2) {
			return term2;
		}
		
		for(int i = 3; i <= number; i++) {
			term3 = term1 + term2;
			term1 = term2;
			term2 = term3;
		}
		return term3;
	}
	
	//recursion fibo term
	//f(n) = f(n-1) + f(n-2)
//time Complex	T (n) =  O (n)
	private int  fiboTermRec(int number) {
		if (number == 1) {
			return 0;
		}
		if (number == 2) {
			return 1;
		}
		int result = fiboTermRec(number - 1) + fiboTermRec(number - 2);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci f = new Fibonacci();
		f.fiboSeries(6);
		System.out.println("Your term is " + f.fiboTerm(3));
		f.fiboTermRec(5);
	}

}
