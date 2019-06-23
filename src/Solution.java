import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;

public class Solution {

    LocalDate expected;
    LocalDate returned;

    Consumer <LocalDate> print = System.out::println;
    Consumer <Integer> result = s -> System.out.println(s);

    public static void main(String[] args) {

        Solution sol = new Solution();

        sol.read();
        sol.checkFine();

        //sol.print.accept(sol.expected);
        //sol.print.accept(sol.returned);
    }

    public void read(){

        int exY;
        int exM;
        int exD;

        int reY;
        int reM;
        int reD;

        Scanner scan = new Scanner(System.in);

        reD=scan.nextInt();
        reM=scan.nextInt();
        reY=scan.nextInt();
        scan.nextLine();

        returned = LocalDate.of(reY, reM, reD);

        exD=scan.nextInt();
        exM=scan.nextInt();
        exY=scan.nextInt();

        expected = LocalDate.of(exY,exM,exD);
    }

    public void checkFine(){

        if (returned.isBefore(expected)){
            result.accept(0);
        }else if( returned.getYear()>expected.getYear()){
            result.accept(10000);
        }else if(returned.getMonthValue() > expected.getMonthValue()){
            result.accept((returned.getMonthValue()-expected.getMonthValue())*500);
        }else if(returned.getDayOfMonth() > expected.getDayOfMonth()){
            result.accept((returned.getDayOfMonth()-expected.getDayOfMonth())*15);
        }
    }
}