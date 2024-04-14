package pl.edu.wszib.springjpa.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.springjpa.model.ToDo;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @GetMapping
    public List<ToDo> list() {
        return null;
    }

    @GetMapping("/{id}")
    public ToDo get(@PathVariable Integer id) {
        return null;
    }

    @PostMapping
    public ToDo create(@RequestBody ToDo toDo) {
        return null;
    }

    @PutMapping
    public ToDo update(@PathVariable Integer id, @RequestBody ToDo toDo) {
        return null;
    }

    @DeleteMapping
    public void delte(@PathVariable Integer id) {

    }
}
