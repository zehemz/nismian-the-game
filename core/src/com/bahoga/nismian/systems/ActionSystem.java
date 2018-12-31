package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.Entity;
import com.bahoga.nismian.AnimationFactory;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.ActionComponent;
import com.bahoga.nismian.components.AnimationComponent;

public class ActionSystem extends EngineSystem {


    @Override
    public void update(float deltaTime) {
        withComponents(ActionComponent.class, AnimationComponent.class).forEach(entity -> {
            replaceAnimation(entity, Mappers.action.get(entity).action);
        });
    }

    private void replaceAnimation(Entity entity, ActionComponent.Action action) {
        final AnimationComponent animationComponent = Mappers.animation.get(entity);
        if (!animationComponent.action.equals(action)) {
            entity.add(AnimationFactory.getSkellByAction(action));
        }
    }
}
