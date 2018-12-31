package com.bahoga.nismian.entities;


import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.bahoga.nismian.AnimationFactory;
import com.bahoga.nismian.Constants;
import com.bahoga.nismian.components.*;

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
                entity.add(new Velocity(0, 0));
                entity.add(new Dimension(1, 1));
                entity.add(Position.with(Constants.PLAYER_SPAWN));
                entity.add(BusyComponent.IDLE);
                entity.add(new ColorComponent(new Color(0, 1f, 0, 1)));
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
