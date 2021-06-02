package by.it.naryshkin.jd01_10.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("end")) {
            Var result = parser.calc(line);
            printer.print(result);
        }


    }
}