package com.bahoga.nismian.systems;

import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.Position;
import com.bahoga.nismian.components.Velocity;

public class MovementSystem extends EngineSystem {

    @Override
    public void update(float deltaTime) {
        withComponents(Position.class, Velocity.class)
                .forEach(entity -> {
                    Position position = Mappers.position.get(entity);
                    Velocity velocity = Mappers.velocity.get(entity);
                    entity.remove(Position.class);
                    entity.add(new Position(position.x + velocity.x * deltaTime, position.y + velocity.y * deltaTime));
                });
    }
}
