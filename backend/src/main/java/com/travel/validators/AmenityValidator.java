package com.travel.validators;

import com.travel.models.Amenity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AmenityValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Amenity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Amenity amenity = (Amenity) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
    }
}
