package com.bahoga.nismian;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.bahoga.nismian.components.CameraComponent;
import com.bahoga.nismian.components.MapComponent;
import com.bahoga.nismian.entities.EntityFactory;
import com.bahoga.nismian.entities.EntityFactory.GameEntity;
import com.bahoga.nismian.entities.NPCFactory;
import com.bahoga.nismian.entities.WallFactory;
import com.bahoga.nismian.maps.MapFactory;
import com.bahoga.nismian.sceens.PlayScreen;
import com.bahoga.nismian.systems.*;

public class NismianGame extends Game {

    private Engine engine;
    private SpriteBatch batch;

    @Override
    public void create() {

        batch = new SpriteBatch();
        engine = new Engine();

        final CameraComponent cameraComponent = createCamera();

        final TiledMap tiledMap = MapFactory.create(MapFactory.GameMap.MAIN_MAP);
        Entity mapEntity = new Entity();
        mapEntity.add(new MapComponent(tiledMap));
        engine.addEntity(mapEntity);

        Iterable<Entity> npcs = NPCFactory.create(tiledMap);
        Iterable<Entity> collisionWalls = WallFactory.create(tiledMap);
        npcs.forEach(entity -> engine.addEntity(entity));
        collisionWalls.forEach(entity -> engine.addEntity(entity));

        engine.addSystem(new BusySystem());
        engine.addSystem(new InputSystem());
        engine.addSystem(new AiSystem());
        engine.addSystem(new ActionSystem());
        engine.addSystem(new AnimationSystem());
        // This system applies movement to all units
        engine.addSystem(new MovementSystem());
        // this system should be after movement system, cause this will correct the position and velocity
        // if units overlaps.
        engine.addSystem(new CollideSystem());
        engine.addSystem(new CameraSystem(cameraComponent));
        engine.addSystem(new MapRenderSystem());
        engine.addSystem(new SpriteRenderSystem(cameraComponent, batch));

        engine.addEntity(EntityFactory.create(GameEntity.PLAYER));

        addScreen();
    }

    private void addScreen() {
        PlayScreen screen = new PlayScreen(batch, engine);
        setScreen(screen);
    }

    private CameraComponent createCamera() {
        final Entity camera = EntityFactory.create(GameEntity.CAMERA);
        final CameraComponent cameraComponent = Mappers.camera.get(camera);
        engine.addEntity(camera);
        return cameraComponent;
    }

    @Override
    public void resize(int width, int height) {
        Family family = Family.all(CameraComponent.class).get();
        engine.getEntitiesFor(family).forEach(entity -> {
            Mappers.camera.get(entity).setViewportSize(width, height);
        });
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
