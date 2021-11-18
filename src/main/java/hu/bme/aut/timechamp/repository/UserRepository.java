package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserName(String name);

}
