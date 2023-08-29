import java.util.Scanner;
import java.lang.String;

import static java.lang.Float.parseFloat;


public class Logic {
    static Scanner scanner = new Scanner(System.in);

    static String input;
    static String temp;
    static float startTime;
    static float finishTime;
    static float payRate;
    static float hours;
    static String HH;
    static String MM;
    static boolean isFinish = false;


    public static void timeToDecimal(){

        // find the colon in the string and replace it with a decimal point
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ':') {
                input = input.substring(0, i) + '.' + input.substring(i + 1);
            }


        }
        // find the decimal point and split the string into two substrings
        for(int i = 0; i <input.length(); i++){
            if (input.charAt(i) == '.'){
                HH = input.substring(0,i);
                MM = input.substring(i+1);
            }
        }

        // print the two substrings for testing
        //System.out.println(HH);
        //System.out.println(MM);

        //  convert the substrings to floats
        if (isFinish){
            float HHfinish = parseFloat(HH);
            float MMfinsish = parseFloat(MM);

            MMfinsish= MMfinsish/60;
            finishTime = HHfinish + MMfinsish;
            //System.out.println(finishTime);

        } else {
            float HHStart = parseFloat(HH);
            float MMStart = parseFloat(MM);

            MMStart = MMStart/60;
            startTime = HHStart + MMStart;
            //System.out.println(startTime);

        }

    }
    public static float readStart(){
        System.out.println("What time did your shift start? HH:MM\t");
        // saves input as a string
        input = scanner.nextLine();
        timeToDecimal();
        //System.out.println(startTime);
        return startTime;
    }

    public static float readFinish(){
        System.out.println("What time did your shift finish? HH:MM\t");
        input = scanner.nextLine();
        isFinish = true;
        timeToDecimal();
        if (finishTime < startTime){
            System.out.println("Did you work through midnight? Y/N\t");
            input = scanner.nextLine();
            if (input.equals("Y")|| input.equals("y")){
                finishTime = finishTime + 24;
            }else{
                System.out.println("Please enter the correct times");
                readFinish();
            }
        }
        //System.out.println(finishTime);
        return finishTime;

    }

    public static float calculateHours(){
        hours = finishTime - startTime;
        return hours;

    }

    public static float payRate(){
        System.out.println("What is your pay rate? ");
        input = scanner.nextLine();
        payRate = parseFloat(input);

        return payRate;
    }

    public static float calculatePay(){
        float pay = payRate * calculateHours();
        return pay;
    }

    public static void displayPay(){
        System.out.println("You worked " + hours + " hours at a rate of " + payRate + "p/hr\t"+ "You earned: £" + calculatePay());
    }
}
