package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.bahoga.nismian.components.Player;
import com.bahoga.nismian.components.Velocity;

public class InputSystem extends EngineSystem {
    public InputSystem(Engine engine) {
        super(engine);
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity : getAll(Player.class, Velocity.class)) {

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
        }
    }
}
