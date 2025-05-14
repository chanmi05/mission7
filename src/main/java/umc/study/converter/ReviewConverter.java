package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateDto dto, Store store, Member member) {
        return Review.builder()
                .store(store)
                .member(member)
                .body(dto.getBody())
                .score(dto.getScore())
                .build();
    }

    public static ReviewResponseDTO.CreateResultDto toCreateResultDto(Review review) {
        return ReviewResponseDTO.CreateResultDto.builder()
                .reviewId(review.getId())
                .storeId(review.getStore().getId())
                .memberId(review.getMember().getId())
                .body(review.getBody())
                .score(review.getScore())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
