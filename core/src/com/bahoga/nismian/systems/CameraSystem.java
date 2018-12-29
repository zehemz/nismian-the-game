package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.CameraComponent;
import com.bahoga.nismian.components.Player;
import com.bahoga.nismian.components.Position;

public class CameraSystem extends EngineSystem {


    private final CameraComponent cameraComponent;

    public CameraSystem(final CameraComponent cameraComponent) {
        this.cameraComponent = cameraComponent;
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity : getAll(Player.class, Position.class)) {
            final Position position = Mappers.position.get(entity);
            final OrthographicCamera cam = cameraComponent.orthographicCamera;
            cam.position.x = position.x;
            cam.position.y = position.y;
            cam.update();
        }
    }
}
