package com.empresa.projetoapi.service;

import com.empresa.projetoapi.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();

        User user1 = new User(1, "Maria", 23, "maria@gmail.com");
        User user2 = new User(2, "João", 22, "joao@gmail.com");
        User user3 = new User(3, "José", 25, "jose@gmail.com");
        User user4 = new User(4, "Pedro", 27, "pedro@gmail.com");
        User user5 = new User(5, "Paulo", 28, "paulo@gmail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));




    }

    public Optional<User> getUser(Integer id){

        Optional <User> optional = Optional.empty();
        for(User user: userList){
            if (id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }

        return optional;

    }

    public List<User> getUserList() {
        return userList;
    }

    public User createUser(User user){

        userList.add(user);
        return user;
    }

    public void removeUser(Integer id){

        User user1 = null;
        for(User x: userList){
            if(x.getId() == id){
                user1 = x;
            }
        }

        userList.remove(user1);
    }


    public void updateUser(User user){

        for(User x: userList){
            if(x.getId() == user.getId()){

                x.setName(user.getName());
                x.setAge(user.getAge());
                x.setEmail(user.getEmail());

            }
        }

    }



}
