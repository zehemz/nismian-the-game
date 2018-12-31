package com.bahoga.nismian.systems;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.*;

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

        withComponents(GameSprite.class, ColorComponent.class,
                Position.class,
                Direction.class)
                .forEach(entity -> {
                    final GameSprite gameSprite = Mappers.gameSprite.get(entity);
                    final Position position = Mappers.position.get(entity);
                    final Direction direction = Mappers.direction.get(entity);
                    final ColorComponent color = Mappers.color.get(entity);


                    gameSprite.sprite.setCenter(position.get().x + Dimension.fromPixelToWoldDimen(gameSprite.sprite.getWidth() / 2f),
                            position.get().y + Dimension.fromPixelToWoldDimen(gameSprite.sprite.getHeight() / 2f));
                    //TODO remove - hack animations
                    if (direction.pos == Direction.Pos.LEFT) {
                        gameSprite.sprite.flip(true, false);
                    } else {
                        gameSprite.sprite.setRotation(direction.pos.angle);
                    }

                    gameSprite.sprite.setColor(color.tint);

                    gameSprite.sprite.draw(batch);
                });
        batch.end();

    }
}
