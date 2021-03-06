package pl.pawlas.warehouse.service;


import org.springframework.stereotype.Service;
import pl.pawlas.warehouse.model.Author;
import pl.pawlas.warehouse.repository.AuthorRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorService  {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getById(Long id){
        return authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public void save(Author author){
        authorRepository.save(author);
    }

    public void update(Author author){
        authorRepository.save(author);
    }

    public void delete(Long id){
        authorRepository.deleteById(id);
    }

    public List<Author> findAll(){
        return authorRepository.findAll();
    }
}
