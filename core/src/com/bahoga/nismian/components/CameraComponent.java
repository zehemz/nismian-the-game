package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.bahoga.nismian.Constants;

public class CameraComponent extends Component {

    private static final float ZOOM = 0.5f;

    public final OrthographicCamera cam;

    public CameraComponent(float width, float height) {

        cam = new OrthographicCamera(Constants.VISIBLE_VIEWPORT_WIDTH,
                Constants.VISIBLE_VIEWPORT_HEIGHT * (height / width));

        cam.zoom = ZOOM;
    }

    public void setViewportSize(float width, float height) {
        cam.viewportHeight = Constants.VISIBLE_VIEWPORT_HEIGHT * (height / width);
        cam.update();
    }
}
