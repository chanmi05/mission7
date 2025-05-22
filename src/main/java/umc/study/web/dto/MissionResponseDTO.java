package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionResponseDTO {

    @Getter
    @Builder
    public static class CreateResultMissionDto {
        private Long missionId;
        private Long storeId;
        private String missionSpec;
        private Integer reward;
        private LocalDate deadline;
        private LocalDateTime createdAt;
    }
}
