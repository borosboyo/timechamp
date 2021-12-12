package hu.bme.aut.timechamp.web.controller.restcontroller;

import hu.bme.aut.timechamp.dto.AppUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Supplier;

public class RestUtils {
    public static <T> T executeRestRequest(Supplier<T> request, HttpStatus ifException, HttpStatus ifNull){
        T result;
        try {
            result = request.get();
        } catch (IllegalArgumentException exception){
            throw new ResponseStatusException(ifException);
        }
        if(result == null){
            throw new ResponseStatusException(ifNull);
        }
        return result;
    }

    public static <T> T executeRestRequest(Supplier<T> request){
        return executeRestRequest(request, HttpStatus.BAD_REQUEST, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> T executeRestRequest(Supplier<T> request, HttpStatus ifNull){
        return executeRestRequest(request, HttpStatus.BAD_REQUEST, ifNull);
    }
}
