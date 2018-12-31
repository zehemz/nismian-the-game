package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import static com.bahoga.nismian.Constants.TILE_SIZE;

public class Position extends Component {


    private final Vector2 vector;

    public Position(final float x, final float y) {
        vector = new Vector2(x, y);
    }

    public Vector2 get() {
        return vector;
    }

    /**
     * @param position
     * @param velocity
     * @param delta
     * @return
     */
    public static Position with(final Position position, final Velocity velocity, final float delta) {
        return new Position(position.get().x + velocity.get().x * delta, position.get().y + velocity.get().y * delta);
    }

    public static Position with(final Vector2 vector2) {
        return new Position(vector2.x, vector2.y);
    }

    public static Position with(final Rectangle rectangle) {
        float x = rectangle.x / TILE_SIZE;
        float y = rectangle.y / TILE_SIZE;
        return new Position(x, y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + get().x +
                ", y=" + get().y +
                '}';
    }
}
