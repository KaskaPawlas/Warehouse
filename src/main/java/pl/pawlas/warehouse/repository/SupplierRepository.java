package pl.pawlas.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawlas.warehouse.model.Supplier;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
