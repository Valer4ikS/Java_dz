package seminar2;

import java.util.Scanner;

public class Where {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String head = "select * from students where ";
        StringBuilder sb = new StringBuilder(head);
        StringBuilder words = new StringBuilder("name: , country: , city: , age: ");

        System.out.println(getSB(sb, words));

    }

    public static void prompt(StringBuilder sb, StringBuilder wrds) {
        sb.append(wrds.toString());
        System.out.println(sb);
    }

    public static void Request(int count) {
        switch (count) {
            case 0:
                System.out.println("Enter a name: ");
                break;
            case 1:
                System.out.println("Enter a country: ");
                break;
            case 2:
                System.out.println("Enter a city: ");
                break;
            case 3:
                System.out.println("Enter a age: ");
                break;
        }
    }

    public static StringBuilder getSB(StringBuilder sb, StringBuilder words) {
        // + result
        for (int i = 0; i < 4; i++) {
            Request(i);
            String word = scanner.nextLine();
            sb.append(word + " ");
        }
        return sb;
    }
}
