package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.repository.AppUserRepository;
import hu.bme.aut.timechamp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser createUser(String email, String username, String password){
        return appUserRepository.save(new AppUser(email, username, password));
    }

    @Transactional
    public AppUser findById(long id){
        return appUserRepository.findById(id);
    }
}
