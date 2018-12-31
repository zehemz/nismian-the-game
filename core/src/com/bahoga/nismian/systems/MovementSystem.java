package com.bahoga.nismian.systems;

import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.BusyComponent;
import com.bahoga.nismian.components.Position;
import com.bahoga.nismian.components.Velocity;

public class MovementSystem extends EngineSystem {

    @Override
    public void update(float delta) {
        withComponents(Position.class, Velocity.class, BusyComponent.class)
                .forEach(entity -> {

                    BusyComponent busyComponent = Mappers.busy.get(entity);
                    if (busyComponent.isBusy()) return;

                    Position position = Mappers.position.get(entity);
                    Velocity velocity = Mappers.velocity.get(entity);

                    entity.remove(Position.class);
                    entity.add(new Position(position.x + velocity.x * delta, position.y + velocity.y * delta));
                });
    }
}
