package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class Direction extends Component {

    public static Direction with(Velocity velocity) {
        Vector2 vector2 = velocity.get();
        float angle = vector2.angle();

        //TODO refactor using enum
        if (angle == 90f) {
            return new Direction(Pos.UP);
        } else if (angle == 0f) {
            return new Direction(Pos.RIGHT);
        } else if (angle == 180f) {
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
