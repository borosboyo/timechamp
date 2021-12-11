package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Transactional
    public List<Organization> findAll(){
        return organizationRepository.findAll();
    }


    @Transactional
    public Organization createOrganization(String name){
        return organizationRepository.save(new Organization(name));
    }
}
