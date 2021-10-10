package com.hritikchaurasia.userservice.Repository;


import com.hritikchaurasia.userservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{'email' : ?0}")
    Optional<User> checkUserExist(String email);
}
