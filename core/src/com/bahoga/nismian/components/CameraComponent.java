package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraComponent extends Component {

    public static final int VISIBLE_VIEWPORT_WIDTH = 30;
    public static final int VISIBLE_VIEWPORT_HEIGHT = 30;
    public final OrthographicCamera orthographicCamera;

    public CameraComponent(float tailSize, float ratioHeight) {
        orthographicCamera = new OrthographicCamera(VISIBLE_VIEWPORT_WIDTH * tailSize,
                VISIBLE_VIEWPORT_HEIGHT * tailSize * ratioHeight);

        orthographicCamera.position.set(orthographicCamera.viewportWidth / 2f, orthographicCamera.viewportHeight / 2f, 0);
        orthographicCamera.zoom = 1f;
        orthographicCamera.update();
    }
}
