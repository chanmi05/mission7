package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.CreateStoreDto request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .region(region)
                .build();
    }

    public static StoreResponseDTO.CreateStoreResultDto toCreateResultDTO(Store store) {
        return StoreResponseDTO.CreateStoreResultDto.builder()
                .storeId(store.getId())
                .regionId(store.getRegion().getId())
                .name(store.getName())
                .address(store.getAddress())
                .score(store.getScore())
                .createdAt(store.getCreatedAt())
                .build();
    }
}
