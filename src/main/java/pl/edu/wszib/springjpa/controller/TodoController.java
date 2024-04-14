package pl.edu.wszib.springjpa.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.springjpa.model.ToDo;
import pl.edu.wszib.springjpa.model.ToDoStatus;
import pl.edu.wszib.springjpa.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService service;

    @GetMapping
    public List<ToDo> list(@RequestParam(required = false) ToDoStatus status) {
        return status == null ? service.list() : service.listByStatus(status);
    }

    @GetMapping("/page")
    public Page<ToDo> page(@PageableDefault @ParameterObject Pageable pageable) {
        return service.page(pageable);
    }

    @GetMapping("/{id}")
    public ToDo get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public ToDo create(@RequestBody ToDo toDo) {
        return service.create(toDo);
    }

    @PutMapping
    public ToDo update(@PathVariable Integer id, @RequestBody ToDo toDo) {
        toDo.setId(id);
        return service.update(toDo);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
