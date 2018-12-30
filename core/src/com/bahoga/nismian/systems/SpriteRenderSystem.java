package com.bahoga.nismian.systems;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
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
        batch.begin();
        withComponents(GameSprite.class, Position.class)
                .forEach(entity -> {
                    final GameSprite gameSprite = Mappers.gameSprite.get(entity);
                    final Position position = Mappers.position.get(entity);

                    Vector3 pos = cameraComponent.orthographicCamera
                            .project(new Vector3(position.x, position.y, 0));

                    gameSprite.sprite.setCenter(pos.x, pos.y);
                    gameSprite.sprite.draw(batch);
                });
        batch.end();
    }
}
