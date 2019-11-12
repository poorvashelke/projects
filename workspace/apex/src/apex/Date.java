package apex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	    
	    try{
		    LocalDate date = LocalDate.now();
		    DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		    String newDate1 = date.format(format1);  
		    System.out.println("ddMMYY format: "+newDate1);
		    
		    DateTimeFormatter format2 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		    String newDate2 = date.format(format2);  
		    System.out.println("MMddYY format: "+newDate2);
	     }
	     catch(ArithmeticException e){
	        System.out.println("ArithmeticException");
	     }
	     catch(ArrayIndexOutOfBoundsException e){
	        System.out.println("ArrayIndexOutOfBoundsException");
	     }
	     catch(Exception e){
	        System.out.println("Warning: Some Other exception");
	     }
	 
	}

}
