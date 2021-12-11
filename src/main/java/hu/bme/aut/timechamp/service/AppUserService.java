package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.model.AppUser;
import hu.bme.aut.timechamp.repository.AppUserRepository;
import hu.bme.aut.timechamp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Transactional
    public List<AppUser> findAll(){
        return appUserRepository.findAll();
    }

    public AppUser createUser(String email, String username, String password){
        return appUserRepository.save(new AppUser(email, username, password));
    }

    @Transactional
    public AppUser findById(long id){
        return appUserRepository.findById(id);
    }

    @Transactional
    public void updateById(long id, String email, String username, String password){
        appUserRepository.updateById(id, email, username, password);
    }
}
