package com.bahoga.nismian.entities;


import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.bahoga.nismian.AnimationFactory;
import com.bahoga.nismian.Constants;
import com.bahoga.nismian.components.*;
import com.bahoga.nismian.maps.MapFactory;

import static com.bahoga.nismian.components.Direction.Pos.DOWN;

public class EntityFactory {

    public enum GameEntity {
        PLAYER,
        CAMERA,
    }

    public static Entity create(final GameEntity gameEntity) {
        final Entity entity = new Entity();
        switch (gameEntity) {
            case PLAYER:
                entity.add(new Dimensions(1, 1));
                entity.add(new Direction(DOWN));
                entity.add(new Velocity(0, 0));
                entity.add(new Player());
                entity.add(new Position(Constants.PLAYER_SPAWN));
                entity.add(new BusyComponent(0f));
                entity.add(AnimationFactory.getSkellByAction(ActionComponent.Action.IDLE));
                entity.add(new ActionComponent(ActionComponent.Action.IDLE));
                break;
            case CAMERA:
                entity.add(new CameraComponent(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
                break;
        }
        return entity;
    }
}
