package com.sergioarboleda.app.repositories.crud;

import com.sergioarboleda.app.model.User;


import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserCrudRepository extends MongoRepository<User, Integer> {

    public Optional<User> findByName(String name);

    public List<User> findByNameOrEmail(String name, String email);

    public Optional<User> findByEmail(String email);
    
    public Optional<User> getUserById(Integer id);

    public Optional<User> findByEmailAndPassword(String email, String password);

    public List<User> findByIdOrEmailOrName(Integer id, String email, String name);

}
