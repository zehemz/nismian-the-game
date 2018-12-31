package com.bahoga.nismian.systems;

import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.CameraComponent;
import com.bahoga.nismian.components.MapComponent;


public class MapRenderSystem extends EngineSystem {

    @Override
    public void update(final float deltaTime) {
        withComponents(MapComponent.class)
                .forEach(map ->
                        withComponents(CameraComponent.class)
                                .forEach(
                                        camera -> {
                                            MapComponent mapComponent = Mappers.map.get(map);
                                            CameraComponent cameraComponent = Mappers.camera.get(camera);
                                            cameraComponent.cam.update();
                                            mapComponent.mapRenderer.setView(cameraComponent.cam);
                                            mapComponent.mapRenderer.render();
                                        }));
    }
}
