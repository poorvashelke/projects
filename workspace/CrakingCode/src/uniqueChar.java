import java.util.Arrays;

/*
 * Q1.1 Implement an algorithm to determine if a string has all unique char's 
 * 		What if you can not use additional data structures?
 * Q1.2 Write a code to reverse a C style string(c-style means null terminated string '\0'
 * Q1.3 write code to remove the duplicate characters in a string without using any additional buffer
 * Q1.4 Write a method to decide if two strings are anagrams or not
 * 		anagram :a string is another string that contains same characters, only the order of characters can be different. 
 * 		For example, “abcd” and “dabc” are anagram of each other.
 * Q1.5 Write a method to replace all spaces in a string with ‘%20’
 * Q1.6 Matrix rotation 90 degree 
 * Q1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
 * Q1.8 Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings,
 * 		s1 and s2,write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * 		(i.e., “waterbottle” is a rotation of “erbottlewat”).
 * 
 */
public class uniqueChar {

/*Q1.1	 We can reduce our space usage a little bit by using a bit vector 
 * Wewillassume,inthebelow code, that the string is only lower case ‘a’ through ‘z’ 
 * This will allow us to use just a single int
*/
	public static boolean isUniqueChars(String str) { 
		int check = 0;

		for (int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'a';
//			used bit wise operators << is left bit shift ex. 1 << 3 = 100
			if ((check & (1 << val)) > 0) return false; //check if the check[val] == 0
			else check |= (1 << val);  //check = check |  (1 << val);
		}
		return true;
	}
//	Q1.2 reverse string	
    public static String reverse(String str){  
        if(str.length()<3) return str;  
        
        char[] tempArray = str.toCharArray();  
        int left=0;  
        int right=str.length()-2; // c-style ends with '\0'
        
        while(left<right){  
            char temp=tempArray[left];  
            tempArray[left] = tempArray[right];  
            tempArray[right] = temp;  
            left++;  
            right--;  
        }  
        str = new String(tempArray);  
        return str;  
     } 
    
//   Q1.3 remove duplicate string
    public static void removeDuplicates(char[] str) {
	    	 if (str == null || str.length<2) return;
	    	 int index = 1;
	    	 
	    	 for(int i = 1; i < str.length; i++) {
	    		 int j;
	    		 for(j = 0; j < index;j++) { // can't have j=i+1 so start i=1 & j=0
	    			 if(str[i] == str[j]) break;
	    		 }
	    		 if(j ==index) {
	    			 str[index] = str[i];
	    			 index++;
	    		 }
	    	 }
	    	 str[index] = 0;
    	}
		
//	Q1.4 anagram or not
    public static boolean areAnagram(char str1[], char str2[])
    {
    		if (str1.length != str2.length)
            return false;
  
        // Create 2 count arrays and initialize to 0
        int count1[] = new int [str1.length];
        Arrays.fill(count1, 0);
        int count2[] = new int [str2.length];
        Arrays.fill(count2, 0);
        int i;
  
        for (i = 0; i <str1.length && i < str2.length ; i++){
            count1[str1[i]]++;
            count2[str2[i]]++;
        }
  
        // Compare count arrays
        for (i = 0; i < str1.length; i++)
            if (count1[i] != count2[i])
                return false;
  
        return true;
    }
    
//    Q1.5 replace space to %20
	public static void ReplaceFun(char[] str) {
		int spaceCount = 0, newLength, i = 0;
		
		for (i = 0; i < str.length; i++) {
			if (str[i] ==' ') {
			spaceCount++;
			}
		}
	
		newLength = str.length + spaceCount * 2;
	
		for (i = str.length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
	}

//	Q1.7 matrix 0 then entire row& col will be 0
	public static void setZeros(int[][] matrix) {
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];
		
		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}
		
		// Set arr[i][j] to 0 if either row i or column j has a 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if ((row[i] == 1 || column[j] == 1)) {
					matrix[i][j] = 0;
				}
			}
		}
	}
    
//	Q1.8 is subString / string rotation
	public static boolean strRotation(String s1, String s2) {
		/* check that s1 and s2 are equal length and not empty */
		if (s1.length() == s2.length() && s1.length() > 0) {
		/* concatenate s1 and s1 within new buffer */
			String s1s1 = s1 + s1;
			if((s1s1).indexOf(s2) != -1)		//indexOf searches left to right for target
				return true;
		}
		return false;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Lets Go!";
		String str2 = "Lets eat";
		
		System.out.println(isUniqueChars(str));
		System.out.println(isUniqueChars(str2));
		
		System.out.println(reverse(str));
	}
}

/*For simplicity, assume char set is ASCII (if not, we need to increase the storage size The rest of the logic would be the same) NOTE: This is a great thing to point out to your interviewer!

public static boolean isUniqueChars2(String str) {
		// If length is greater than 256,
        // some characters must have been repeated
        
 	boolean[] char_set = new boolean[256];
 	
	for (int i = 0; i < str.length(); i++) {
		int val = str.charAt(i);
		if (char_set[val]) return false; 
		char_set[val] = true;
	}
	return true; 
}

*/