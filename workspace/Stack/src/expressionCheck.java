/*Check for balanced parentheses in an expression
 * the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. For example, the program should print true 
 * for exp = “[()]{}{[()()]()}” and false for exp = “[(])”
 */
public class expressionCheck {
	
	int top=-1;
    char items[] = new char[100];

    void push(char x) 
    {
        if (top == 99) 
        {
            System.out.println("Stack full");
        } 
        else
        {
            items[++top] = x;
        }
    }

    char pop() 
    {
        if (top == -1) 
        {
            System.out.println("Underflow error");
            return '\0';
        } 
        else
        {
            char element = items[top];
            top--;
            return element;		//returns deleted element
        }
    }
    boolean isEmpty() 
    {
        return (top == -1);
    }

    static boolean isBalanced(char[] data) {
    	expressionCheck exp = new expressionCheck();
    		for(int i = 0; i < data.length; i++) {
    			if (data[i] == '{' || data[i] == '(' || data[i] == '[')
    	            exp.push(data[i]);
    			if(data[i] == '}' || data[i] == ')' || data[i] == ']') {
    				if(exp.isEmpty())
    					return false;
    				/* Pop the top element from stack, if 
                    it is not a pair parenthesis of character 
                    then there is a mismatch. This happens for 
                    expressions like {(}) */
                 else if ( !isMatchingPair(exp.pop(), data[i]) )
                       return false;
    			}
    		}
    		if(exp.isEmpty())
    			return true;		//balanced
    		else
			return false;	// unbalanced
    		
    }
    
    static boolean isMatchingPair(char character1, char character2)
    {
       if (character1 == '(' && character2 == ')')
         return true;
       else if (character1 == '{' && character2 == '}')
         return true;
       else if (character1 == '[' && character2 == ']')
         return true;
       else
         return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char exp[] = {'{','(',')','}','[',']'};
        System.out.print(isBalanced(exp));
        /*
         *  if (areParenthesisBalanced(exp))
         *  System.out.println("Balanced ");
         *  else
         *  System.out.println("Not Balanced "); 
         */
	}
}
