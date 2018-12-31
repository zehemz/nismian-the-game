package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class Position extends Component {

    public final float x;
    public final float y;

    public Position(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    public Position(final Vector2 position) {
        this.x = position.x;
        this.y = position.y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
