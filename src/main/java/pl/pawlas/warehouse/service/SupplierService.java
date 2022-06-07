package pl.pawlas.warehouse.service;

import org.springframework.stereotype.Service;
import pl.pawlas.warehouse.model.Supplier;
import pl.pawlas.warehouse.repository.SupplierRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }

    public void update(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier getById(Long id) {
        return supplierRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
