package pl.edu.wszib.springjpa.specifications;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import pl.edu.wszib.springjpa.model.ToDo;

import java.util.ArrayList;
import java.util.List;

public class ExampleSpecifications {

    private ExampleSpecifications() {
    }

    public static Specification<ToDo> toDoSpecification() {
        return (root, query, builder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            predicateList.add(
                    builder.equal(root.get("something"),123)
            );

            return builder.and(predicateList.toArray(new Predicate[]{}));
        };
    }

}
