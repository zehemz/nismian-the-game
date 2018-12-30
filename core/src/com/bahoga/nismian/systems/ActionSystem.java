package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.Entity;
import com.bahoga.nismian.AnimationFactory;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.*;

public class ActionSystem extends EngineSystem {


    @Override
    public void update(float deltaTime) {
        withComponents(ActionComponent.class,
                AnimationComponent.class,
                Velocity.class,
                Direction.class,
                BusyComponent.class).forEach(entity -> {

            ActionComponent.Action action = getNewAction(entity, deltaTime);
            entity.add(new ActionComponent(action));
            replaceAnimation(entity, action);
        });
    }

    private ActionComponent.Action getNewAction(Entity entity, float deltaTime) {

        final Velocity velocity = Mappers.velocity.get(entity);
        final ActionComponent actionComponent = Mappers.action.get(entity);
        final BusyComponent busy = Mappers.busy.get(entity);

        if (busy.isBusy()) { // Si está busy, mantiene la acción, resta delta para el busy.
            return actionComponent.action;
        } else {
            // si no esta busy, puede hacer cosas.
            if (velocity.isCero()) {
                return ActionComponent.Action.IDLE;
            } else {
                return ActionComponent.Action.WALK;
            }
        }
    }

    private void replaceAnimation(Entity entity, ActionComponent.Action action) {
        //De momento la dirección no importa porque no tengo assets.
        Direction direction = Mappers.direction.get(entity);

        final AnimationComponent animationComponent = Mappers.animation.get(entity);
        if (!animationComponent.action.equals(action)) {
            entity.add(AnimationFactory.getSkellByAction(action));
        }
    }
}
