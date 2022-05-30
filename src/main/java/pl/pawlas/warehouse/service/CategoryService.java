package pl.pawlas.warehouse.service;

import org.springframework.stereotype.Service;
import pl.pawlas.warehouse.model.Category;
import pl.pawlas.warehouse.repository.CategoryRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getById(Long id){
        return categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void save(Category category){
        categoryRepository.save(category);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public void update(Category category){
        categoryRepository.save(category);
    }
}
