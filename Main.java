import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Logic.readStart();
        Logic.readFinish();
        Logic.calculateHours();
        Logic.payRate();
        Logic.calculatePay();
        Logic.displayPay();
    }
}