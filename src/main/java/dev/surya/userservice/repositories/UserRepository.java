package dev.surya.userservice.repositories;

import dev.surya.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends
        JpaRepository<User, Long> {

//    @Query(value = "select password from user where email = :Email", nativeQuery = true)
//    String getPasswordByEmailEquals(String Email);

    Optional<User> findByEmail(String email);

}
