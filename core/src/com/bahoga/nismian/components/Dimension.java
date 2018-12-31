package com.bahoga.nismian.components;


import com.badlogic.ashley.core.Component;

public class Dimension extends Component {

    public final int width;
    public final int height;

    /**
     * Dimension constructor
     *
     * @param width  in world size
     * @param height in world height
     */
    public Dimension(final int width, final int height) {
        this.width = width;
        this.height = height;
    }
}
