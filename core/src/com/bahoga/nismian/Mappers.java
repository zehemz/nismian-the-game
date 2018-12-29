package com.bahoga.nismian;

import com.badlogic.ashley.core.ComponentMapper;
import com.bahoga.nismian.components.GameSprite;
import com.bahoga.nismian.components.MapComponent;
import com.bahoga.nismian.components.Position;
import com.bahoga.nismian.components.Velocity;
import com.bahoga.nismian.components.CameraComponent;

public final class Mappers {

    public static final ComponentMapper<MapComponent> map = ComponentMapper.getFor(MapComponent.class);
    public static final ComponentMapper<CameraComponent> camera = ComponentMapper.getFor(CameraComponent.class);
    public static final ComponentMapper<Position> position = ComponentMapper.getFor(Position.class);
    public static final ComponentMapper<Velocity> velocity = ComponentMapper.getFor(Velocity.class);
    public static final ComponentMapper<GameSprite> gameSprite = ComponentMapper.getFor(GameSprite.class);


    private Mappers() {
    }
}
