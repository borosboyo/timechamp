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
    public List<OrganizationDto> findAll(){
        return organizationMapper.organizationsToDto(organizationRepository.findAll());
    }

    @Transactional
    public OrganizationDto findById(long id){
        Organization result = organizationRepository.findById(id);
        return organizationMapper.organizationToDto(result);
    }

    @Transactional
    public OrganizationDto createOrganization(String name) {
        if(organizationRepository.findByName(name).size() != 0) {
            throw new IllegalArgumentException();
        }

        Organization saved = organizationRepository.save(new Organization(name));
        return organizationMapper.organizationToDto(saved);
    }

    @Transactional
    public void setHQ(long orgId, long placeId){
        Organization org =  organizationRepository.findById(orgId);
        Place place = placeRepository.findById(placeId);
        org.setHeadQuarter(place);
        place.setOrganization(org);
        organizationRepository.flush();
        placeRepository.flush();
    }
}
