package com.planterium.user;

import com.planterium.model.Login;
import com.planterium.user.garden.Garden;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @CrossOrigin(origins="*")
    @PostMapping(value = "/add", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(value =  "/authenticate", consumes = {"application/json"})
    public User authenticate(@RequestBody Login login){
        return userService.authenticate(login.getEmail(), login.getPassword());
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @PostMapping("/delete")
    public String delete(){
        userService.remove();
       return "User deleted";
    }

}

