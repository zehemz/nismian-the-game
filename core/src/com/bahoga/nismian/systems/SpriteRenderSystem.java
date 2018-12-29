package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.GameSprite;
import com.bahoga.nismian.components.Position;

public class SpriteRenderSystem extends EngineSystem {


    public SpriteRenderSystem(Engine engine) {
        super(engine);
    }

    @Override
    public void update(float deltaTime) {
        for (final Entity entity : getAll(GameSprite.class, Position.class)) {
            final GameSprite gameSprite = Mappers.gameSprite.get(entity);
            final Position position = Mappers.position.get(entity);
            gameSprite.render(position);
        }

    }
}
