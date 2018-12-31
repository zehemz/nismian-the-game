package com.bahoga.nismian.systems;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bahoga.nismian.Constants;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.CameraComponent;
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

        withComponents(GameSprite.class, Position.class)
                .forEach(entity -> {
                    final GameSprite gameSprite = Mappers.gameSprite.get(entity);
                    final Position position = Mappers.position.get(entity);

                    gameSprite.sprite.setScale(1 / Constants.TILE_SIZE);
//                    gameSprite.sprite.setCenter(position.x, position.y);
//                    gameSprite.sprite.setPosition(Constants.fromPixelToWoldDimen(position.x), Constants.fromPixelToWoldDimen(position.y));
                    gameSprite.sprite.setCenter(position.x +
                            Constants.fromPixelToWoldDimen(gameSprite.sprite.getWidth() / 2f),
                            position.y + Constants.fromPixelToWoldDimen(gameSprite.sprite.getHeight() / 2f));
                    gameSprite.sprite.draw(batch);
                });
        batch.end();

    }
}
