package com.bahoga.nismian;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bahoga.nismian.components.CameraComponent;
import com.bahoga.nismian.entities.EntityFactory;
import com.bahoga.nismian.entities.EntityFactory.GameEntity;
import com.bahoga.nismian.sceens.PlayScreen;
import com.bahoga.nismian.systems.*;

public class NismianGame extends Game
{
    private Engine engine;
    private SpriteBatch batch;
    private PlayScreen screen;

    @Override
    public void create() {

        batch = new SpriteBatch();

        engine = new Engine();

        engine.addEntity(EntityFactory.create(GameEntity.MAP));
        engine.addEntity(EntityFactory.create(GameEntity.PLAYER));

        Entity entity = EntityFactory.create(GameEntity.CAMERA);
        final CameraComponent cameraComponent = Mappers.camera.get(entity);
        engine.addEntity(entity);

        engine.addSystem(new InputSystem());
        engine.addSystem(new MovementSystem());
        engine.addSystem(new CameraSystem(cameraComponent));
        engine.addSystem(new MapRenderSystem());
        engine.addSystem(new SpriteRenderSystem(cameraComponent, batch));

        screen = new PlayScreen(batch, engine);
        setScreen(screen);
    }

    @Override
    public void resize(int width, int height)
    {
        Family family = Family.all(CameraComponent.class).get();
        engine.getEntitiesFor(family).forEach(entity -> {
            Mappers.camera.get(entity).setViewportSize(width, height);
        });
    }

    @Override
    public void dispose()
    {
        batch.dispose();
    }
}
