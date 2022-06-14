package pl.pawlas.warehouse.service;

import org.springframework.stereotype.Service;
import pl.pawlas.warehouse.model.Product;
import pl.pawlas.warehouse.model.ProductType;
import pl.pawlas.warehouse.model.SupplierType;
import pl.pawlas.warehouse.repository.ProductRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(Long id){
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public void update(Product product){
        productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public List<Product> findByAuthor(Long authorId){
        return productRepository.findAllByAuthor_Id(authorId);
    }

    public List<Product> findByCategory(Long categoryId){
        return productRepository.findAllByCategory_Id(categoryId);
    }

    public List<Product> findBySupplier(Long supplierId){
        return productRepository.findAllBySupplier_Id(supplierId);
    }

    public List<Product> findByProductType(ProductType productType){
        return productRepository.findAllByProductType(productType);
    }

}
