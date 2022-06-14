package pl.pawlas.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawlas.warehouse.model.Category;
import pl.pawlas.warehouse.model.Product;
import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
