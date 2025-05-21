package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.validation.annotation.ExistRegion;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{regionId}/stores")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDto> createStore(
            @ExistRegion @PathVariable(name = "regionId") Long regionId,
            @Valid @RequestBody StoreRequestDTO.CreateStoreDto request
    ) {
        return ApiResponse.onSuccess(storeCommandService.createStore(regionId, request));
    }
}
