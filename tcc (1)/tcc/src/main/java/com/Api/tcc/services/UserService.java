package com.Api.tcc.services;

import java.util.List;
import java.util.Optional;

/* import java.util.Optional;

import org.springframework.beans.BeanUtils; */
import org.springframework.stereotype.Service;

import com.Api.tcc.dtos.UserDto;
import com.Api.tcc.models.UserModel;
import com.Api.tcc.repositories.UserRepository;

import jakarta.transaction.Transactional;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<UserModel> getUserById(Long id){
        return userRepository.findById(id);
    }

    public UserModel getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    @Transactional
    public UserModel saveUser(UserDto userDto){
        UserModel user = new UserModel();
        user.setEmail(userDto.email());
        user.setName(userDto.name());
        user.setPassword(userDto.password());
        user.setTasks(userDto.tasks());

        return userRepository.save(user);
    }

    @Transactional
    public UserModel updateUserTasks(long id, UserDto userDto){
        /* UserModel user = new UserModel(); */
        UserModel user = userRepository.findById(id).get();
        user.setEmail(user.getEmail());
        user.setId(user.getId());
        user.setName(user.getName());
        user.setPassword(user.getPassword());
        /* Optional<UserModel> user0 = userRepository.findById(id);
        var user = user0.get();
        BeanUtils.copyProperties(userDto, user); */
       /*  user.setId(id);
        user.setName(userRepository.findNameById(id));
        user.setPassword(userRepository.findPasswordById(id)); */
       user.setTasks(userDto.tasks());

        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
