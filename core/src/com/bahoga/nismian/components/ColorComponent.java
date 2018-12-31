package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;

public class ColorComponent extends Component {

    public final static ColorComponent GREEN = new ColorComponent(new Color(0, 1f, 0, 1));
    public final static ColorComponent YELLOW = new ColorComponent(new Color(1f, 1f, 0, 1));

    public Color tint;

    public ColorComponent(Color tint) {
        this.tint = tint;
    }


}
