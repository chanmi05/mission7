package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.PositivePageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PositivePageValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface PositivePage {
    String message() default "페이지 번호는 0 이상의 정수여야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
