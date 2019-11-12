package apex;
import java.util.Scanner;

public class BasicCalculator {
	private static int add(int num1, int num2) {
		return num1 + num2;
	}
	
	private static int sub(int num1, int num2) {
		return num1 - num2;
	}
	
	private static int multi(int num1, int num2) {
		return num1 * num2;
	}

	private static int divide(int num1, int num2) {
		return num1 / num2;
	}
	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		System.out.println("Enter 1st number");
		int num1 = input.nextInt();
		System.out.println("Enter 2nd number");
		int num2 = input.nextInt();
		System.out.println("Enter operator");
		String operator = input.nextLine();
		int num;
		switch(operator) {
		case "+": 
			num = add(num1, num2);
			System.out.println("addition of two numbers is: "+num);
			break;
		case "-":
			num =  sub(num1, num2);
			System.out.println("subtraction of two numbers is: "+num);
			break;
		case "*":
			num = sub(num1, num2);
			System.out.println("subtraction of two numbers is: "+num);
			break;
		case "/":
			num = divide(num1, num2);
			System.out.println("division of two numbers is: "+num);
			break;
		default:
			System.out.println("Invalid input");
		}
	}

}
