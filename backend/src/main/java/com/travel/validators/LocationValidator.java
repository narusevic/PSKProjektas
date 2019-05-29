package com.travel.validators;

import com.travel.models.Location;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LocationValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Location.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors){
        Location location = (Location) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty");
    }
}
