package com.sergioarboleda.app.repositories;

import com.sergioarboleda.app.model.HairProduct;
import com.sergioarboleda.app.repositories.crud.HairProductCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @author FABIAN
 */
@Repository
public class HairProductRepository {
    
    @Autowired
    private HairProductCrudRepository repository;
    
    public List<HairProduct> getAll() {
        return (List<HairProduct>) repository.findAll();
    }
    
    public Optional<HairProduct> getByReference(String reference){
        return repository.findById(reference);
    }
    
    public HairProduct save(HairProduct product) {
        return repository.save(product);
    }
    
    public HairProduct update(HairProduct product) {
        return repository.save(product);
    }

    public void delete(String reference){
        repository.deleteAll();
    }

}
