package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;

public class Velocity extends Component {
    public final float x;
    public final float y;

    public Velocity(final float x, final float y) {
        this.x = x;
        this.y = y;
    }
}
