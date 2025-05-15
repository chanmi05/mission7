package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.MemberMissionRepository;
import umc.study.validation.annotation.NotChallenged;

@Component
@RequiredArgsConstructor
public class NotChallengedValidator implements ConstraintValidator<NotChallenged, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {

        // 로그인 기능이 없기 때문에 무조건 memberId = 1L 사용
        boolean alreadyChallenged = memberMissionRepository
                .findByMemberIdAndMissionId(1L, missionId)
                .isPresent();

        if (alreadyChallenged) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY.toString())
                    .addConstraintViolation();
        }

        return !alreadyChallenged;
    }
}
