package umc.study.converter;

import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberMissionResponseDTO;

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
}
