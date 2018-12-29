package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;

public class GameSprite extends Component {

    private final ShapeRenderer shapeRenderer;

    public GameSprite(GameGraphic player) {
        shapeRenderer = new ShapeRenderer();
    }

    public enum GameGraphic {
        PLAYER();

        GameGraphic() {
        }
    }

    public void render(CameraComponent cameraComponent) {
        shapeRenderer.begin(Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.circle(cameraComponent.orthographicCamera.viewportWidth / 2f, cameraComponent.orthographicCamera.viewportHeight / 2f, 100);
        shapeRenderer.end();
    }
}
