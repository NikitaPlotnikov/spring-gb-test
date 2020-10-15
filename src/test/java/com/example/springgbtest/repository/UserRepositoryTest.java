package com.example.springgbtest.repository;

import com.example.springgbtest.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads(){
        List<User> users = newUsers();
        List<User> savedUsers = userRepository.saveAll(users);
        User andrey = userRepository.getOne(savedUsers.get(2).getId());
        Assertions.assertEquals("Andrey", andrey.getName());
        List<User> allByAgeBetween = userRepository.findAllByAgeBetween(21, 29);
        Assertions.assertEquals(4,allByAgeBetween.size());
        System.out.println();

    }

    private List<User> newUsers(){
        ArrayList<User> userCollection = new ArrayList<>();
        userCollection.add(new User(null,"Ivan",20,"ivan@email.com"));
        userCollection.add(new User(null,"Oleg",22,"oleg@email.com"));
        userCollection.add(new User(null,"Andrey",24,"andrey@email.com"));
        userCollection.add(new User(null,"Misha",26,"misha@email.com"));
        userCollection.add(new User(null,"Katya",28,"katya@email.com"));
        userCollection.add(new User(null,"Max",30,"max@email.com"));
        userCollection.add(new User(null,"Sam",32,"sam@email.com"));
        userCollection.add(new User(null,"Tom",34,"tom@email.com"));
        userCollection.add(new User(null,"Pavel",36,"pavel@email.com"));
        userCollection.add(new User(null,"Nikita",38,"nikita@email.com"));
        return userCollection;
    }
}