package pl.pawlas.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawlas.warehouse.model.Product;
import pl.pawlas.warehouse.model.ProductType;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByAuthor_Id(Long author_id);
    List<Product> findAllByCategory_Id(Long category_id);
    List<Product> findAllBySupplier_Id(Long supplier_id);
    List<Product> findAllByProductType(ProductType productType);

}
