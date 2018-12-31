package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bahoga.nismian.Constants;

public class GameSprite extends Component {

    public final Sprite sprite;

    public GameSprite(final Sprite sprite) {
        this.sprite = sprite;
    }
}
