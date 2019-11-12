import java.util.*;

public class testSearch {
	public static void main(String[] args){
        
		// input array size from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = input.nextInt();
        System.out.println();
        
        // create the array (the numbers do not really matter)
        int[] numbers = new int[size];
        for(int i=0; i<numbers.length; i++){
            // we want the numbers sorted for binary search
            // so why not just the numbers 0,1,...,size-1
            numbers[i]=i;
        }
        
        // store the time now
		long startTime = System.nanoTime();
        // linear search for size (which is not in the array)
        linearSearch(numbers,size);
        // display the time elapsed
		System.out.println("The time taken by Linear Search is " + (System.nanoTime() - startTime) + " nanoseconds.");
		
        // prepare to measure the time elapsed again
		startTime = System.nanoTime();
        // binary search for size
        binarySearch(numbers,size);
        // display the time elapsed
		System.out.println("The time taken by Binary Search is " + (System.nanoTime() - startTime) + " nanoseconds.");
	}

    public static boolean linearSearch(int[] a, int key) {
        for(int i=0; i<a.length; i++){
            if(a[i]==key) return true;
        }
        return false;
    }
        
    public static boolean binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length -1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid]>key) {
                high = mid - 1;
            } else if (a[mid]<key) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
