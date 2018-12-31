package com.bahoga.nismian;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.bahoga.nismian.components.Position;

public class Constants {
    public static final float TILE_SIZE = 32f;

    private static final float WORLD_WIDTH = 100f; //en unidades del mundo
    private static final float WORLD_HEIGHT = 100f; //en unidades del mundo

    public static final float VISIBLE_VIEWPORT_WIDTH = WORLD_WIDTH * 0.3f; //en unidades del mundo
    public static final float VISIBLE_VIEWPORT_HEIGHT = WORLD_HEIGHT * 0.3f; //en unidades del mundo

    public static final float PLAYER_SPEED = 20f;
    public static final Vector2 PLAYER_SPAWN = new Vector2(0, 0); //en unidades del mundo

    public static Position fromPixelToWorldPosition(final Rectangle rectangle) {
        float x = rectangle.x / TILE_SIZE;
        float y = rectangle.y / TILE_SIZE;
        return new Position(x, y);
    }

    public static float fromPixelToWoldDimen(float pixels) {
        return pixels / TILE_SIZE;
    }
}
