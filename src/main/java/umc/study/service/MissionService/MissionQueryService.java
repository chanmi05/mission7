package umc.study.service.MissionService;

import umc.study.web.dto.MissionResponseDTO;

public interface MissionQueryService {

    MissionResponseDTO.MissionPreviewListDTO getMissionListByStore(Long storeId, int page);
}
