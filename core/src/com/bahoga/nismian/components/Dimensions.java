package com.bahoga.nismian.components;


import com.badlogic.ashley.core.Component;

public class Dimensions extends Component {

    public final int width;
    public final int height;

    public Dimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
