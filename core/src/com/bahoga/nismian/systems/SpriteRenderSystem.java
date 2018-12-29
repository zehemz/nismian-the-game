package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector3;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.CameraComponent;
import com.bahoga.nismian.components.GameSprite;
import com.bahoga.nismian.components.Position;

public class SpriteRenderSystem extends EngineSystem {

    private CameraComponent cameraComponent;

    public SpriteRenderSystem(CameraComponent cameraComponent) {
        this.cameraComponent = cameraComponent;
    }

    @Override
    public void update(float deltaTime) {
        for (final Entity entity : getAll(GameSprite.class, Position.class)) {
            final GameSprite gameSprite = Mappers.gameSprite.get(entity);

            gameSprite.render(cameraComponent);
        }

    }
}
