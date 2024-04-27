package com.parkseryu.shop.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    private String content;
    private Long parentId;
}
