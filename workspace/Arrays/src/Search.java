import java.util.Arrays;

public class Search {
//	T(n) = O(n)
	public int linearSearch(int[] arr, int key) {
		for(int i = 0; i < arr.length; i++) {
			if( arr[i] == key) {
				return i;
			}
		}
		return -1;
	}
//	for binary search input should be sorted   T (n) = logn
	public int binarySearch(int[] arr, int key, int low, int high) {
		if(low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if(arr[mid] == key) {
			return mid;
		}
		if ( key < arr[mid] ) {
			return binarySearch(arr, key, low, mid - 1);	
		}
		return binarySearch(arr, key, mid + 1, high);
	}
	public int binaryIter(int[] arr, int key) {
		int low = 0;
		int high  = arr.length - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[mid] < key) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return -1;
	}
	/*This not binary bec its not iterating		T(n) = O(n)
	 * public int binary(int[] arr, int key)
	{
		int mid = arr.length / 2;
		if (arr[mid] == key) {
			return mid;
		}
		if(key < arr[mid]) {
			for( int i = 0; i < mid; i++) {
				if(key == arr[i]) {
					return i;
				}
			}
		}
		else {
			for( int i = mid + 1; i < arr.length; i++) {
				if(key == arr[i]) {
					return i;
				}
			}
		}
		return -1;
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search s = new Search();
		int[] arr = {2, 4, 6, 3, 5};
		System.out.println(s.linearSearch(arr, 5));
		int[] arr2 = {1, 2, 3, 4, 5};
		System.out.println("Binary search");
		System.out.println(s.binarySearch(arr2, 5, 0, arr2.length - 1));
		System.out.println("Binary Iterative: "+s.binaryIter(arr2, -2));
		System.out.println("Binary Iterative: "+s.binaryIter(arr2, 1));
		System.out.println("Binary Iterative: "+s.binaryIter(arr2, 5));
		System.out.println("Binary Iterative: "+s.binaryIter(arr2, 8));
		
	}

}
