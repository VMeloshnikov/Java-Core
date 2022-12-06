package practice.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneCleanerRegex {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        scanner.close();
        break;
      }

      input = input.replaceAll("\\D", "");
      if (Pattern.matches("^7\\d{10}$", input)) {
        System.out.println(input);
      } else if (Pattern.matches("^8\\d{10}$", input)) {
        System.out.println("7" + input.substring(1));
      } else if (Pattern.matches("^\\d{10}$", input)) {
        System.out.println("7" + input);
      } else {
        System.out.println("Неверный формат номера");
      }
    }
  }
}

