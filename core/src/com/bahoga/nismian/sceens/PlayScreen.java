package com.bahoga.nismian.sceens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        engine.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }
}
