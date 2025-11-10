package com.example.choicemate.controller;


import com.example.choicemate.dto.CommentsRequestDto;
import com.example.choicemate.dto.CommentsResponseDto;
import com.example.choicemate.entity.Comments;
import com.example.choicemate.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public String create( CommentsRequestDto dto) {
        Comments comments = commentService.register(
                dto.getPostId(),
                dto.getName(),
                dto.getPassword(),
                dto.getContent()
        );
        return "redirect:/choicemate";
    }

    // 댓글 수정
    @PutMapping("/{id}")
    @ResponseBody
    public CommentsResponseDto update(@PathVariable int id,
                                      @RequestBody CommentsRequestDto dto) {
        var comments = commentService.update(id, dto.getPassword(), dto.getContent());
        return CommentsResponseDto.fromEntity(comments);
    }

    // 댓글 삭제
    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable int id,
                       @RequestBody CommentsRequestDto dto) {
        commentService.delete(id, dto.getPassword());
    }
}

