package umc.study.service.MemberMissionService;

import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;

public interface MemberMissionCommandService {
    MemberMissionResponseDTO.CreateMissionResultDto challengeMission(MemberMissionRequestDTO.CreateMissionDto request);
}

