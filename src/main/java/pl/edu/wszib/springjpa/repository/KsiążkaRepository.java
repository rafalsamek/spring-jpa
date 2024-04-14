package pl.edu.wszib.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.wszib.springjpa.model.Ksiazka;

import java.util.List;

@RepositoryRestResource
public interface KsiążkaRepository extends JpaRepository<Ksiazka, Integer> {
    List<Ksiazka> findAllByGatunek(String gatunek);
}
