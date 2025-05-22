package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.CreateMissionResultDto toCreateResultDTO(MemberMission memberMission) {

        return MemberMissionResponseDTO.CreateMissionResultDto.builder()
                .memberMissionId(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .status(memberMission.getStatus().name()) // Enum → 문자열
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
    // 진행 중인 미션 하나 변환
    public static MemberMissionResponseDTO.ChallengingMissionDTO toChallengingMissionDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.ChallengingMissionDTO.builder()
                .missionId(memberMission.getMission().getId())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .deadline(memberMission.getMission().getDeadline())
                .storeId(memberMission.getMission().getStore().getId())
                .storeName(memberMission.getMission().getStore().getName())
                .build();
    }

    // 전체 페이지 변환
    public static MemberMissionResponseDTO.ChallengingMissionListDTO toChallengingMissionListDTO(Page<MemberMission> page) {
        List<MemberMissionResponseDTO.ChallengingMissionDTO> dtos = page.stream()
                .map(MemberMissionConverter::toChallengingMissionDTO)
                .collect(Collectors.toList());

        return MemberMissionResponseDTO.ChallengingMissionListDTO.builder()
                .missions(dtos)
                .listSize(dtos.size())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .build();
    }

    public static MemberMissionResponseDTO.CompleteMissionResultDTO toCompleteMissionResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.CompleteMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .status(memberMission.getStatus().toString())
                .updatedAt(memberMission.getUpdatedAt())
                .build();
    }

}
