package com.vincedgy.mongodbserver;

import com.vincedgy.mongodbserver.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends MongoRepository<User, String> {

    @Query("{lastName:'?0'}")
    List<User> findUserByLastName(String lastname);
    @Query("{email:'?0'}")
    Optional<User> findUserByEmail(String email);
}
