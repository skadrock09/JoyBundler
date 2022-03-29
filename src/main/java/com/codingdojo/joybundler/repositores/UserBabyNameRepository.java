package com.codingdojo.joybundler.repositores;

import com.codingdojo.joybundler.model.BabyName;
import com.codingdojo.joybundler.model.User;
import com.codingdojo.joybundler.model.User_BabyName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBabyNameRepository extends CrudRepository<User_BabyName, Long> {
    User_BabyName findByUserAndBabyname(User user, BabyName babyName);

    List<User_BabyName> findByBabyname(BabyName babyName);

//create a query if a user likes a babyname update table users_babynames and update count of likes of baby name by 1




}
