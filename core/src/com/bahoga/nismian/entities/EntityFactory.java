package com.bahoga.nismian.entities;


import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.bahoga.nismian.components.*;
import com.bahoga.nismian.maps.MapFactory;

import static com.bahoga.nismian.components.Direction.Pos.DOWN;

public class EntityFactory {

    private static float TAIL_SIZE = 32f;
    private static final float RATIO_HEIGHT = 600f / 800f;
    private static final float RELATIVE_WORLD_WIDTH = 100f * TAIL_SIZE;
    private static final float RELATIVE_WORLD_HEIGHT = 100f * TAIL_SIZE;

    public enum GameEntity {
        PLAYER,
        CAMERA,
        MAP,
        NPC
    }

    public static Entity create(final GameEntity gameEntity) {
        final Entity entity = new Entity();
        switch (gameEntity) {
            case PLAYER:
                entity.add(new Dimensions(1, 1));
                entity.add(new Direction(DOWN));
                entity.add(new Velocity(0, 0));
                entity.add(new Player());
                entity.add(new Position(RELATIVE_WORLD_WIDTH / 2, RELATIVE_WORLD_HEIGHT / 2));
                entity.add(new GameSprite(GameSprite.GameGraphic.PLAYER));
                break;
            case CAMERA:
                entity.add(new CameraComponent(TAIL_SIZE, RATIO_HEIGHT));
                break;
            case MAP:
                final TiledMap tiledMap = MapFactory.create(MapFactory.GameMap.MAIN_MAP);
                entity.add(new MapComponent(tiledMap));
                break;
        }
        return entity;
    }
}
