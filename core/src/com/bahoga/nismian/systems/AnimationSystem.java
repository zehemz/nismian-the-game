package com.bahoga.nismian.systems;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.AnimationComponent;
import com.bahoga.nismian.components.GameSprite;

public class AnimationSystem extends EngineSystem {

    @Override
    public void update(float deltaTime) {
        withComponents(AnimationComponent.class).forEach(entity -> {
            AnimationComponent animationComponent = Mappers.animation.get(entity);
            Sprite current = animationComponent.getCurrent(deltaTime);
            entity.add(new GameSprite(current));
        });
    }
}
