package hu.bme.aut.timechamp.service;

import hu.bme.aut.timechamp.dto.PlaceDto;
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

    @Transactional
    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    @Transactional
    public Place createPlace(String name, String googleCode, double longitude, double latitude){
        return placeRepository.save(new Place(name, googleCode, longitude, latitude));
    }
}
