package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

// 응답 DTO
public class ReviewResponseDTO {
    @Getter
    @Builder
    public static class CreateResultDto {
        private Long reviewId;
        private Long storeId;
        private Long memberId;
        private String body;
        private Double score;
        private LocalDateTime createdAt;
    }
}

