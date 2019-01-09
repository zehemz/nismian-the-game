package com.bahoga.nismian;

import com.badlogic.gdx.math.Vector2;

public final class Constants {
    private Constants()
    {
    }

    public static final float TILE_SIZE = 32f;

    public static final float WORLD_WIDTH = 100f; //en unidades del mundo
    public static final float WORLD_HEIGHT = 100f; //en unidades del mundo

    public static final float VISIBLE_VIEWPORT_WIDTH = WORLD_WIDTH * 0.3f; //en unidades del mundo
    public static final float VISIBLE_VIEWPORT_HEIGHT = WORLD_HEIGHT * 0.3f; //en unidades del mundo

    public static final Vector2 PLAYER_SPAWN = new Vector2(0, 0); //en unidades del mundo

    public static final float INTRO_VIEWPORT_WIDTH = 1200; //que se vea bien la UI
    public static final float INTRO_VIEWPORT_HEIGHT = 900; //que se vea bien la UI

}
