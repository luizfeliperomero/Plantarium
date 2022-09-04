package com.planterium.user;

import com.planterium.exception.ApiRequestException;
import com.planterium.user.garden.Garden;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User addUser (User user){

        Optional<User> userOpt =  userRepository.findUserByEmail(user.getEmail());

        userOpt.ifPresent(u -> {
            throw new ApiRequestException("Email Already Taken");
        });

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    public User authenticate(String email, String password){

        Optional<User> userOpt =  userRepository.findUserByEmail(email);

        if(userOpt.isEmpty()){
            throw new ApiRequestException("Email does not exists");
        } else {
            if(passwordEncoder.matches(password, userOpt.get().getPassword())) {
                return userOpt.get();
            } else throw new ApiRequestException("Wrong Password");
        }

    }

    public User update(User user){
       System.out.println(user.getFirstName());
       return userRepository.save(user);
    }

    public void remove(){
        userRepository.deleteAll();
    }


}
