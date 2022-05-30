package pl.pawlas.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawlas.warehouse.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
