package pl.edu.wszib.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.edu.wszib.springjpa.model.Produkt;
import pl.edu.wszib.springjpa.repository.ProduktRepository;
import pl.edu.wszib.springjpa.specifications.ProduktSpecifications;

import java.util.List;

@Service
public class ProduktService implements CrudService<Produkt, Integer> {
    @Autowired
    private ProduktRepository repository;

    @Override
    public List<Produkt> list() {
        return repository.findAll();
    }

    public List<Produkt> listBy(String nazwa) {
        return repository.findAll(
                ProduktSpecifications.produktSpecification(nazwa)
        );
    }

    public Page<Produkt> page(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Produkt get(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Produkt create(Produkt produkt) {
        produkt.setId(null);
        return repository.save(produkt);
    }

    @Override
    public Produkt update(Produkt produkt) {
        return repository.save(produkt);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
