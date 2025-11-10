package com.example.choicemate.service;

import com.example.choicemate.entity.Comments;
import com.example.choicemate.entity.Post;
import com.example.choicemate.repository.CommentRepository;
import com.example.choicemate.repository.PostRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepo;
    private final PostRespository postRepo;

    // 등록
    @Transactional
    public Comments register(Integer postId, String name, String password, String content) {
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "post not found"));

        Comments comments = Comments.builder()
                .post(post)
                .name(name)
                .password(password)
                .content(content)
                .build();
        return commentRepo.save(comments);
    }

    // 수정
    @Transactional
    public Comments update(int id, String password, String newContent) {
        Comments comments = commentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // 비밀번호 체크
        if (!comments.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비밀번호가 일치하지 않습니다.");
        }

        comments.updateContent(newContent);
        // JPA더티체킹으로 저장됨
        return comments;
    }

    // 삭제
    @Transactional
    public void delete(int id, String password) {
        Comments comments = commentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!comments.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비밀번호가 일치하지 않습니다.");
        }

        commentRepo.delete(comments);
    }
}
