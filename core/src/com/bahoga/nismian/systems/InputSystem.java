package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.bahoga.nismian.Mappers;
import com.bahoga.nismian.components.*;

public class InputSystem extends EngineSystem {

    @Override
    public void update(float deltaTime) {
        withComponents(Player.class).forEach(this::checkActions);
    }

    private void checkActions(final Entity entity) {

        BusyComponent busyComponent = Mappers.busy.get(entity);
        if (busyComponent.isBusy()) return;

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            entity.add(new ActionComponent(ActionComponent.Action.ATTACK));
            entity.add(new BusyComponent(2f));
        } else {
            checkMovement(entity);
        }
    }

    private void checkMovement(final Entity entity) {
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            entity.add(new Velocity(0, -100));
            entity.add(new Direction(Direction.Pos.DOWN));
            entity.add(new ActionComponent(ActionComponent.Action.WALK));
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            entity.add(new Velocity(0, 100));
            entity.add(new Direction(Direction.Pos.UP));
            entity.add(new ActionComponent(ActionComponent.Action.WALK));
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            entity.add(new Velocity(-100, 0));
            entity.add(new Direction(Direction.Pos.LEFT));
            entity.add(new ActionComponent(ActionComponent.Action.WALK));
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            entity.add(new Velocity(100, 0));
            entity.add(new Direction(Direction.Pos.RIGHT));
            entity.add(new ActionComponent(ActionComponent.Action.WALK));
            return;
        }

        entity.add(new Velocity(0, 0));
        entity.add(new ActionComponent(ActionComponent.Action.IDLE));
    }
}
