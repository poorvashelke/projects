
public class MyStack {
	private int[] data;
	private int index;	//location where stack points
//	constructor should be public
	public MyStack(){	//empty constructor
		 data = new int[10];
		 index = 0;
	}
	public MyStack(int size) {	//parameterized constructor
		data = new int[size];
		index = 0;
	}
	
	
	public void push(int num) throws Exception{
		if(isFull()) {
			throw new Exception("Stack is full");
//			throw new ArrayIndexOutOfBoundsException("Stack Overflow : " + index);
		}
		data[index++] = num;
		//index++;
	}
	public void pop() {
		index--;
	}
	public int peek() {
		return data[index - 1];
	}
	public boolean isEmpty() {
		return index == 0;
	}
	public boolean isFull() {
		return data.length == index;
	}
	
	public static void main(String[] args) { //throws Exception {
		// TODO Auto-generated method stub
		try{
			MyStack s = new MyStack();
		
			System.out.println(s.isEmpty());
			s.push(3);
			s.push(5);
			System.out.println(s.peek());
			s.pop();
			System.out.println(s.peek());
			s.push(2);
			System.out.println(s.isEmpty());
			s.push(3);
			s.push(5);
			s.push(3);
			s.push(5);
			s.push(3);
			s.push(5);
			s.push(3);
			s.push(5);

			s.push(5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally {
			
		}
	}

}
