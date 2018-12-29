package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.Gdx;
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

    public void render(Position position) {
        shapeRenderer.begin(Filled);
        shapeRenderer.setColor(Color.BLUE);
        Gdx.app.log("POS", position.toString());
        shapeRenderer.circle(position.x, position.y, 100);
        shapeRenderer.end();
    }
}
