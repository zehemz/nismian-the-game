package com.bahoga.nismian.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.bahoga.nismian.AnimationFactory;
import com.bahoga.nismian.Constants;
import com.bahoga.nismian.components.ActionComponent;
import com.bahoga.nismian.components.AnimationComponent;
import com.bahoga.nismian.components.CameraComponent;

import java.util.ArrayList;

public final class NPCFactory {

    public static final String NPC_LAYER_NAME = "npc";

    private NPCFactory() {
    }

    public static Iterable<Entity> create(final TiledMap tiledMap, final CameraComponent cameraComponent) {
        ArrayList<Entity> entities = new ArrayList<>();
        MapLayer npcLayer = tiledMap.getLayers().get(NPC_LAYER_NAME);
        MapObjects npcObjects = npcLayer.getObjects();
        int i = 4;
        int j = 22;
        for (MapObject mapObject : npcObjects) {
            Rectangle rectangle = ((RectangleMapObject) mapObject).getRectangle();


            AnimationComponent skellByAction = AnimationFactory.getSkellByAction(ActionComponent.Action.IDLE);

            Entity entity = new Entity();
            entity.add(Constants.fromPixelToWorldPosition(rectangle));
            entity.add(skellByAction);
            entities.add(entity);


        }
        return entities;
    }
}
