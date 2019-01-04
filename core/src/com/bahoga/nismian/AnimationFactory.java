package com.bahoga.nismian;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.bahoga.nismian.components.ActionComponent;
import com.bahoga.nismian.components.AnimationComponent;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public enum AnimationFactory {

    INSTANCE;

    private static final float FRAME_DURATION = 0.10f;
    private static final int WALK_FRAME_COLS = 13;
    private static final int FRAME_ROWS = 1;
    private static final int IDLE_COLS = 11;
    private static final int ATTACK_COLS = 18;

    private final Map<ActionComponent.Action, TextureRegion[]> frames;

    AnimationFactory() {
        frames = new HashMap<>();
        ActionComponent.Action.all().forEach(action -> {
            frames.put(action, load(action));
        });
    }

    private TextureRegion[] load(ActionComponent.Action action) {

        Texture texture = new Texture(Gdx.files.internal(String.format(Locale.US, "sprites/npc/skelleton/%s.png",
                action.name().toLowerCase()
        )));


        int cols;

        //FIX  - No tienen las mismas cols las anim
        switch (action) {
            case IDLE:
                cols = IDLE_COLS;
                break;
            case WALK:
                cols = WALK_FRAME_COLS;
                break;
            case ATTACK:
                cols = ATTACK_COLS;
                break;
            default:
                cols = WALK_FRAME_COLS;
                break;
        }

        final TextureRegion[][] tmp = TextureRegion.split(texture,
                texture.getWidth() / cols,
                texture.getHeight() / FRAME_ROWS);

        final TextureRegion[] frames = new TextureRegion[cols * FRAME_ROWS];

        int index = 0;

        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < cols; j++) {
                frames[index++] = tmp[i][j];
            }
        }

        return frames;
    }

    public AnimationComponent getSkellByAction(ActionComponent.Action action) {
        return new AnimationComponent(new Animation(FRAME_DURATION, frames.get(action)), action);
    }
}
