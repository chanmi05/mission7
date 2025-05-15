package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.GeneralException;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.repository.RegionRepository;
import umc.study.validation.annotation.ExistRegion;

@Component
@RequiredArgsConstructor
public class ExistRegionValidator implements ConstraintValidator<ExistRegion, Long> {

    private final RegionRepository regionRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = regionRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.name())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
