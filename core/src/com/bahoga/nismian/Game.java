package com.bahoga.nismian;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.bahoga.nismian.entities.EntityFactory;
import com.bahoga.nismian.maps.MapFactory;
import com.bahoga.nismian.systems.*;

public class Game extends ApplicationAdapter {

    private Engine engine;
    private OrthographicCamera orthographicCamera;

//    private static final float VIEWPORT_WIDHT = 1920 / 1080;
//    private static final float VIEWPORT_HEIGTH = 1080 / 1920;

    @Override
    public void create() {
        engine = new Engine();
        orthographicCamera = new OrthographicCamera(1920, 1080);
        orthographicCamera.update();
//        orthographicCamera.setToOrtho(false, 30 * 1.7F, 30);
//        orthographicCamera.setToOrtho(false, 30 * 1.7F, 30);
        MapRenderSystem mapRenderSystem = new MapRenderSystem(MapFactory.create(MapFactory.GameMap.MAIN_MAP), orthographicCamera);
        engine.addSystem(mapRenderSystem);
        engine.addSystem(new SpriteRenderSystem(engine));
        engine.addSystem(new MovementSystem(engine));
        engine.addSystem(new InputSystem(engine));
        engine.addSystem(new CameraSystem(engine, orthographicCamera));
        engine.addEntity(EntityFactory.create(EntityFactory.GameEntity.PLAYER));

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        engine.update(Gdx.graphics.getDeltaTime());
    }
}
