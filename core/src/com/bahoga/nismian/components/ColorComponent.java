package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;

public class ColorComponent extends Component {

    public Color tint;

    public ColorComponent(Color tint) {
        this.tint = tint;
    }


}
