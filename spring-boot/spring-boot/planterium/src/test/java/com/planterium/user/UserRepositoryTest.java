package com.planterium.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataMongoTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @Test
    void findUserByEmail() {
        //given
        String email = "mag@gmail.com";
        User user = new User("Magnus", email);
        underTest.save(user);

        //when
        Optional<User> userOpt =  underTest.findUserByEmail(email);

        //then
        assertThat(userOpt).isNotEmpty();
    }
}