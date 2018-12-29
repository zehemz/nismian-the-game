package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;

public class Position extends Component {

    public final float x;
    public final float y;

    public Position(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
