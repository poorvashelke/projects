
public class MultiDimentional {
	public static void main(String args[])
	{
		// declaring and initializing 2D array
		int arr[][] = { {2,7,3},{3,6,3},{7,4,3} };

		// printing 2D array
		for (int i=0; i< arr.length ; i++)
		{
			for (int j=0; j < arr[i].length ; j++)
				System.out.print(arr[i][j] + " ");

			System.out.println();
		}
	}
}
