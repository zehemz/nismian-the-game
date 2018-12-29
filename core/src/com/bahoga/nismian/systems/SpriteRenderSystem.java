package com.bahoga.nismian.systems;

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
        applyToAll(entity -> {
            final GameSprite gameSprite = Mappers.gameSprite.get(entity);
            gameSprite.render(cameraComponent);
        }, GameSprite.class, Position.class);
    }
}
