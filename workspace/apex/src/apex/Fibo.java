package apex;

public class Fibo {

	private int  fiboTerm(int number) {
		if (number == 1) {
			return 0;
		}
		if (number == 2) {
			return 1;
		}
		int result = fiboTerm(number - 1) + fiboTerm(number - 2);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibo f = new Fibo();
		System.out.println("Your term is " + f.fiboTerm(3));
		
	}
}
