import java.util.Arrays;

public class Soting {
//	*******************		Bubble	inplace 	***********************
//	T(n) = n ^ 2
	private void bubblesort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] >  arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}
	
//	********************    insertion inplace   *************************** 
/*array before= 2,5,3,1
 *Insertion sort T = O ( n * n ) = O ( n^2 )
 */
	private void insertionSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for( int j = i-1; j >= 0; j--) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j+1);
			}
		}
	}
	
//	pass array positions and array as input
	public static void swap(int[] arr, int a, int b) {
		int temp;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
//************************************	Merge not inplace  ***********************************
//	Divide and conquer
	private int[] mergeSort(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}
		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		left = mergeSort(left);
		right = mergeSort(right);
		int[] result = merge(left, right);
		return result;
	}
//	left and right already sorted
	private int[] merge(int[] left, int[] right) {
		int total = left.length + right.length;
		int[] mergeArr = new int[total];
		int i = 0, j = 0, k = 0;
		while(i < left.length && j < right.length) {
			if(left[i] > right[j]) {
				mergeArr[k] = right[j]; 		
				j++;
				k++;
			}
			else {
				mergeArr[k] = left[i];
				i++;
				k++;
			}
		}
//after this while loop one of the arrays(leftPart or rightPart not both) might contain elements. So copy these elements.
		while(i < left.length) {
			mergeArr[k] = left[i];
			i++;
			k++;
		}
		while(j < right.length) {
			mergeArr[k] = right[j];
			j++;
			k++;
		}
		return mergeArr;
	}
	
//	*******************************************   Quick  inplace array *****************************************
//	Divide & Conquer
	private int[] quickSort(int[] arr) {
		return quickSort(arr, 0, arr.length - 1);
	}
	
	private int[] quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}
		return arr;
	}
//	partition returns index/position of pivot element in sorted array
	private int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int storeIndex = start;
		for(int i = start; i < end; i++) {
			if(pivot > arr[i]) {
				swap(arr, storeIndex, i);
				storeIndex++;
			}
		}
		swap(arr, storeIndex, end);
		return storeIndex;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Soting s = new Soting();
		int[] array = {2, 5, 3, 1, 6, 4};
		s.bubblesort(array);
		System.out.println("bubble Sort : "+Arrays.toString(array));
		int[] array1 = {2, 5, 3, 1, 6, 4};
		s.insertionSort(array1);
//		swap(array, 2, 3);
		System.out.println("Bubble Sort :"+Arrays.toString(array1));
//		*****************      merge    ******************************************************
		int[] array2 = {2, 5, 3, 1, 6};
		System.out.println("Merge Sort :"+Arrays.toString(s.mergeSort(array2)));
		int[] soresult = s.merge(new int[] {4, 5}, new int[] {2, 3, 4});
		System.out.println(Arrays.toString(soresult));
//		******************    Quick    ****************************************
		int[] quick = {10, 2, 5, 4, 6, 3, 0, -1};
		System.out.println("Quick Sort : "+Arrays.toString(s.quickSort(quick)));
	}
}
