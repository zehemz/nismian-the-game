package com.bahoga.nismian.entities;


import com.badlogic.ashley.core.Entity;
import com.bahoga.nismian.components.*;

import static com.bahoga.nismian.components.Direction.Pos.DOWN;

public class EntityFactory {

    public enum GameEntity {
        PLAYER,
        NPC
    }

    public static Entity create(final GameEntity gameEntity) {
        final Entity entity = new Entity();
        switch (gameEntity) {
            case PLAYER:
                entity.add(new Position(0, 0));
                entity.add(new Dimensions(1, 1));
                entity.add(new Direction(DOWN));
                entity.add(new Velocity(0, 0));
                entity.add(new Player());
                entity.add(new GameSprite(GameSprite.GameGraphic.PLAYER));
                break;
        }
        return entity;
    }
}
