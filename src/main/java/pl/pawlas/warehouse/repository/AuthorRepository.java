package pl.pawlas.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawlas.warehouse.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
