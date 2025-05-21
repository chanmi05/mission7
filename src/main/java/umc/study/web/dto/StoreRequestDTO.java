package umc.study.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

public class StoreRequestDTO {

    @Getter
    @Setter
    public static class CreateStoreDto {

        @NotBlank(message = "가게 이름은 필수입니다.")
        private String name;

        @NotBlank(message = "가게 주소는 필수입니다.")
        private String address;

        @NotNull(message = "점수는 필수입니다.")
        @DecimalMin(value = "0.0", inclusive = true)
        @DecimalMax(value = "5.0", inclusive = true)
        private Float score;
    }
}
