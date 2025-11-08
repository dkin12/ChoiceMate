package com.example.choicemate.dto;

import com.example.choicemate.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 클라이언트 -> 서버
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {

    private Integer id;
    private String title;
    private String content;
    private String optionA;
    private String optionB;
    private int votesA;
    private int votesB;

    // 게시글에 작성된 댓글
    private List<CommentsResponseDto> comments;

    public static PostDto fromEntity(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .optionA(post.getOptionA())
                .optionB(post.getOptionB())
                .votesA(post.getVotesA())
                .votesB(post.getVotesB())
                .comments(
                        post.getComments().stream()
                                .map(CommentsResponseDto::fromEntity)
                                .toList()
                )
                .build();
    }

}
