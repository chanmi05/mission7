package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @Getter
    @Builder
    public static class ChallengingMissionDTO {
        private Long missionId;
        private String missionSpec;
        private LocalDate deadline;
        private Long storeId;
        private String storeName;
    }

    @Getter
    @Builder
    public static class ChallengingMissionListDTO {
        private List<ChallengingMissionDTO> missions;
        private int listSize;
        private int totalPages;
        private long totalElements;
        private boolean isFirst;
        boolean isLast;
    }
}
