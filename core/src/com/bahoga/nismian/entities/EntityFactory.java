package com.bahoga.nismian.entities;


import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.bahoga.nismian.AnimationFactory;
import com.bahoga.nismian.Constants;
import com.bahoga.nismian.components.*;

import static com.bahoga.nismian.components.Dimension.DEFAULT_DIMENSION;

public class EntityFactory {

    public enum GameEntity {
        PLAYER,
        CAMERA,
    }

    public static Entity create(final GameEntity gameEntity) {
        final Entity entity = new Entity();
        switch (gameEntity) {
            case PLAYER:
                entity.add(new Player());
                entity.add(Velocity.STOP);
                entity.add(DEFAULT_DIMENSION);
                entity.add(new Direction(Direction.Pos.RIGHT));
                entity.add(Position.with(Constants.PLAYER_SPAWN));
                entity.add(ColorComponent.GREEN);
                entity.add(AnimationFactory.getSkellByAction(ActionComponent.Action.IDLE));
                entity.add(new ActionComponent(ActionComponent.Action.IDLE));
                entity.add(BusyComponent.IDLE);
                break;
            case CAMERA:
                entity.add(new CameraComponent(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
                break;
        }
        return entity;
    }
}
