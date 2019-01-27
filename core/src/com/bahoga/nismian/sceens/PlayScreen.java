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
import com.bahoga.nismian.dialog.Dialog;
import com.bahoga.nismian.dialog.DialogLoader;
import com.bahoga.nismian.dialog.DialogStage;

public class PlayScreen extends ScreenAdapter {
    private final SpriteBatch batch;
    private final Engine engine;

    private final DialogStage dialogStage;

    public PlayScreen(final SpriteBatch batch, final Engine engine) {
        this.batch = batch;
        this.engine = engine;

        dialogStage = new DialogStage();
        Gdx.input.setInputProcessor(dialogStage);

        //el dialog se carga y corre según eventos, esto es solo para probar
        dialogStage.setDialog(DialogLoader.loadDialog("dialogs/dialog1.txt"));
        dialogStage.runDialog();
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.Z))
        {
            final Family family = Family.all(CameraComponent.class).get();
            engine.getEntitiesFor(family).forEach(entity -> {
                CameraComponent cameraComp = Mappers.camera.get(entity);
                cameraComp.cam.zoom -= 0.2f;
            });
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.X))
        {
            final Family family = Family.all(CameraComponent.class).get();
            engine.getEntitiesFor(family).forEach(entity -> {
                CameraComponent cameraComp = Mappers.camera.get(entity);
                cameraComp.cam.zoom += 0.2f;
            });
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        engine.update(delta);

        dialogStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose()
    {
        if(dialogStage != null)
            dialogStage.dispose();
    }
}
