package main;


import main.model.ToDo;
import main.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController {

    @Autowired
    private TodoRepository todoRepository;

    // Возвращает все дела
    @GetMapping("/alltodo")
    public List<ToDo> list() {
        Iterable<ToDo> toDoIterable = todoRepository.findAll();
        ArrayList<ToDo> allTodo = new ArrayList<>();
        for(ToDo toDo : toDoIterable) {
            allTodo.add(toDo);
        }
        return allTodo;
    }

    // Добавляет дело и возвращает id
    @PostMapping("/alltodo")
    public int add(@RequestBody ToDo toDo) {
        ToDo newTodo = todoRepository.save(toDo);
        return newTodo.getId();
    }

    // Выводит информацию об одном деле
    @GetMapping("/alltodo/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Optional <ToDo> toDoOptional = todoRepository.findById(id);
        if(!toDoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(toDoOptional.get(), HttpStatus.OK);
    }

    // Удаляет все дела
    @DeleteMapping("/alltodo/delete/all")
    public ResponseEntity delete () {
        todoRepository.deleteAll();
        if(todoRepository == null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @DeleteMapping("/alltodo/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Optional <ToDo> optionalToDo = todoRepository.findById(id);
        if (!optionalToDo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        todoRepository.deleteById(id);
        return new ResponseEntity(optionalToDo.get(), HttpStatus.OK);
    }

}


