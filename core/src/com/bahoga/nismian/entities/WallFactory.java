package com.bahoga.nismian.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.bahoga.nismian.components.Dimension;
import com.bahoga.nismian.components.Position;
import com.bahoga.nismian.components.Velocity;

import java.util.ArrayList;

public final class WallFactory {

    private static final String WALL_LAYER_NAME = "collision";

    private WallFactory() {
    }

    public static Iterable<Entity> create(final TiledMap tiledMap) {
        final ArrayList<Entity> entities = new ArrayList<>();
        final MapLayer npcLayer = tiledMap.getLayers().get(WALL_LAYER_NAME);
        final MapObjects collisionObjects = npcLayer.getObjects();

        for (final MapObject mapObject : collisionObjects) {
            Rectangle rectangle = ((RectangleMapObject) mapObject).getRectangle();

            Entity entity = new Entity();
            entity.add(Position.with(rectangle));
            entity.add(Dimension.with(rectangle));
            entity.add(Velocity.STOP);
            entities.add(entity);

        }
        return entities;
    }
}
