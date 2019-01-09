package com.bahoga.nismian;


import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.bahoga.nismian.components.ActionComponent;
import com.bahoga.nismian.components.AnimationComponent;

import java.util.HashMap;
import java.util.Map;


public enum AnimationFactory {

    INSTANCE;

    private static final float FRAME_DURATION = 0.10f;
    private static final int WALK_FRAME_COLS = 13;
    private static final int IDLE_COLS = 11;
    private static final int ATTACK_COLS = 18;

    private final Map<ActionComponent.Action, Array<TextureRegion>> frames;
    //walk animation: 13 frames, de 22 x 33 pixel
    //idle animation: 11 frames de 24 x 32 pixel
    //attack animation: 18 frames de 43 x 37 pixel
    private static final int WALK_FRAME_W = 22;
    private static final int WALK_FRAME_H = 33;
    private static final int IDLE_FRAME_W = 24;
    private static final int IDLE_FRAME_H = 32;
    private static final int ATTACK_FRAME_W = 43;
    private static final int ATTACK_FRAME_H = 37;

    AnimationFactory() {
        frames = new HashMap<>();
        ActionComponent.Action.all().forEach(action -> {
            frames.put(action, load(action));
        });
    }

    private Array<TextureRegion> load(ActionComponent.Action action) {

        int cols;
        int w, h;

        //FIX  - No tienen las mismas cols las anim
        switch (action) {
            case IDLE:
                cols = IDLE_COLS;
                w = IDLE_FRAME_W;
                h = IDLE_FRAME_H;
                break;
            case WALK:
                cols = WALK_FRAME_COLS;
                w = WALK_FRAME_W;
                h = WALK_FRAME_H;
                break;
            case ATTACK:
                cols = ATTACK_COLS;
                w = ATTACK_FRAME_W;
                h = ATTACK_FRAME_H;
                break;
            default:
                cols = WALK_FRAME_COLS;
                w = WALK_FRAME_W;
                h = WALK_FRAME_H;
                break;
        }

        //Parte del atlas que corresponde a la acción
        //Se la referencia por el nombre del archivo con el que hizo
        //el paquete de texturas (TextureAtlas)
        TextureRegion actionRegion = NismianGame.getAtlas().findRegion(action.name().toLowerCase());

        Array<TextureRegion> frames = new Array<>();

        //Tomar cada frame de la region, sabiendo width y height del frame
        for (int i = 0; i < cols; i++) {
            frames.add(new TextureRegion(actionRegion, i * w, 0, w, h));
        }

        return frames;
    }

    public AnimationComponent getSkellByAction(ActionComponent.Action action) {
        return new AnimationComponent(new Animation(FRAME_DURATION, frames.get(action)), action);
    }
}
