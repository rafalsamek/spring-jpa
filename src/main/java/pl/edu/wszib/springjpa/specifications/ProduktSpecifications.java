package pl.edu.wszib.springjpa.specifications;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import pl.edu.wszib.springjpa.model.Produkt;

import java.util.ArrayList;
import java.util.List;

public class ProduktSpecifications {

    private ProduktSpecifications() {
    }

    public static Specification<Produkt> produktSpecification(String nazwa) {
        return (root, query, builder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if (nazwa != null) {
                predicateList.add(
                        builder.like(root.get("nazwa"), "%" + nazwa + "%")
                );
            }

            return builder.and(predicateList.toArray(new Predicate[]{}));
        };
    }

}
