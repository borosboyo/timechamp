package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Transactional
    public Organization createOrganization(String name){
        return organizationRepository.save(new Organization(name));
    }
}
