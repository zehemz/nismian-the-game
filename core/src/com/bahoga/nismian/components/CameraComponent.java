package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraComponent extends Component {

    public static final int VISIBLE_VIEWPORT_WIDTH = 30;
    public static final int VISIBLE_VIEWPORT_HEIGHT = 30;
    public final OrthographicCamera orthographicCamera;

    private static final float TILE_SIZE = 32f;

    public CameraComponent(float width, float height) {

        orthographicCamera = new OrthographicCamera(VISIBLE_VIEWPORT_WIDTH * TILE_SIZE,
                VISIBLE_VIEWPORT_HEIGHT * TILE_SIZE * (height/width));

        orthographicCamera.zoom = 1f;
    }

    public void setViewportSize(float width, float height)
    {
        orthographicCamera.viewportWidth = VISIBLE_VIEWPORT_WIDTH * TILE_SIZE;
        orthographicCamera.viewportHeight = VISIBLE_VIEWPORT_HEIGHT * TILE_SIZE * (height/width);
    }
}
