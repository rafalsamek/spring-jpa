package pl.edu.wszib.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.springjpa.model.ToDo;
import pl.edu.wszib.springjpa.model.ToDoStatus;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, Integer>, JpaSpecificationExecutor<ToDo> {
    List<ToDo> findAllByStatus(ToDoStatus status);

    @Query("select t from ToDo t where t.status = 'NEW'")
    List<ToDo> getOnlyNew();
}
