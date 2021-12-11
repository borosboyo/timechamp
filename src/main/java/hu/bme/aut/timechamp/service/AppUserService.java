package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.mapper.AppUserMapper;
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

    @Autowired
    private AppUserMapper appUserMapper;

    @Transactional
    public List<AppUserDto> findAll(){
        return appUserMapper.appUsersToDto(appUserRepository.findAll());
    }

    public AppUserDto createUser(String email, String username, String password){
        AppUser appUser = appUserRepository.save(new AppUser(email, username, password));
        return appUserMapper.appUserToDto(appUser);
    }

    @Transactional
    public AppUserDto findById(long id){
        return appUserMapper.appUserToDto(appUserRepository.findById(id));
    }

    @Transactional
    public boolean updateById(long id, String email, String username, String password){
        int result = appUserRepository.updateById(id, email, username, password);
        System.out.println(result);
        return result > 0;
    }
}
