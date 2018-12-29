package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.Position;
import com.bahoga.nismian.components.Velocity;

public class MovementSystem extends EngineSystem {

    public MovementSystem(Engine engine) {
        super(engine);
    }

    @Override
    public void update(float deltaTime) {
        for (final Entity entity : getAll(Position.class, Velocity.class)) {
            Position position = Mappers.position.get(entity);
            Velocity velocity = Mappers.velocity.get(entity);
            entity.remove(Position.class);
            entity.add(new Position(position.x + velocity.x * deltaTime, position.y +velocity.y * deltaTime));
        }
    }
}
