package hu.bme.aut.timechamp.web.controller.normalcontroller;


import hu.bme.aut.timechamp.dto.PlaceDto;
import hu.bme.aut.timechamp.service.PlaceService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @GetMapping("/places")
    public String home(Map<String, Object> model){
        List<PlaceDto> places = placeService.findAll();

        model.put("places", places);
        model.put("newPlace", new PlaceParameters());
        return "placePage";
    }

    @PostMapping("/createPlace")
    public String createPlace(PlaceParameters placeParameters){
        placeService.createPlace(placeParameters.getName(), placeParameters.getGoogleCode(), placeParameters.getLongitude(), placeParameters.getLatitude());
        return "redirect:/places";
    }

    @Setter
    @Getter
    static
    class PlaceParameters {
        private String name;
        private String googleCode;
        private double longitude;
        private double latitude;
    }

}
