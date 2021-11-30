package hu.bme.aut.timechamp.repository;

import hu.bme.aut.timechamp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    List<AppUser> findByUserName(String name);

}
