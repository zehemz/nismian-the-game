package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MapRenderSystem extends EntitySystem {

    private final OrthogonalTiledMapRenderer mapRenderer;
    private OrthographicCamera camera;

    public MapRenderSystem(final TiledMap map, final OrthographicCamera camera) {
        mapRenderer = new OrthogonalTiledMapRenderer(map, 1 / 32f);
        this.camera = camera;
    }

    @Override
    public void update(final float deltaTime) {
        mapRenderer.setView(camera);
        mapRenderer.render();

//        MapLayer mapLayer = map.getLayers().get(0);
//        MapObjects objects = mapLayer.getObjects();
//        for(MapObject object : objects) {
//            MapProperties properties = object.getProperties();
//            properties.
//        }
//        Gdx.gl.glClearColor(1, 1, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }
}
