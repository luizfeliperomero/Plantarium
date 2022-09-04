package com.planterium.user;

import com.planterium.user.garden.Garden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String photo;
    private String phone;
    private String email;
    private String password;
    private List<Garden> gardens;

    public User(String firstName, String email){
        this.firstName = firstName;
        this.email = email;
    }
}
