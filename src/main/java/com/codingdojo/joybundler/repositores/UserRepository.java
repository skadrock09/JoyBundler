package com.codingdojo.joybundler.repositores;

import com.codingdojo.joybundler.model.BabyName;
import com.codingdojo.joybundler.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //find by email
    User findByEmail(String email);
    List<User> findAll();
    List<User> findByBabyNames(BabyName babyName);
    List<User> findByBabyNamesNotContains(BabyName babyName);


}
