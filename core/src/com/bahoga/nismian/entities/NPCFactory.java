package com.bahoga.nismian.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.bahoga.nismian.AnimationFactory;
import com.bahoga.nismian.components.*;

import java.util.ArrayList;

public final class NPCFactory {

    private static final String NPC_LAYER_NAME = "npc";

    private NPCFactory() {
    }

    public static Iterable<Entity> create(final TiledMap tiledMap) {
        final ArrayList<Entity> entities = new ArrayList<>();
        final MapLayer npcLayer = tiledMap.getLayers().get(NPC_LAYER_NAME);
        final MapObjects npcObjects = npcLayer.getObjects();

        for (final MapObject mapObject : npcObjects) {
            Rectangle rectangle = ((RectangleMapObject) mapObject).getRectangle();
            AnimationComponent skellByAction = AnimationFactory.getSkellByAction(ActionComponent.Action.IDLE);

            final Entity entity = new Entity();
            entity.add(new NPCComponent());
            entity.add(new ColorComponent(new Color(1f, 0, 0, 1)));
            entity.add(Position.with(rectangle));
            entity.add(new Dimension(1, 1));
            entity.add(Velocity.STOP);
            entity.add(new ActionComponent(ActionComponent.Action.IDLE));
            entity.add(BusyComponent.IDLE);
            entity.add(skellByAction);
            entities.add(entity);
        }
        return entities;
    }
}
