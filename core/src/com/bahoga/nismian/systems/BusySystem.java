package com.bahoga.nismian.systems;

import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.BusyComponent;

public class BusySystem extends EngineSystem {

    @Override
    public void update(float deltaTime) {
        withComponents(BusyComponent.class).forEach(entity -> {
            BusyComponent busyComponent = Mappers.busy.get(entity);
            busyComponent.update(deltaTime);
        });
    }
}
