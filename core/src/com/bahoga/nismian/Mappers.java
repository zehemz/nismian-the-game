package com.bahoga.nismian;

import com.badlogic.ashley.core.ComponentMapper;
import com.bahoga.nismian.components.*;

public final class Mappers {

    public static final ComponentMapper<MapComponent> map = ComponentMapper.getFor(MapComponent.class);
    public static final ComponentMapper<CameraComponent> camera = ComponentMapper.getFor(CameraComponent.class);
    public static final ComponentMapper<Position> position = ComponentMapper.getFor(Position.class);
    public static final ComponentMapper<Velocity> velocity = ComponentMapper.getFor(Velocity.class);
    public static final ComponentMapper<GameSprite> gameSprite = ComponentMapper.getFor(GameSprite.class);
    public static final ComponentMapper<AnimationComponent> animation = ComponentMapper.getFor(AnimationComponent.class);
    public static final ComponentMapper<ActionComponent> action = ComponentMapper.getFor(ActionComponent.class);
    public static final ComponentMapper<Direction> direction = ComponentMapper.getFor(Direction.class);
    public static final ComponentMapper<BusyComponent> busy = ComponentMapper.getFor(BusyComponent.class);
//    public static final ComponentMapper<Direction> direction = ComponentMapper.getFor(Direction.class);


    private Mappers() {
    }
}
