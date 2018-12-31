package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class Velocity extends Component {

    public static final Velocity STOP = new Velocity(0, 0);

    public static final float DEFAULT_SPEED = 4f;

    private final Vector2 vector2;

    public Velocity(final float x, final float y) {
        vector2 = new Vector2(x, y);
    }

    public Vector2 get() {
        return vector2;
    }

}
