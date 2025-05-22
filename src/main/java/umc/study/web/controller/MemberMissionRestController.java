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
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.GeneralException;
import umc.study.domain.Member;
import umc.study.repository.MemberRepository;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.service.MemberMissionService.MemberMissionQueryService;
import umc.study.validation.annotation.PositivePage;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;
    private final MemberRepository memberRepository;

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.CreateMissionResultDto> challengeMission(
            @Valid @RequestBody MemberMissionRequestDTO.CreateMissionDto request
    ) {
        return ApiResponse.onSuccess(
                memberMissionCommandService.challengeMission(request)
        );
    }

    @GetMapping("/my-missions")
    @Operation(summary = "진행 중인 미션 목록 조회 API", description = "하드코딩된 사용자(1L)의 진행 중인 미션 목록을 페이징으로 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER4001", description = "사용자 없음", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호 (1부터 시작)", required = true)
    })
    public ApiResponse<MemberMissionResponseDTO.ChallengingMissionListDTO> getMyChallengingMissions(
            @PositivePage @RequestParam("page") Integer page
    ) {
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        return ApiResponse.onSuccess(
                memberMissionQueryService.getChallengingMissions(member, page)
        );
    }

    @PatchMapping("/my-missions/{memberMissionId}")
    @Operation(summary = "진행 중인 미션 완료 처리 API", description = "진행 중인 미션의 상태를 COMPLETE로 변경합니다.")
    @Parameters({
            @Parameter(name = "memberMissionId", description = "MemberMission ID", required = true)
    })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION4001", description = "해당 미션이 존재하지 않음"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION4002", description = "이미 완료된 미션")
    })
    public ApiResponse<MemberMissionResponseDTO.CompleteMissionResultDTO> completeMission(
            @PathVariable Long memberMissionId
    ) {
        return ApiResponse.onSuccess(
                memberMissionCommandService.completeMission(memberMissionId)
        );
    }
}
