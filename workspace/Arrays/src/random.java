import java.util.Random;

public class random {
	public static void main(String args[])
    {
        // create instance of Random class
        Random rand = new Random();
 
        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(10);
        int rand_int2 = rand.nextInt(10);
 
        // Print random integers
        System.out.println("Random Integers: "+rand_int1);
        System.out.println("Random Integers: "+rand_int2);
        
        
    // Random numbers in range [ 5, 10]    
    	int Min = 5;
    	int Max = 10;
    	for(int i = 0; i < Min ; i++) {
    int num =	Min + (int)(Math.random() * ((Max -  Min) + 1));
    System.out.println(num);
    	}
    }

}
