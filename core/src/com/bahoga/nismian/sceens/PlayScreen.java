package com.bahoga.nismian.sceens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.CameraComponent;

public class PlayScreen extends ScreenAdapter {
    private final SpriteBatch batch;
    private final Engine engine;

    public PlayScreen(final SpriteBatch batch, final Engine engine) {
        this.batch = batch;
        this.engine = engine;
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.Z))
        {
            Family family = Family.all(CameraComponent.class).get();
            engine.getEntitiesFor(family).forEach(entity -> {
                CameraComponent cameraComp = Mappers.camera.get(entity);
                cameraComp.cam.zoom -= 0.2f;
            });
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.X))
        {
            Family family = Family.all(CameraComponent.class).get();
            engine.getEntitiesFor(family).forEach(entity -> {
                CameraComponent cameraComp = Mappers.camera.get(entity);
                cameraComp.cam.zoom += 0.2f;
            });
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        engine.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

}
