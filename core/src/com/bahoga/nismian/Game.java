package com.bahoga.nismian;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bahoga.nismian.components.CameraComponent;
import com.bahoga.nismian.entities.EntityFactory;
import com.bahoga.nismian.systems.*;

public class Game extends ApplicationAdapter {


    private Engine engine;
    private SpriteBatch batch;

    @Override
    public void create() {

        batch = new SpriteBatch();

        engine = new Engine();

        engine.addEntity(EntityFactory.create(EntityFactory.GameEntity.MAP));
        engine.addEntity(EntityFactory.create(EntityFactory.GameEntity.PLAYER));

        Entity entity = EntityFactory.create(EntityFactory.GameEntity.CAMERA);
        final CameraComponent cameraComponent = Mappers.camera.get(entity);
        engine.addEntity(entity);

        engine.addSystem(new InputSystem());
        engine.addSystem(new MovementSystem());
        engine.addSystem(new CameraSystem(cameraComponent));
        engine.addSystem(new MapRenderSystem());
        engine.addSystem(new SpriteRenderSystem(cameraComponent, batch));
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        engine.update(Gdx.graphics.getDeltaTime());
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
