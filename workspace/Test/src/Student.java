import java.awt.RenderingHints.Key;
import java.util.*;

public class Student {
	private String firstname;
	private String lastname;
	private int rollNo;
	private float percentage;
	private List<String> friends;
	
	public Student(String fname, String lname, int num, float total) {
		firstname = fname;
		lastname = lname;
		rollNo = num;
		percentage = total;
		friends = new ArrayList<>();
	}
	
	 public String getFirstname() {
		 return firstname;
	 }
	 public void setFirstname(String fname) {
		 firstname = fname;
	 }

	 public String getLastname() {
		 return lastname;
	 }
	 public void setLastname(String lname) {
		 lastname = lname;
	 }
	 public int getRollno() {
		 return rollNo;
	 }
	 public void setRollno(int num) {
		 rollNo = num;
	 }
	 public float getPercentage() {
		 return percentage;
	 }
	 public void setPercentage(float total) {
		 percentage = total;
	 }
	 public List<String> getFriends(){
		 return friends;
	 }
	 public void addFriend(String newfriend) {
		 friends.add(newfriend);
	 }
	 @Override
	 public String toString() {
		 return "\nName: "+firstname +" "+ lastname +"\nRollNo: "+ rollNo +"\nPercentage: "+ percentage+
				 "\nFriends: "+ friends.toString(); 
		 
	 }
	public static void main(String[] args) {
		//create single student
		Student firstStu = new Student("disha", "shelke", 20, 85.5f);
		System.out.print(firstStu.getFirstname()+" ");
		System.out.print(firstStu.getLastname()+", ");
		System.out.print(firstStu.getRollno()+", ");
		System.out.println(firstStu.getPercentage());
		
		firstStu.setPercentage(90.3f);
		firstStu.addFriend("Jack");
		firstStu.addFriend("Alex");
		System.out.print(firstStu.toString());
		Student secondStu = new Student("Bella", "Whitner", 21, 85.7f);
		secondStu.addFriend("Max");
		secondStu.addFriend("Ben");
		secondStu.addFriend("Alex");
		
		//********List of Students*******************
		List<Student> allStudents = new ArrayList<>();
		allStudents.add(secondStu);
		allStudents.add(firstStu);
		allStudents.add(new Student("Stev", "Whitner", 12, 85.7f));
		//printing all students in the list of students
		System.out.println("****Printing all the Students in the List:*****");
		System.out.print(allStudents.toString());
		//print 2nd student from the list of students
		System.out.println("****Printing 2nd  Students in the List:*****");
		System.out.println(allStudents.get(1));
		
		//allStudents.remove(1);
		
		//********Stack of Students*******************
		Stack<Student> stackStd = new Stack<>();
		stackStd.push(firstStu);
		stackStd.push(secondStu);
		stackStd.push(new Student("Sasa", "Drop", 12, 85.7f));
		stackStd.push(new Student("Lisa", "Jack", 12, 85.7f));
		stackStd.push(new Student("Stev", "Whitner", 12, 85.7f));
		System.out.println("****Printing all the Students in the Stack:*****");
		System.out.print(stackStd.toString());
		
		stackStd.pop();
		stackStd.pop();
		System.out.println("\n********Top element in Stack is: "+stackStd.peek());
		
		//********Queue of Students*******************
		Queue<Student> queueStu = new LinkedList<>();
		queueStu.add(firstStu);
		queueStu.add(secondStu);
		queueStu.add(new Student("Lisa", "Jack", 12, 85.7f));
		queueStu.add(new Student("Sasa", "Drop", 12, 85.7f));
		queueStu.add(new Student("Stev", "Whitner", 12, 85.7f));
		System.out.println("****Printing all the Students in the Queue:*****");
		System.out.print(queueStu.toString());
		queueStu.remove(); //remove
		queueStu.poll();	//remove
		System.out.println("\n********First element in Queue is: "+queueStu.peek());
		
		//***********Map of Students*******************
		Student thirdStu = new Student("Win", "Poon", 22, 85.7f);
		// map for rollno. and list of friends
		Map<Integer,List<String>> mapStu = new HashMap<>();
		mapStu.put(firstStu.getRollno(),firstStu.getFriends());
		mapStu.put(secondStu.getRollno(),secondStu.getFriends());
		mapStu.put(thirdStu.getRollno(),thirdStu.getFriends());
		
		//printing all map elements
		System.out.println("****Printing all the Students Rollno and frinds using Map:*****");
		for(Map.Entry<Integer,List<String>> each: mapStu.entrySet()) {
			System.out.println(each.getKey()+" : "+each.getValue());
		}
		//prints all keys in map
		System.out.println("Printing all keys:");
		for(Integer each: mapStu.keySet()) {
			System.out.println(each);
		}
		//prints all values in map
		System.out.println("Printing all values:");
		for(List<String> each: mapStu.values()) {
			System.out.println(each);
		}
		//map for rollno. and percentage of student
		Map<Integer,Float> mapStu2 = new HashMap<>();
		mapStu2.put(firstStu.getRollno(),firstStu.getPercentage());
		mapStu2.put(secondStu.getRollno(),secondStu.getPercentage());
		mapStu2.put(thirdStu.getRollno(),thirdStu.getPercentage());
		
		//printing all map elements
		System.out.println("****Printing all the Students Rollno and Percentage using Map:*****");
		for(Map.Entry<Integer,Float> each: mapStu2.entrySet()) {
			System.out.println(each.getKey()+" : "+each.getValue());
		}
		
		//same key multiple values of map
		Map<Float,List<String>> mapStu3 = new HashMap<>();
		for(Student each: allStudents) {
			if(!mapStu3.containsKey(each.getPercentage())) {
				List<String> addValue = new ArrayList<>();
				addValue.add(each.getFirstname());
				mapStu3.put(each.getPercentage(),addValue);  // used to add data in Map
			}
			else{
				//if key is present then add value to that same key so 1st get that key then you will add the value.
				//we will use add bec. value is a list.
				mapStu3.get(each.getPercentage()).add(each.getFirstname());
			}
		}
		//printing all map elements
		System.out.println("****Printing studends percentage and names using Map:*****");
		for(Map.Entry<Float, List<String>> each:mapStu3.entrySet()) {
			System.out.println(each.getKey()+" : "+each.getValue());
		}
		
		//***********Set of Students friends(union)*******************
		Set<String> allFriends= new HashSet<>();
		for(Student each: allStudents) {
			for(String oneFriend : each.getFriends()) {
				allFriends.add(oneFriend);
			}
		}
		System.out.println("Printing all frinds without repeating any name");
		System.out.println(allFriends);
		
		//***********Set of Students friends(intersection= common)*******************
		//step1: add all the friends of first student to set
		System.out.println("Printing only common name from 2 data");
		Set<String> firstAllFriends = new HashSet<>();
		for(String firstFri : firstStu.getFriends()) {
			firstAllFriends.add(firstFri);
		}
		//step 2: iterate over friends of second student and check if present in set
		for(String secondFri: secondStu.getFriends()) {
			if(firstAllFriends.contains(secondFri)) {
				System.out.println("common friends : "+secondFri);
			}
		}
		
	}
}
