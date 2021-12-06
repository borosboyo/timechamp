package hu.bme.aut.timechamp.web.controller.restcontroller;


import hu.bme.aut.timechamp.dto.PlaceDto;
import hu.bme.aut.timechamp.mapper.PlaceMapper;
import hu.bme.aut.timechamp.model.Place;
import hu.bme.aut.timechamp.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceRestController {

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    PlaceMapper placeMapper;

/*    @GetMapping
    public List<Place> findAll(){
        List<Place> places = placeRepository.findAll();

        places.forEach(this::setUnnededPlaceFieldsToNull);
        return placeRepository.findAll();
    }

    private void setUnnededPlaceFieldsToNull(Place place){
        Organization org = place.getOrganization();
        if(org != null){
            org.setHeadQuarters(null);
        }
    }
*/
    public List<PlaceDto> findAll() {
        List<Place> places = placeRepository.findAll();
        return placeMapper.placesToDto(places);
    }


    @PostMapping
    public Place createPlace(@RequestBody Place place){
        return placeRepository.save(place);
    }
}
