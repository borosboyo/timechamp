package hu.bme.aut.timechamp.mapper;

import hu.bme.aut.timechamp.dto.PlaceDto;
import hu.bme.aut.timechamp.model.Place;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaceMapper {

    public PlaceDto placeToDto(Place place);
    public List<PlaceDto> placesToDto(List<Place> places);
}
