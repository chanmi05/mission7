package umc.study.web.dto;

import jakarta.validation.constraints.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

// 요청 DTO
public class ReviewRequestDTO {
    @Getter
    @Setter
    public static class CreateDto {
        @NotBlank(message = "리뷰 내용은 필수입니다.")
        private String body;

        @NotNull(message = "점수는 필수입니다.")
        @DecimalMin(value = "0.0", inclusive = true)
        @DecimalMax(value = "5.0", inclusive = true)
        private Float score;
    }
}

