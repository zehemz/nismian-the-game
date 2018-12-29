package com.bahoga.nismian.systems;

import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.CameraComponent;
import com.bahoga.nismian.components.MapComponent;


public class MapRenderSystem extends EngineSystem {

    @Override
    public void update(final float deltaTime) {
        doApply(map -> doApply(camera -> {
            MapComponent mapComponent = Mappers.map.get(map);
            CameraComponent cameraComponent = Mappers.camera.get(camera);
            mapComponent.mapRenderer.setView(cameraComponent.orthographicCamera);
            mapComponent.mapRenderer.render();
        }, CameraComponent.class), MapComponent.class);
    }
}
