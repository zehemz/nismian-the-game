package com.bahoga.nismian.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.bahoga.nismian.components.Player;
import com.bahoga.nismian.components.Velocity;

public class InputSystem extends EngineSystem {

    @Override
    public void update(float deltaTime) {
        withComponents(Player.class, Velocity.class)
                .forEach(entity -> {
                    entity.remove(Velocity.class);

                    float x, y = x = 0;
                    if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                        y -= 100f;
                    }
                    if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                        y += 100f;
                    }
                    if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                        x -= 100f;
                    }
                    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                        x += 100f;
                    }

                    entity.add(new Velocity(x, y));

                });
    }
}
