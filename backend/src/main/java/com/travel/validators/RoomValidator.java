package com.travel.validators;

import com.travel.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RoomValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass){
        return Room.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors){
        Room room = (Room) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "NotEmpty");
        if(room.getNumber() < 0) {
            errors.rejectValue("number", "Room number should not be negative.");
        }
    }
}
