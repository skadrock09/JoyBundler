package com.codingdojo.joybundler.service;

import com.codingdojo.joybundler.model.BabyName;
import com.codingdojo.joybundler.model.User;
import com.codingdojo.joybundler.model.User_BabyName;
import com.codingdojo.joybundler.repositores.BabyNameRepository;
import com.codingdojo.joybundler.repositores.UserBabyNameRepository;
import com.codingdojo.joybundler.repositores.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserBabyNameService {
    private final BabyNameRepository babyNameRepository;
    private final UserBabyNameRepository userBabyNameRepository;
    private final UserRepository userRepository;

    public UserBabyNameService(BabyNameRepository babyNameRepository, UserBabyNameRepository userBabyNameRepository, UserRepository userRepository) {
        this.babyNameRepository = babyNameRepository;
        this.userBabyNameRepository = userBabyNameRepository;
        this.userRepository = userRepository;
    }

    public void addBabyName(BabyName babyName) {
        babyNameRepository.save(babyName);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void addBabyNameToUser(User_BabyName user_babyName) {
        userBabyNameRepository.save(user_babyName);
    }

    public void addUserToBabyName(User_BabyName user_babyName) {
        userBabyNameRepository.save(user_babyName);
    }

    public BabyName singleBabyName(Long id) {
        Optional<BabyName> babyName = babyNameRepository.findById(id);
        if(babyName.isPresent()) {
            return babyName.get();
        } else {
            return null;
        }
    }

    public User singleUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    public Iterable<User> avaiableUserForBabyName(BabyName babyName) {
        return userRepository.findByBabyNamesNotContains(babyName);
    }

    public Iterable<BabyName> availableBabyNamesForUser(User user) {
        return babyNameRepository.findByUsersNotContains(user);
    }

    public Iterable<User> allUsers() {
        return userRepository.findAll();
    }

    public Iterable<BabyName> allBabyNames() {
        return babyNameRepository.findAll();
    }

    public void createUserBabyName(User_BabyName user_babyName) {
        userBabyNameRepository.save(user_babyName);
    }

    public void LikeUsertoBabyName(User_BabyName user_babyName) {
        BabyName babyName = user_babyName.getBabyname();
        babyName.setCountLikes(babyName.getCountLikes() + 1);
        babyNameRepository.save(babyName);

    }

    public User findUserBabyName(BabyName babyName) {
        List<User_BabyName> users_babyNames = userBabyNameRepository.findByBabyname(babyName);
        for (User_BabyName user_babyName : users_babyNames) {
             if(user_babyName.getTypeofChoice() == null) {
                 return user_babyName.getUser();
             }else {
                 return null;
             }
        }
        return null;
    }


    public void updateBabyName(BabyName babyName) {
        BabyName babyName1 = singleBabyName(babyName.getId());
        babyName1.setName(babyName.getName());
        babyName1.setDescription(babyName.getDescription());
        babyName1.setGender(babyName.getGender());
        babyName1.setOrigin(babyName.getOrigin());
        babyName1.setCountLikes(babyName.getCountLikes());
        babyNameRepository.save(babyName1);

    }

    public void deleteBabyName(Long id) {
        babyNameRepository.deleteById(id);
    }
}
