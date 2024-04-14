package pl.edu.wszib.springjpa.specifications;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import pl.edu.wszib.springjpa.model.ToDo;
import pl.edu.wszib.springjpa.model.ToDoStatus;

import java.util.ArrayList;
import java.util.List;

public class ToDoSpecifications {

    private ToDoSpecifications() {
    }

    public static Specification<ToDo> toDoSpecification(String zadanie, ToDoStatus status) {
        return (root, query, builder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if (status != null) {
                predicateList.add(
                        builder.equal(root.get("status"), status)
                );
            }

            if (zadanie != null) {
                predicateList.add(
                        builder.like(root.get("zadanie"), "%" + zadanie + "%")
                );
            }

            predicateList.add(
                    builder.equal(root.get("something"),123)
            );

            return builder.and(predicateList.toArray(new Predicate[]{}));
        };
    }

}
