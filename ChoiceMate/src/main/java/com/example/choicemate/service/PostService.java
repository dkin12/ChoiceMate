package com.example.choicemate.service;

import com.example.choicemate.dto.PostDto;
import com.example.choicemate.entity.Post;
import com.example.choicemate.repository.PostRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * 글 CRUD, 투표 로직 구현 서비스 클래스
 */
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRespository repo;

    // 가장 최신 글 + 댓글 조회
    public PostDto getLatestPost() {
        Post post = repo.findFirstByOrderByIdDesc()
                .orElseThrow(() -> new RuntimeException("게시글이 없습니다."));

        return PostDto.fromEntity(post);
    }
}
