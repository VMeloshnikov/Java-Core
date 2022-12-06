package practice;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class Main {
    public static final String WRONG_COMMAND = "Неверная команда";


    public static void main(String[] args) {
        EmailList emailList = new EmailList();
        emailList.add("P123@mail.ru");
        emailList.add("A2BB4@host.ru");
        emailList.add("R125@upyr.com");


        while (true) {
            System.out.println("Введите команду. " +
                    "\nADD email - добавляет email в список; " +
                    "\nLIST - выводит список e-mail; ");

            Scanner in = new Scanner(System.in);
            String incomingString = in.nextLine().trim();
            String[] splitCommand = incomingString.split(" ");


            if (splitCommand[0].equalsIgnoreCase("LIST")) {

                //System.out.println(emailList.getSortedEmails());
                for (String el : emailList.getSortedEmails()) {
                    System.out.println(el);
                }



            } else if (splitCommand[0].equalsIgnoreCase("ADD")) {
                emailList.add(incomingString.substring(incomingString.indexOf(" ") + 1));

            } else {
                System.out.println(WRONG_COMMAND);
            }
        }
    }
}


