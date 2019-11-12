import java.util.Scanner;
import java.util.Random;

public class MaxSubArraySum {
	public static void main(String[] args)
    {
		Scanner input = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = input.nextInt();
        System.out.println();
        
        // create the array (the numbers do not really matter)
        int[] numbers = new int[size];
        Random rand = new Random();
        for(int i=0; i<numbers.length; i++){
            numbers[i]=rand.nextInt();
        }
        
        // store the time now
		long startTime = System.nanoTime();
		System.out.println("Max Sub Array Sum = "+max_sum(numbers));
        // display the time elapsed
		System.out.println("The time taken by it is " + (System.nanoTime() - startTime) + " nanoseconds.");
		
    }
    public static int max_sum(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            int sum = 0;
            for (int j = i; j < arr.length; j++)
            {
                sum += arr[j];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }
}
