package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.bahoga.nismian.components.*;

public class InputSystem extends EngineSystem {

    @Override
    public void update(float deltaTime) {
        withComponents(Player.class).forEach(this::checkActions);
    }

    private void checkActions(final Entity entity) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            entity.add(new ActionComponent(ActionComponent.Action.ATTACK));
            entity.add(new BusyComponent(2f));
        } else {
            checkMovement(entity);
        }
    }

    private void checkMovement(final Entity entity) {
        float x, y = x = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y -= 100f;
            isMoving(entity, x, y, Direction.Pos.DOWN);
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += 100f;
            isMoving(entity, x, y, Direction.Pos.UP);
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= 100f;
            isMoving(entity, x, y, Direction.Pos.LEFT);
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += 100f;
            isMoving(entity, x, y, Direction.Pos.RIGHT);
            return;
        }

        entity.add(new Velocity(x, y));
    }

    private void isMoving(Entity entity, float x, float y, Direction.Pos pos) {
        entity.add(new Velocity(x, y));
        entity.add(new Direction(pos));
    }
}
