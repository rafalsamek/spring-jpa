package pl.edu.wszib.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.springjpa.model.ToDo;
import pl.edu.wszib.springjpa.model.ToDoStatus;
import pl.edu.wszib.springjpa.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService implements CrudService<ToDo, Integer> {
    @Autowired
    private TodoRepository repository;

    @Override
    public List<ToDo> list() {
        return repository.findAll();
    }

    @Override
    public ToDo get(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public ToDo create(ToDo toDo) {
        toDo.setId(null);
        toDo.setStatus(ToDoStatus.NEW);
        return repository.save(toDo);
    }

    @Override
    public ToDo update(ToDo toDo) {
        return repository.save(toDo);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
