package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.dto.OrganizationDto;
import hu.bme.aut.timechamp.mapper.OrganizationMapper;
import hu.bme.aut.timechamp.model.Organization;
import hu.bme.aut.timechamp.model.Place;
import hu.bme.aut.timechamp.repository.OrganizationRepository;
import hu.bme.aut.timechamp.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Transactional
    public List<Organization> findAll(){
        return organizationRepository.findAll();
    }

    @Transactional
    public OrganizationDto findById(long id){
        Organization result = organizationRepository.findById(id);
        return organizationMapper.organizationToDto(result);
    }

    @Transactional
    public long createOrganization(String name){
        return organizationRepository.save(new Organization(name)).getId();
    }

    @Transactional
    public void setHQ(long orgId, long placeId){
        Organization org =  organizationRepository.findById(orgId);
        Place place = placeRepository.findById(placeId);
        org.setHeadQuarter(place);
        organizationRepository.flush();
        placeRepository.flush();
    }
}
