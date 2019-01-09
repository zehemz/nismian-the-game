package com.bahoga.nismian.components;


import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Rectangle;
import com.bahoga.nismian.Constants;

public class Dimension extends Component {

    public final static Dimension DEFAULT_DIMENSION = new Dimension(0.5f, 0.5f);

    public final float width;
    public final float height;

    /**
     * Dimension constructor
     *
     * @param width  in world size
     * @param height in world height
     */
    public Dimension(final float width, final float height) {
        this.width = width;
        this.height = height;
    }

    public static Dimension with(Rectangle rectangle) {
        return new Dimension(fromPixelToWoldDimen(rectangle.width), fromPixelToWoldDimen(rectangle.height));
    }

    public static float fromPixelToWoldDimen(float pixels) {
        return pixels / Constants.TILE_SIZE;
    }
}
