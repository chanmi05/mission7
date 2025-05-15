package umc.study.service.StoreService;

import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public interface StoreCommandService {

    StoreResponseDTO.CreateStoreResultDto createStore(Long regionId, StoreRequestDTO.CreateStoreDto request);
}
