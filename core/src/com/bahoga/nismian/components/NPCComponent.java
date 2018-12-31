package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;

public class NPCComponent extends Component {
    private float changeTime = 1f;

    public boolean shouldChange(float deltaTime) {
        if (changeTime - deltaTime < 0) {
            changeTime = 1f;
            return true;
        } else {
            changeTime -= deltaTime;
            return false;
        }
    }
}
