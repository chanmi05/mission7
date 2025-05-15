package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.CreateMissionResultDto> challengeMission(
            @Valid @RequestBody MemberMissionRequestDTO.CreateMissionDto request
    ) {
        return ApiResponse.onSuccess(
                memberMissionCommandService.challengeMission(request)
        );
    }

}
