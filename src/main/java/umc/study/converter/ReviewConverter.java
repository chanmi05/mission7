package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static ReviewResponseDTO.MyReviewPreviewDTO toMyReviewPreviewDTO(Review review) {
        return ReviewResponseDTO.MyReviewPreviewDTO.builder()
                .reviewId(review.getId())
                .storeName(review.getStore().getName())
                .reviewBody(review.getBody())
                .score(review.getScore())
                .createdAt(review.getCreatedAt())
                .hasOwnerReply(false)   //임의로 false 설정
                .build();
    }

    public static ReviewResponseDTO.MyReviewPreviewListDTO toMyReviewPreviewListDTO(Page<Review> reviewPage) {
        List<ReviewResponseDTO.MyReviewPreviewDTO> reviewDTOs = reviewPage.stream()
                .map(ReviewConverter::toMyReviewPreviewDTO)
                .collect(Collectors.toList());

        return ReviewResponseDTO.MyReviewPreviewListDTO.builder()
                .reviews(reviewDTOs)
                .listSize(reviewDTOs.size())
                .totalPages(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();
    }
}
