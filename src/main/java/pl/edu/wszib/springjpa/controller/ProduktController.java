package pl.edu.wszib.springjpa.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.springjpa.model.Produkt;
import pl.edu.wszib.springjpa.model.ToDoStatus;
import pl.edu.wszib.springjpa.service.ProduktService;

import java.util.List;

@RestController
@RequestMapping("/produkt")
public class ProduktController {
    @Autowired
    private ProduktService service;
    @GetMapping
    public List<Produkt> list(@RequestParam(required = false) String nazwa) {
        return nazwa == null ? service.list() : service.listBy(nazwa);
    }

    @GetMapping("/page")
    public Page<Produkt> page(@PageableDefault @ParameterObject Pageable pageable) {
        return service.page(pageable);
    }

    @GetMapping("/{id}")
    public Produkt get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public Produkt create(@RequestBody Produkt produkt) {
        return service.create(produkt);
    }

    @PutMapping("/{id}")
    public Produkt update(@PathVariable Integer id, @RequestBody Produkt produkt) {
        produkt.setId(id);
        return service.update(produkt);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
