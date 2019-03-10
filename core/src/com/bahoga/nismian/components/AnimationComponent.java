package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationComponent extends Component {

    private float stateTime;
    private Animation<TextureRegion> animation;
    public ActionComponent.Action action;


    public AnimationComponent(final Animation animation, ActionComponent.Action action) {
        this.animation = animation;
        this.action = action;
        stateTime = 0f;
    }

    public Sprite getCurrent(final float delta) {
        stateTime += delta;
        return new Sprite(animation.getKeyFrame(stateTime, true));
    }
}
