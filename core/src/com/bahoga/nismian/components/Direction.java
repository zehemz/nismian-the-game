package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;

public class Direction extends Component {

    public static Direction with(Velocity velocity) {
        float x = velocity.get().x;
        float y = velocity.get().y;

        //TODO refactor using enum
        if (y > 0) {
            return new Direction(Pos.UP);
        } else if (x > 0) {
            return new Direction(Pos.RIGHT);
        } else if (x < 0) {
            return new Direction(Pos.LEFT);
        } else {
            return new Direction(Pos.DOWN);
        }

    }

    public enum Pos {
        UP(90),
        LEFT(180),
        DOWN(270),
        RIGHT(0);

        public float angle;

        Pos(float angle) {
            this.angle = angle;
        }
    }

    public final Pos pos;

    public Direction(final Pos pos) {
        this.pos = pos;
    }
}
