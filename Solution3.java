import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution3 {
    public static void main(String args[] ) throws Exception {
        Scanner sc= new Scanner(System.in);

        String input = sc.nextLine();

        System.out.println(isValid(input));
    }


    private static String isValid(String input){

       String[]  strAr = input.split("@");

       String[] strAr2 = strAr[1].split("\\.");

       if(!isAlpha(strAr[0]))
          return "Invalid";

       for(int i=0;i<strAr2.length;i++){

           if(i == strAr2.length -1){

        	   if(!isOnlyAlpha(strAr2[i]) || !(strAr2[i].length() == 2 || strAr2[i].length() == 3))
        		   return "Invalid";
        	   
           }else{

               if(!isAlpha(strAr2[i]))
                  return "Invalid";
           }
       }
       
       return "Valid";

    }

    private static boolean isAlpha(String em){

         return em != null && em.matches("^[a-zA-Z0-9]*$");
    }
    
    private static boolean isOnlyAlpha(String em){

        return em != null && em.matches("^[a-zA-Z]*$");
   }
}
