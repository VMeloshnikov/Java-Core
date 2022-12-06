package main;


import main.model.ToDo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StorageToDo {
    private static int toDoId = 1;
    private static HashMap<Integer, ToDo> allToDo = new HashMap<>();

    public static List<ToDo> getAllToDos() {
        ArrayList<ToDo> toDoList = new ArrayList<ToDo>();
        toDoList.addAll(allToDo.values());
        return toDoList;
    }

    public static int addToDo(ToDo toDo) {
        int id = toDoId++;
        toDo.setId(id);
        toDo.setName(toDo.getName());
        toDo.setData(toDo.getData());
        allToDo.put(id, toDo);
        return id;
    }

    public static ToDo getToDo(int toDoId) {
        if (allToDo.containsKey(toDoId)) {
            return allToDo.get(toDoId);
        }
        return null;
    }

    public static void deleteToDo() {
        allToDo.clear();
    }
}
