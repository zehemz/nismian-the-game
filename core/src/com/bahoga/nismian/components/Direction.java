package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;

public class Direction extends Component {

    public enum Pos {
        DOWN,
        UP,
        LEFT,
        RIGHT
    }

    private final Pos pos;

    public Direction(final Pos pos) {
        this.pos = pos;
    }
}
