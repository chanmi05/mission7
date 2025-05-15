package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.ExistRegionValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistRegionValidator.class})
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistRegion {

    String message() default "해당 지역이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
