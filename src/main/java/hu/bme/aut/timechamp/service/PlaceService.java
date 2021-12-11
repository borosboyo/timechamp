package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.dto.PlaceDto;
import hu.bme.aut.timechamp.mapper.PlaceMapper;
import hu.bme.aut.timechamp.model.Place;
import hu.bme.aut.timechamp.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PlaceMapper placeMapper;

    @Transactional
    public List<PlaceDto> findAll() {
        return placeMapper.placesToDto(placeRepository.findAll());
    }

    @Transactional
    public PlaceDto createPlace(String name, String googleCode, double longitude, double latitude){
        Place place = placeRepository.save(new Place(name, googleCode, longitude, latitude));
        return placeMapper.placeToDto(place);
    }

    @Transactional
    public PlaceDto findById(long id){
        return placeMapper.placeToDto(placeRepository.findById(id));
    }
}
