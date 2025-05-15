package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class StoreResponseDTO {

    @Getter
    @Builder
    public static class CreateStoreResultDto {
        private Long storeId;
        private Long regionId;
        private String name;
        private String address;
        private Float score;
        private LocalDateTime createdAt;
    }
}
