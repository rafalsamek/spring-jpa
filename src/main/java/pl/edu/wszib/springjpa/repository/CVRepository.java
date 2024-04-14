package pl.edu.wszib.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.springjpa.model.CV;

@Repository
public interface CVRepository extends JpaRepository<CV, Integer>, JpaSpecificationExecutor<CV> {

}
