package com.bahoga.nismian.systems;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bahoga.nismian.Constants;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.CameraComponent;
import com.bahoga.nismian.components.ColorComponent;
import com.bahoga.nismian.components.GameSprite;
import com.bahoga.nismian.components.Position;

public class SpriteRenderSystem extends EngineSystem {

    private CameraComponent cameraComponent;
    private final SpriteBatch batch;

    public SpriteRenderSystem(CameraComponent cameraComponent, final SpriteBatch batch) {
        this.cameraComponent = cameraComponent;
        this.batch = batch;
    }

    @Override
    public void update(float deltaTime) {
        batch.setProjectionMatrix(cameraComponent.cam.combined);
        batch.begin();

        withComponents(GameSprite.class, ColorComponent.class, Position.class)
                .forEach(entity -> {
                    final GameSprite gameSprite = Mappers.gameSprite.get(entity);
                    final Position position = Mappers.position.get(entity);
                    final ColorComponent color = Mappers.color.get(entity);
                    gameSprite.sprite.setColor(color.tint);
                    gameSprite.sprite.setCenter(position.get().x +
                                    Constants.fromPixelToWoldDimen(gameSprite.sprite.getWidth() / 2f),
                            position.get().y + Constants.fromPixelToWoldDimen(gameSprite.sprite.getHeight() / 2f));
                    gameSprite.sprite.draw(batch);
                });
        batch.end();

    }
}
