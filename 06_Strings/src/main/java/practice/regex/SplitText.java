package practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitText {

  public static void main(String[] args) {
    String text = "";
    System.out.println(splitTextIntoWords(text));
  }

  public static String splitTextIntoWords(String text) {
    text = text.replaceAll("\\p{Punct}|[0-9]", " ");
    String[] word = text.split("\\s+");
    StringBuilder result = new StringBuilder(word[0]);
    for (int i =1; i < word.length; i++) {
      if (word[i].equals("\n")) {
        return word[i];
      }
      result.append("\n").append(word[i]);
    }

    return result.toString();
  }

}