package com.example.choicemate.dto;

import com.example.choicemate.entity.Comments;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 댓글 조회 / 응답용
 * 서버 -> 클라이언트
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentsResponseDto {

    private Integer id;
    private String name;
    private String content;

    public static CommentsResponseDto fromEntity(Comments comments) {
        return CommentsResponseDto.builder()
                .id(comments.getId())
                .name(comments.getName())
                .content(comments.getContent())
                .build();
    }

}
