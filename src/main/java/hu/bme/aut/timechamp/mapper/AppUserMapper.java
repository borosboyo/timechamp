package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.AppUserDto;
import hu.bme.aut.timechamp.model.AppUser;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    public AppUserDto appUserToDto(AppUser appUser);
    public List<AppUserDto> appUsersToDto(List<AppUser> appUsers);
}
