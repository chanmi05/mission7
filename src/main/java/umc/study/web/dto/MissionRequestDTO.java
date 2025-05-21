package umc.study.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    @Setter
    public static class CreateMissionDto {
        @NotNull
        private Integer reward;

        @Future(message = "마감일은 미래여야 합니다.")
        @NotNull
        private LocalDate deadline;

        @NotBlank
        private String missionSpec;
    }
}
