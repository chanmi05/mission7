package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.validation.annotation.NotChallenged;

public class MemberMissionRequestDTO {

    @Getter
    @Setter
    public static class CreateMissionDto {

        @NotNull(message = "도전할 미션 ID는 필수입니다.")
        @NotChallenged
        private Long missionId;
    }
}
