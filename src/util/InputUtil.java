package util;

import java.util.Scanner;

public class InputUtil {

    public static Scanner scanner = new Scanner(System.in);

    public static String input(String warning){
        System.out.print(warning+" : ");
        String data = scanner.nextLine();

        return data;
    }
}
