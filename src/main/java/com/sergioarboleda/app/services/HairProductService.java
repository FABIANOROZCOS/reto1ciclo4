package com.sergioarboleda.app.services;

import com.sergioarboleda.app.model.HairProduct;
import com.sergioarboleda.app.repositories.HairProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FABIAN
 */
@Service
public class HairProductService {
    @Autowired
    private HairProductRepository repository;
    
    public List<HairProduct> getAll(){
        return repository.getAll();
    }
    
    public Optional<HairProduct> getHairProductByReference(String reference){
        return repository.getByReference(reference);
    
    }
    
    public HairProduct save(HairProduct product){
        if(product.getReference()==null){
            return null;
        }else{
            Optional<HairProduct> existsProduct = repository.getByReference(product.getReference());
            if(existsProduct.isEmpty()){
                return repository.save(product);
            }else {
                return null;
            }
        }
    }

    public HairProduct update(HairProduct product){
        Optional<HairProduct> existsProduct = repository.getByReference(product.getReference());
        if (existsProduct.isPresent()) {
            if (product.getReference()!=null) {
                existsProduct.get().setReference(product.getReference());
            }
            if (product.getBrand()!=null) {
                existsProduct.get().setBrand(product.getBrand());
            }
            if (product.getCategory()!=null) {
                existsProduct.get().setCategory(product.getCategory());
            }
            if (product.getName()!=null) {
                existsProduct.get().setName(product.getName());
            }
            if (product.getDescription()!=null) {
                existsProduct.get().setDescription(product.getDescription());
            }
            if (product.getPrice()!=null){
                existsProduct.get().setPrice(product.getPrice());
            }
            if (product.getQuantity()!=null){
                existsProduct.get().setQuantity(product.getQuantity());
            }
            if (product.getPhotography()!=null) {
                existsProduct.get().setPhotography(product.getPhotography());
            }
            return repository.update(existsProduct.get());
            
        }else{
            return product;
        }
    }
    
    public Boolean delete(String reference){
        Boolean result = getHairProductByReference(reference).map(product -> {
            repository.delete(product.getReference());
            return true;
        }).orElse(false);
        return result;
    }

}
   
