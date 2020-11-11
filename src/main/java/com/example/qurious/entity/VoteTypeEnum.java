package com.example.qurious.entity;

import java.util.Arrays;

public enum VoteTypeEnum {

    UPVOTE(1), DOWNVOTE(-1);

    private final int direction;

    VoteTypeEnum(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public static VoteTypeEnum lookup(int direction) throws Exception {
        return Arrays.stream(VoteTypeEnum.values())
                .filter(value -> value.getDirection() == direction)
                .findAny()
                .orElseThrow(() -> new Exception("Invalid vote"));
    }
}
