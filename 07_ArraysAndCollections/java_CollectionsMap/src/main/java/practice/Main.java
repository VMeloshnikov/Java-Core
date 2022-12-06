package practice;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("Введите имя или номер телефона " +
                    "\nLIST - выводит список абонентов и их номера ");

            String incomingString = read();

            if (incomingString.equalsIgnoreCase("list")) {
                phoneBook.getAllContacts();
            }
            if (phoneBook.isName(incomingString)) {
                if (phoneBook.getContactByName(incomingString).size() == 0) {
                    String phNum = "";
                    boolean chPhone = false;
                    while (!chPhone) {
                        System.out.println("Введите номер телефона:");
                        phNum = read();
                        chPhone = phoneBook.isPhone(phNum);
                    }
                    phoneBook.addContact(incomingString, phNum);
                    System.out.println("новый контакт добавлен");

                } else {
                    for (String el : phoneBook.getContactByName(incomingString)) {
                        System.out.println(el);
                    }
                }
            } else if (phoneBook.isPhone(incomingString)) {
                if (phoneBook.getContactByPhone(incomingString).isEmpty()) {
                    String nameNew = "";
                    boolean chName = false;
                    while (!chName) {
                        System.out.println("Введите имя абонента");
                        nameNew = read();
                        chName = phoneBook.isName(nameNew);
                    }
                    phoneBook.addContact(nameNew, incomingString);
                    System.out.println("новый контакт добавлен");
                } else {
                    System.out.println(phoneBook.getContactByPhone(incomingString));
                }
            } else {
                System.out.println("Введите валидный номер или имя");
            }
        }
    }

    public static String read() {
        Scanner in = new Scanner(System.in);
        String incomingString = in.nextLine().trim();
        in.close();
        return incomingString;
    }
}

