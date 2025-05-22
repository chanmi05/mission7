package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.study.validation.annotation.PositivePage;

@Component
public class PositivePageValidator implements ConstraintValidator<PositivePage, Integer> {

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        // null은 허용 (nullable param), 음수는 불허
        return page == null || page >= 0;
    }
}
