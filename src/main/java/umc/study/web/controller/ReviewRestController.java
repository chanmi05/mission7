package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}/reviews")
    public ResponseEntity<ReviewResponseDTO.CreateResultDto> createReview(
            @ExistStore @PathVariable Long storeId,
            @Valid @RequestBody ReviewRequestDTO.CreateDto request
    ) {
        ReviewResponseDTO.CreateResultDto response = reviewCommandService.createReview(storeId, request);
        return ResponseEntity.ok(response);
    }
}
