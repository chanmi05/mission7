package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    public static class CreateMissionResultDto {
        private Long memberMissionId;
        private Long memberId;
        private Long missionId;
        private String status;
        private LocalDateTime createdAt;
    }
}
