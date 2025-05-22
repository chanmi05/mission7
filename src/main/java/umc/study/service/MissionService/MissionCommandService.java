package umc.study.service.MissionService;

import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO.CreateResultMissionDto createMission(Long storeId, MissionRequestDTO.CreateMissionDto request);
}
