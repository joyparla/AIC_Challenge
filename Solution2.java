import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Solution2 {
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
 
        Object obj = new JSONParser().parse(sc.nextLine()); 

        JSONObject jo = (JSONObject) obj; 
        
        JSONArray report = (JSONArray)jo.get("reports");
        
        Solution2 solution2= new Solution2();
          

        solution2.printRequiredReport(report, solution2);
    }

     void printRequiredReport(JSONArray reports, Solution2 solution2){
    	
    	
    	
    	List<MySortClass> finalList = new ArrayList<MySortClass>();	
    	for(int i =0 ;i<reports.size(); i++) {
    		
    		
    		JSONObject repoGrad = ((JSONObject)reports.get(i));
    		
    		
    		JSONArray subjArray = (JSONArray)repoGrad.get("subject");
    		
    		for(int j = 0;j<subjArray.size(); j++) {
    			
    			
    			
    			JSONObject subjG = ((JSONObject)subjArray.get(j));
    			
    			if(!subjG.get("grade").equals("F")) {
            		
            		Solution2.MySortClass mySortClass = solution2.new MySortClass();         		
            		
            		mySortClass.enrollment = (String)repoGrad.get("enrollment");
            		
            		mySortClass.name = (String)repoGrad.get("name");
    				
    				mySortClass.code = (String)subjG.get("code");
    				
    				mySortClass.grade = (String)subjG.get("grade");
    				
    				finalList.add(mySortClass);
    						
    			}
    				
    		}		
    	} 	
    	
    	
    	
    	Collections.sort(finalList, solution2.new EnrollComp());
    	
    	finalList.stream().forEach(x -> System.out.println(x.code+ " "+ x.grade + " "+ x.enrollment+" " + x.name));
    }
    

     class ReportGrade{

        String enrollment;

        String name;

        Subject[] subject;
        

    }

     class Subject {

        String code;

        String grade;
       
    }
     
     class MySortClass{
    	 
    	 String code;
    	 
    	 String grade;
    	 
    	 String enrollment;
    	 
    	 String name;
     }
     

     
     
     class EnrollComp implements Comparator<MySortClass> 
     {
         public int compare(MySortClass o1, MySortClass o2) 
         {
        	 int result = o1.code.compareTo(o2.code);
        	 
             if(result == 0) {
            	 
            	 result = o1.grade.compareTo(o2.grade);
            	 
            	 if(result == 0) {
            		 
            		 return o1.enrollment.compareTo(o2.enrollment);
            		 
            	 }else
            		 return result;
             }else 
            	 return result;
            	 
         }
     }

}