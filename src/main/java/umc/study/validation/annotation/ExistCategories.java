package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.CategoriesExistValidator;

import java.lang.annotation.*;

@Documented // 사용자 정의 어노테이션을 만들때 붙임.
@Constraint(validatedBy = CategoriesExistValidator.class)   // 어노테이션의 적용범위를 지정
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME) //어노테이션의 생명주기를 지정 -> RUNTIME : 실행 동안에만 유효
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
