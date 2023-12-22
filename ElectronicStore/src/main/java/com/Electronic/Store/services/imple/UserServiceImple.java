package com.Electronic.Store.services.imple;

import com.Electronic.Store.dtos.Userdtos;
import com.Electronic.Store.entities.User;
import com.Electronic.Store.exceptions.ResourceNotFoundException;
import com.Electronic.Store.repositories.UserRepository;
import com.Electronic.Store.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    //Create Method
    @Override
    public Userdtos CreateUser(Userdtos userdtos) {
        //id genarartion randomly
        String id = UUID.randomUUID().toString();
        userdtos.setId(id);
        //convert to dto to entiry
        User user = dtoToEntity(userdtos);
        userRepository.save(user);//save to database
        //convert to entity to dto
        Userdtos userdtos1 = EntityTodto(user);
        return userdtos1;

    }


//Update mathod
    @Override
    public Userdtos updateUser(Userdtos userdtos, String id) {

        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("id not found exception"));
        user.setName(userdtos.getName());
        user.setGender(userdtos.getGender());
        user.setPassword(userdtos.getPassword());
        user.setImageName(userdtos.getImageName());
        Userdtos userdtos1=  EntityTodto(user);
        return userdtos1;
    }

    //get usr mehtod

    @Override
    public Userdtos getUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found id"));
        Userdtos userdtos = EntityTodto(user);
        return userdtos;
    }

    @Override
    public Userdtos getUserByEmail(String email) {

        User user = userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("user not found with this  email"));
        Userdtos userdtos = EntityTodto(user);
        return userdtos;
    }

    @Override
    public List<Userdtos> getAllUser() {

        List<User> allUser = userRepository.findAll();
        List<Userdtos> DtoList = allUser.stream().map(user -> EntityTodto(user)).collect(Collectors.toList());
        return DtoList;

    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found id"));
        userRepository.delete(user);

    }

    @Override
    public List<Userdtos> searchUser(String keyword) {

        List<User> users = userRepository.findByNameContaining(keyword);
        List<Userdtos> dtos = users.stream().map(user -> EntityTodto(user)).collect(Collectors.toList());
        return dtos;

    }


//-----------------conversion----------------------------------



    private User dtoToEntity(Userdtos userdtos) {
//        User user  = User.builder()
//                .id(userdtos.getId())
//                .Name(userdtos.getName())
//                .email(userdtos.getEmail())
//                .gender(userdtos.getGender())
//                .password(userdtos.getPassword())
//                .imageName(userdtos.getImageName()).build();
//        return user;
        return modelMapper.map(userdtos,User.class);
    }
    private Userdtos EntityTodto(User user){
//        Userdtos userdtos=  Userdtos.builder()
//
//                .id(user.getId())
//                .gender(user.getGender())
//                .email(user.getEmail())
//                .password(user.getPassword())
//                .Name(user.getName())
//                .imageName(user.getImageName())
//                .build();
//        return userdtos;

        return modelMapper.map(user,Userdtos.class);
    }
}
