package com.bahoga.nismian.systems;

import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.ActionComponent;
import com.bahoga.nismian.components.Direction;
import com.bahoga.nismian.components.NPCComponent;
import com.bahoga.nismian.components.Velocity;

import java.util.Random;

import static com.bahoga.nismian.components.Velocity.DEFAULT_SPEED;

public class AiSystem extends EngineSystem {

    @Override
    public void update(float deltaTime) {

        withComponents(NPCComponent.class).forEach(entity -> {
            NPCComponent npcComponent = Mappers.npc.get(entity);
            if (npcComponent.shouldChange(deltaTime)) {
                if (getRandomBool() || getRandomBool()) {
                    final Velocity aiRandomVelocity = Velocity.STOP;
                    entity.add(new ActionComponent(ActionComponent.Action.IDLE));
                    entity.add(aiRandomVelocity);
                } else {
                    final Velocity aiRandomVelocity = getAIRandomVelocity();
                    entity.add(aiRandomVelocity);
                    entity.add(Direction.with(aiRandomVelocity));
                    entity.add(new ActionComponent(ActionComponent.Action.WALK));
                }
            }
        });
    }

    private Velocity getAIRandomVelocity() {

        int directionMult = getRandomBool() ? 1 : -1;
        boolean value = getRandomBool();
        return new Velocity(value ? directionMult * (DEFAULT_SPEED) : 0f, !value ? directionMult * DEFAULT_SPEED : 0);
    }

    private boolean getRandomBool() {
        final Random rand = new Random();
        return rand.nextInt(2) != 0;
    }
}
