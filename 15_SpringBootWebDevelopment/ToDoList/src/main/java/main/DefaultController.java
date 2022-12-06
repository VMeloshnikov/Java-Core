package main;

import main.model.ToDo;
import main.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DefaultController {
    @Autowired
    TodoRepository todoRepository;

    @RequestMapping("/")
    public String index (Model model)
    {
        Iterable<ToDo> toDoIterable = todoRepository.findAll();
        ArrayList<ToDo> allTodo = new ArrayList<>();
        for(ToDo todo : toDoIterable) {
            allTodo.add(todo);
        }
        model.addAttribute("alltodo", allTodo);
        model.addAttribute("countTodo", allTodo.size());
        return "index";
    }
}

