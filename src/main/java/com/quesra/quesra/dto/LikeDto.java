package com.quesra.quesra.dto;

public class LikeDto {

    private Long postId;

    private Long userId;

    public LikeDto(Long postId, Long userId) {
        this.postId = postId;
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
