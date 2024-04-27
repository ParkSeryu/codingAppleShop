package com.parkseryu.shop.comment;

import com.parkseryu.shop.member.CustomUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class CommentController {

    CommentRepository commentRepository;

    @PostMapping("/comment")
    String postComment(CommentDTO commentDTO, Authentication auth) {
        Comment comment = new Comment();
        var a = (CustomUser) auth.getPrincipal();
        comment.setContent(commentDTO.getContent());
        comment.setParentId(commentDTO.getParentId());
        comment.setUsername(a.getUsername());
        commentRepository.save(comment);
        return "redirect:/list";
    }
}
