package com.bahoga.nismian;

import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final float TILE_SIZE = 32f;

    public static final float WORLD_WIDTH = 100f; //en unidades del mundo
    public static final float WORLD_HEIGHT = 100f; //en unidades del mundo

    public static final float VISIBLE_VIEWPORT_WIDTH = WORLD_WIDTH * 0.3f; //en unidades del mundo
    public static final float VISIBLE_VIEWPORT_HEIGHT = WORLD_HEIGHT * 0.3f; //en unidades del mundo

    public static final Vector2 PLAYER_SPAWN = new Vector2(0, 0); //en unidades del mundo

    public static float fromPixelToWorldDimen(float pixels) {
        return pixels / TILE_SIZE;
    }
}
