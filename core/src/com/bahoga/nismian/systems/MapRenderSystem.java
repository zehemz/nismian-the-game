package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.utils.ImmutableArray;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.CameraComponent;
import com.bahoga.nismian.components.MapComponent;

public class MapRenderSystem extends EngineSystem {

    @Override
    public void update(final float deltaTime) {
        ImmutableArray<Entity> all = getAll(CameraComponent.class);
        ImmutableArray<Entity> maps = getAll(MapComponent.class);
        for (final Entity map : maps) {
            MapComponent mapComponent = Mappers.map.get(map);
            for (final Entity camera : all) {
                CameraComponent cameraComponent = Mappers.camera.get(camera);
                mapComponent.mapRenderer.setView(cameraComponent.orthographicCamera);
                mapComponent.mapRenderer.render();
            }
        }
    }
}
