package com.travel.validators;

import com.travel.models.Accommodation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AccommodationValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Accommodation.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Accommodation accommodation = (Accommodation) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty");
    }
}