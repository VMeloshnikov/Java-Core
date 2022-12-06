package practice;

import java.util.ArrayList;

public class TodoList {

     ArrayList<String> todoList = new ArrayList<>();



    public void add(String todo) {

        todoList.add(todo);
        System.out.println("Добавлено дело " + todo);


    }

    public void add(int index, String todo) {

        if (index < todoList.size() && index >= 0) {
            todoList.add(index, todo);
            System.out.println("Добавлено дело " + todo + "с номером" + todo);
        } else {
            todoList.add(todo);
            System.out.println("Добавлено дело " + todo +
                    " с номером " + todoList.size());

        }
    }

    public void edit(int index, String todo) {

        if (index < todoList.size() && index >= 0) {
            todoList.set(index, todo);

        } else {
            System.out.println("Дел с таким номером нет!");
        }
    }

    public void delete(int index) {

        if (index < todoList.size() && index >= 0) {
            todoList.remove(index);
        } else {
            System.out.println("Дел с таким номером нет!");
        }
    }


    public ArrayList<String> getTodos() {

        int i = 0;
        for (String list : todoList) {
            System.out.println(i++ + " - " + list);
        }
        return todoList;
    }

}