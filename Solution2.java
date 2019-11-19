import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

    final String     str    = JSType.toString(input);
    final Global     global = Context.getGlobal();
    final boolean    dualFields = ((ScriptObject) global).useDualFields();

        JSONParser jp = new JSONParser(str, global, dualFields);

        ReportGrade[] reportArray = (ReportGrade)jp.parse();

        printRequiredReport(reportArray);
    }

    static void printRequiredReport(ReportGrade[] reportArray){


         List<ReportGrade> myList = Arrays.asList(reportArray);


         myList = myList.stream().filter(report -> Arrasys.asList(report.getSubject())
         .stream().filter(subject -> !subject.getGrade().equals("F")).collect                                              (Collectors.toList())).collect(Collectors.toList());

         Comparator<ReportGrade> compareByName = Comparator.comparing(ReportGrade::getSubject)
         .thenComparing(ReportGrade::getEnrollment);

         myList = myList.stream().sorted(compareByName).collect(Collectors.toList());




    }

    static class ReportGrade{

        String enrollment;

        String name;

        Subject[] subject;

        //setters and getters

         

    }

    static class Subject {

        String code;

        String grade;
        //setters and getters

    }






}