package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;

import java.util.Arrays;

public class ActionComponent extends Component {

    public final Action action;

    public enum Action {
        IDLE,
        ATTACK,
        WALK;

        public static Iterable<Action> all() {
            return Arrays.asList(IDLE, ATTACK, WALK);
        }
    }

    public ActionComponent(final Action action) {
        this.action = action;
    }
}
