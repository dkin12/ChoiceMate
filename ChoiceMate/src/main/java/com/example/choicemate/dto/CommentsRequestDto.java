package com.example.choicemate.dto;

import lombok.*;

/**
 * 댓글 등록 / 수정 / 삭제 요청용 DTO
 * 클라이언트 -> 서버
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentsRequestDto {

    private Integer postId;
    private String content;
    private String name;
    private String password;

}
