package Jumpking.JPproject.repository;

import Jumpking.JPproject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByid(String id);

}
