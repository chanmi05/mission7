package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @Getter
    @Builder
    public static class MissionPreviewDTO {
        private Long missionId;
        private String missionSpec;
        private LocalDate deadline;
    }

    @Getter
    @Builder
    public static class MissionPreviewListDTO {
        private List<MissionPreviewDTO> missions;
        private int listSize;
        private int totalPages;
        private long totalElements;
        private boolean isFirst;
        private boolean isLast;
    }

}
