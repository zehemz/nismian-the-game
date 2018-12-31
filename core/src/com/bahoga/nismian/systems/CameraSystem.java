package com.bahoga.nismian.systems;

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
        withComponents(Player.class, Position.class)
                .forEach(entity -> {
                    final Position position = Mappers.position.get(entity);
                    final OrthographicCamera cam = cameraComponent.cam;
                    cam.position.x = position.x;
                    cam.position.y = position.y;
                    cam.update();
                });
    }
}
