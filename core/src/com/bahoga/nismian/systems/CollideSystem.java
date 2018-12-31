package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Rectangle;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.Dimension;
import com.bahoga.nismian.components.Position;
import com.bahoga.nismian.components.Velocity;

public class CollideSystem extends EngineSystem {

    @Override
    public void update(float deltaTime) {
        ImmutableArray<Entity> entities = withComponentsList(Position.class,
                Dimension.class,
                Velocity.class);

        int total = entities.size();

        for (int i = 0; i < total; i++) {   // 0; 1;
            for (int j = i + 1; j < total; j++) { // 1,2,3....10 ; 2,3,...10
                Entity entity1 = entities.get(i);
                Entity entity2 = entities.get(j);
                if (collide(entity1, entity2)) {
                    final Velocity vel1 = Mappers.velocity.get(entity1);
                    final Position pos1 = Mappers.position.get(entity1);
                    final Velocity vel2 = Mappers.velocity.get(entity2);
                    final Position pos2 = Mappers.position.get(entity2);

                    // Correct position, previous position.
                    if (!vel1.equals(Velocity.STOP)) {
                        entity1.add(Position.with(pos1, vel1, -deltaTime));
                        entity1.add(Velocity.STOP);
                    }

                    if (!vel2.equals(Velocity.STOP)) {
                        entity2.add(Position.with(pos2, vel2, -deltaTime));
                        entity2.add(Velocity.STOP);
                    }

                }

            }
        }
    }

    private boolean collide(Entity entity1, Entity entity2) {
        Position pos1 = Mappers.position.get(entity1);
        Position pos2 = Mappers.position.get(entity2);
        Dimension dimen1 = Mappers.dimension.get(entity1);
        Dimension dimen2 = Mappers.dimension.get(entity2);
        Rectangle rectangle = new Rectangle(pos1.get().x, pos1.get().y, dimen1.width, dimen1.height);
        Rectangle rectangle2 = new Rectangle(pos2.get().x, pos2.get().y, dimen2.width, dimen2.height);
        return rectangle.overlaps(rectangle2);
    }
}
