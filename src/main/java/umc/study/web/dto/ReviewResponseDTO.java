package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

// 응답 DTO
public class ReviewResponseDTO {
    @Getter
    @Builder
    public static class CreateResultDto {
        private Long reviewId;
        private Long storeId;
        private Long memberId;
        private String body;
        private Float score;
        private LocalDateTime createdAt;
    }

    @Getter
    @Builder
    public static class MyReviewPreviewDTO {
        private Long reviewId;
        private String storeName;
        private String reviewBody;
        private Float score;
        private LocalDateTime createdAt;
        private boolean hasOwnerReply;
    }

    @Getter
    @Builder
    public static class MyReviewPreviewListDTO {
        private List<MyReviewPreviewDTO> reviews;
        private int listSize;
        private int totalPages;
        private long totalElements;
        private boolean isFirst;
        private boolean isLast;
    }
}

