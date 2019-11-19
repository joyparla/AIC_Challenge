import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Solution1.myParser(input);
    }

    private static void myParser(String input){

        StringBuilder charac = new StringBuilder();

        Stack<Character> st = new Stack<Character>();


        for(int i=0; i< input.length(); i++){

            if(input.charAt(i) == '{' || input.charAt(i) == '(' || input.charAt(i) == '[') {
            	charac.append(input.charAt(i));
            	st.push(input.charAt(i));
            }
            if(input.charAt(i)== '}' || input.charAt(i) == ')' || input.charAt(i) == ']'){
            	charac.append(input.charAt(i));
            	if(balanced(st.peek(), input.charAt(i))) {
            		
            		st.pop();
            	}

            }
        }//end of for  
        
        
        if(st.size() == 0) {
        	
        	System.out.println("Y "+charac.toString());
        }else {
        	
        	System.out.println("N "+charac.toString());
        }
        
    }//end of parser
    
    
    private static boolean balanced(Character c1, Character c2) {
    	
    	if(c1 == '{' && c2 == '}') {
    		
    		return true;
    		
    	}else if(c1 == '[' && c2 == ']') {
    		return true;
    	}else if(c1 == '(' && c2 == ')') {
    		
    		return true;
    	}
    	
    	return false;
    } 
    
}