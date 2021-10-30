package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.User;
import java.util.List;

public interface UserRepository {
    User save(User user);

    List<User> findByName(String name);

    void delete(User user);

}
