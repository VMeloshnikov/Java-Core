package practice;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        // ArrayList<String> list = new ArrayList<>();


        while (true) {


            Scanner in = new Scanner(System.in);
            String incomingString = in.nextLine();

            String[] splitCommand = incomingString.split(" ");
            if (splitCommand[0].equalsIgnoreCase("LIST")) {
                todoList.getTodos();

            } else if (splitCommand[0].equalsIgnoreCase("ADD")) {
                if (splitCommand[1].matches("\\d")) {

                    todoList.add(parseInt(splitCommand[1]), (incomingString.substring(incomingString.indexOf(" ")))
                            .substring(incomingString.indexOf(" ")) );
                } else {
                    todoList.add(incomingString.substring(incomingString.indexOf(" ") + 1));
                }

            } else if (splitCommand[0].equalsIgnoreCase("EDIT")) {
                if (splitCommand[1].matches("\\d")) {
                    todoList.edit(parseInt(splitCommand[1]), (incomingString.substring(incomingString.indexOf(" ")))
                            .substring(incomingString.indexOf(" ")));
                }

            } else if (splitCommand[0].equalsIgnoreCase("DELETE")) {
                if (splitCommand[1].matches("\\d")) {
                    todoList.delete(parseInt(splitCommand[1]));
                }
            }

        }

    }

}









