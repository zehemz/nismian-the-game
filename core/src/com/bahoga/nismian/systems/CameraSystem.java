package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.bahoga.nismian.components.Player;
import com.bahoga.nismian.components.Position;

public class CameraSystem extends EngineSystem {
    private OrthographicCamera orthographicCamera;

    public CameraSystem(Engine engine, OrthographicCamera orthographicCamera) {
        super(engine);
        this.orthographicCamera = orthographicCamera;
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity : getAll(Player.class, Position.class)) {
//            final Position position = Mappers.position.get(entity);
//            Vector3 project = orthographicCamera.project(new Vector3(position.x, position.y, 0));
//            orthographicCamera.position.set(position.x, position.y, 0);
            orthographicCamera.update();
        }
    }
}
