package pl.edu.wszib.springjpa.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.springjpa.model.Produkt;

import java.util.List;

@RestController
@RequestMapping("/produkt")
public class ProduktController {
    @GetMapping
    public List<Produkt> list() {
        return null;
    }

    @GetMapping("/page")
    public List<Produkt> page(@PageableDefault @ParameterObject Pageable pageable) {
        return null;
    }

    @GetMapping("/{id}")
    public Produkt get(@PathVariable Integer id) {
        return null;
    }

    @PostMapping
    public Produkt create(@RequestBody Produkt produkt) {
        return null;
    }

    @PutMapping("/{id}")
    public Produkt update(@PathVariable Integer id, @RequestBody Produkt produkt) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

    }
}
