package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.validation.annotation.ExistStore;
import umc.study.validation.annotation.PositivePage;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.CreateResultMissionDto> createMission(
            @ExistStore @PathVariable(name = "storeId") Long storeId,
            @Valid @RequestBody MissionRequestDTO.CreateMissionDto request
    ) {
        return ApiResponse.onSuccess(
                missionCommandService.createMission(storeId, request)
        );
    }

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "storeId에 해당하는 가게의 미션들을 페이징으로 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "STORE4001", description = "가게가 존재하지 않습니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게 ID", required = true),
            @Parameter(name = "page", description = "조회할 페이지 번호 (1부터 시작)", required = true)
    })
    public ApiResponse<MissionResponseDTO.MissionPreviewListDTO> getStoreMissions(
            @ExistStore @PathVariable Long storeId,
            @PositivePage @RequestParam("page") Integer page
    ) {
        return ApiResponse.onSuccess(
                missionQueryService.getMissionListByStore(storeId, page)
        );
    }
}
