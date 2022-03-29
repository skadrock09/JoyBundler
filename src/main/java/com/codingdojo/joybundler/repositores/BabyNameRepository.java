package com.codingdojo.joybundler.repositores;

import com.codingdojo.joybundler.model.BabyName;
import com.codingdojo.joybundler.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BabyNameRepository extends CrudRepository<BabyName, Long> {
    List<BabyName> findAll();
    List<BabyName> findAllByUsers(User user);
    List<BabyName> findByUsersNotContains(User user);
}
