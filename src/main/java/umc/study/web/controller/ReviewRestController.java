package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.CreateResultDto> createReview(
            @ExistStore @PathVariable Long storeId,
            @Valid @RequestBody ReviewRequestDTO.CreateDto request
    ) {
        return ApiResponse.onSuccess(
                reviewCommandService.createReview(storeId, request)
        );
    }

}
